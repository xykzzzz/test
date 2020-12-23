package process.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习thread，实现多线程同步下载图片
public class TestThread1 extends Thread{
    private String url;//保存图片的地址
    private String name;//保存的文件名
    public TestThread1(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        TestThread1 testThread1=new TestThread1("http://pic1.win4000.com/pic/0/bb/974d1255234_250_350.jpg","1.jpg");
        TestThread1 testThread2=new TestThread1("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3663423228,2210386614&fm=26&gp=0.jpg","2.jpg");
        TestThread1 testThread3=new TestThread1("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1528147186,891408054&fm=26&gp=0.jpg","3.jpg");
        TestThread1 testThread4=new TestThread1("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2669328673,2639074577&fm=26&gp=0.jpg","4.jpg");


        testThread1.start();
        testThread2.start();
        testThread3.start();
        testThread4.start();


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