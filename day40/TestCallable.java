package process.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable <Boolean>{
    private String url;//保存图片的地址
    private String name;//保存的文件名
    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public Boolean call() {
      WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("http://pic1.win4000.com/pic/0/bb/974d1255234_250_350.jpg","1.jpg");
        TestCallable t2=new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3663423228,2210386614&fm=26&gp=0.jpg","2.jpg");
        TestCallable t3=new TestCallable("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1528147186,891408054&fm=26&gp=0.jpg","3.jpg");
        TestCallable t4=new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2669328673,2639074577&fm=26&gp=0.jpg","4.jpg");
        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(4);
        //提交执行
        Future<Boolean> r1=ser.submit(t1);
        Future<Boolean> r2=ser.submit(t2);
        Future<Boolean> r3=ser.submit(t3);
        Future<Boolean> r4=ser.submit(t4);
        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();
        boolean rs4=r4.get();
        //关闭服务
        ser.shutdownNow();





    }
}

//下载器
 class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出问题");
        }
    }
}
