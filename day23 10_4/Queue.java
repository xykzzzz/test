package packeageDeque;


import java.util.NoSuchElementException;

public interface Queue {
    //这组方法通过返回特殊值来通知错误
    boolean offer(Integer e);
    Integer peek();
    Integer poll();
    //这组方法通过抛异常通知错误
    default boolean add(Integer e){
        if(offer(e)==false){
            throw new IllegalStateException();
        }
        return true;
    }
    default Integer element(){
        Integer e=peek();
        if(e==null){
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer remove(){
        Integer e=poll();
        if(e==null){
            throw new NoSuchElementException();
        }
        return e;
    }

}
