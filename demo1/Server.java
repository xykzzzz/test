package demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool= Executors.newFixedThreadPool(10);
        ServerSocket serverSocket=new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable r=new requestResponseTask(socket);
            threadPool.execute(r);
        }
    }
}
