package demo1;

import v44.User;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class requestResponseTask implements Runnable {
    private final Socket socket;
    private static final String DOC_BASE="D:\\web\\process\\docBase";
    private static final String sessionBase="D:\\web\\process\\src\\sessions";
    public requestResponseTask(Socket socket) {
        this.socket = socket;
    }
    private static final Map<String,String> mimeTypeMap=new HashMap<>();
    private static final String TEMPLATE_BASE="D:\\web\\process\\src\\template";
    static {
        mimeTypeMap.put("txt", "text/plain");
        mimeTypeMap.put("html", "text/html");
        mimeTypeMap.put("js", "application/javascript");
        mimeTypeMap.put("jpg","image/jpeg");
    }
    @Override
    public void run() {
        try {
            System.out.println("一条tcp连接已经建立");

            //解析请求
            InputStream inputStream = socket.getInputStream();
            Scanner scanner=new Scanner(inputStream,"utf-8");
            scanner.next();
            String path = scanner.next();
            System.out.println(path);
            scanner.nextLine();//读取版本号
            String requestPath=path;
            String queryString="";
            Map<String,String> headers=new HashMap<>();
            String headerLine;
            while (scanner.hasNextLine()&&!(headerLine=scanner.nextLine()).isEmpty()){
                String[] part = headerLine.split(":");
                String name=part[0].trim().toLowerCase();
                String value=part[1].trim().toLowerCase();
                headers.put(name,value);
            }
            if(path.contains("?")){
                int i = path.indexOf("?");
                requestPath=path.substring(0,i);
                 queryString = path.substring(i + 1);
            }
            System.out.println(requestPath);
            if(requestPath.equals("/")){
                requestPath="/index.html";
            }
            String target="世界";
            for (String kvPart:queryString.split("&")) {
                if(kvPart.isEmpty()){
                    continue;
                }
                String[] part = kvPart.split("=");
                String key = URLEncoder.encode(part[0], "utf-8");
                String value=URLEncoder.encode(part[1],"utf-8");
                if(key.equals("target")){
                    target=value;
                }
            }
            if(requestPath.equals("/get-book")){
                String username="xyk";
                for (String kv:queryString.split("&")) {
                    if(kv.isEmpty()){
                        continue;
                    }
                    String[] part = kv.split("=");
                    String key = URLEncoder.encode(part[0],"utf-8");
                    String value = URLEncoder.encode(part[1],"utf-8");
                    if(key.equals("username")){
                        username=value;
                    }
                }
                String templateContent=null;
                StringBuilder sb=new StringBuilder();
                try (InputStream is=new FileInputStream(TEMPLATE_BASE+"/hlm.txt")){
                    Scanner scanner1=new Scanner(is,"utf-8");
                    while (scanner1.hasNextLine()){
                        sb.append(scanner1.nextLine());
                        sb.append("/r/n");
                    }
                }
                templateContent=sb.toString();
                String content = templateContent.replace("${username}", username);
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("%s",content);
                printWriter.flush();
            }
            else if(requestPath.equals("/required-login")){
                String uuid=null;
                String cookie = headers.getOrDefault("cookie", "");
                for (String cookieKV:cookie.split(";")) {
                    if(cookieKV.isEmpty()){
                        continue;
                    }
                    String[] kv = cookieKV.split("=");
                    String cookieName=kv[0];
                    String cookieValue=kv[1];
                    if(cookieName.equals("username")){
                        uuid=cookieValue;
                    }
                }
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                if(uuid==null){
                    //写响应行
                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                    //写响应头
                    printWriter.printf("set-cookie:session-id=%s\r\n",uuid);
                    printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                    printWriter.printf("\r\n");
                    printWriter.printf("<h1>没有登录</h1>");
                    printWriter.flush();
                }else {
                    File SessionFile=new File(sessionBase,uuid+".session");
                    if(!SessionFile.exists()){
                        printWriter.printf("HTTP/1.0 200 OK\r\n");
                        //写响应头
                        printWriter.printf("set-cookie:session-id=%s\r\n",uuid);
                        printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                        printWriter.printf("\r\n");
                        printWriter.printf("<h1>没有登录</h1>");
                        printWriter.flush();
                    }else {
                        try (InputStream is=new FileInputStream(SessionFile)){
                            try (ObjectInputStream objectInputStream=new ObjectInputStream(is)){
                                Map<String,Object> sessionData = (Map<String,Object>)objectInputStream.readObject();
                                User user = (User) sessionData.get("user");
                                if(user==null){
                                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                                    printWriter.printf("set-cookie:session-id=%s\r\n",uuid);
                                    printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                                    printWriter.printf("\r\n");
                                    printWriter.printf("<h1>没有登录</h1>");
                                    printWriter.flush();
                                }else {
                                    //写响应行
                                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                                    //写响应头
                                    printWriter.printf("set-cookie:session-id=%s\r\n",uuid);
                                    printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                                    printWriter.printf("\r\n");
                                    printWriter.printf("当前用户："+user.toString());
                                    printWriter.flush();
                                }
                            }
                        }
                    }
                }
            }
            else if(requestPath.equals("/login")){
                //登陆的用户是HelloWorld
                String uuid= UUID.randomUUID().toString();
                User user=new User(1,"HelloWorld","男");
                //创建session对象
                Map<String,Object> sessionData=new HashMap<>();
                sessionData.put("user",user);
                try (OutputStream outputStream=new FileOutputStream(sessionBase+"/"+uuid+".session")){
                    try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream)){
                        objectOutputStream.writeObject(sessionData);
                    }
                }
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                //写响应行
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                //写响应头
                printWriter.printf("set-cookie:session-id=%s\r\n",uuid);
                printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>登录成功</h1>");
                printWriter.flush();

            }
            else if(requestPath.equals("/set-cookie")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                //写响应行
                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                //写响应头
                printWriter.printf("set-cookie:username=xyk\r\n");
                printWriter.printf("Location: profile\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            }
            else if(requestPath.equals("/profile")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                String username=null;
                //从cookie中获取username
                String cookie = headers.getOrDefault("cookie", "");
                System.out.println("cookie value:"+cookie);
                for (String cookieKV:cookie.split(";")) {
                    if(cookieKV.isEmpty()){
                        continue;
                    }
                    String[] kv = cookieKV.split("=");
                    String cookieName=kv[0];
                    String cookieValue=kv[1];
                    if(cookieName.equals("username")){
                        username=cookieValue;
                    }
                }

                //写响应行
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                //写响应头
                printWriter.printf("content-Type:text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                if(username!=null){
                    printWriter.printf("<h1>当前用户是: %s</h1>",username);
                }else {
                    printWriter.printf("<h1>你需要先登录</h1>");
                }
                printWriter.flush();
            }
           else if(requestPath.equals("/redirect-to")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 307 Temporary\r\n");
                printWriter.printf("location:1.jpg\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            }
            else if(requestPath.equals("/goodbye.html")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>再见:%s</h1>",target);
                printWriter.flush();

            }else {
                String filePath = DOC_BASE + requestPath;
                File resource = new File(filePath);
                if (resource.exists()) {
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);
                    String contentType = "text/plain";
                    if (requestPath.contains(".")) {
                        int i = requestPath.lastIndexOf(".");
                        String suffix = requestPath.substring(i + 1);
                        contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                    }
                    if (contentType.startsWith("text/")) {
                        contentType = contentType + "; charset=utf-8";
                    }
                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                    printWriter.printf("Content-Type: %s\r\n", contentType);
                    printWriter.printf("\r\n");
                    printWriter.flush();
                    //写入body
                    try (InputStream resourceInputStream = new FileInputStream(resource)) {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int len = resourceInputStream.read(buffer);
                            if (len == -1) {
                                break;
                            }
                            outputStream.write(buffer, 0, len);
                        }
                        outputStream.flush();
                    }
                    socket.close();
                } else {
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);
                    printWriter.printf("HTTP/1.0 404 Not Found\r\n");
                    printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                    printWriter.printf("\r\n");
                    printWriter.printf("<h1>%s:对应资源不存在</h1>", path);
                    printWriter.flush();
                    socket.close();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
