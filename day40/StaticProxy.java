package process.demo1;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new you());
        weddingCompany.HappyMary();
    }
}
interface Mary{
   void HappyMary();
}
class you implements Mary{

    @Override
    public void HappyMary() {
        System.out.println("结婚了");
    }
}
class WeddingCompany implements Mary{
    private Mary target;

    public WeddingCompany(Mary target) {
        this.target = target;
    }

    @Override
    public void HappyMary() {
        before();
        this.target.HappyMary();
        after();
    }

    private void after() {
        System.out.println("打扫现场");
    }

    private void before() {
        System.out.println("布置现场");
    }
}
