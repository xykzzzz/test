package priority;

public class lx {
    public static void adjustDown(int []array ,int size,int index){
        while (true){
            //左孩子的位置为index位置*2+1
        int leftChild=2*index+1;
        //判断是否为叶子节点 出口一
        if(leftChild>=size){
            return;
        }
        //找最小孩子
        int rightChild=leftChild+1;
        int minChild=leftChild;
        //比较左右孩子的元素大小 小的放进minChild中
        if(rightChild<size&&array[rightChild]<array[leftChild]){
            minChild=rightChild;
        }
        //比较最小孩子（minChild）与index位置的值
        if (array[index] <= array[minChild]) {
            return;
        }
        // 4.程序 走到这说明不满足堆的性质  进行交换将index位置元素与minIndex位置的元素进行交换
        int t = array[index];
        array[index] = array[minChild];
        array[minChild] = t;

        // 5.循环 把最小的孩子视为 index，继续循环直到index位置满足堆的性质
        index = minChild;
    }
  }
   public static void adjustUp(int []array ,int size ,int index){
        while (true){
            // 出口 index位置为根位置
            if(index==0){
                break;
            }
            //找到Index位置的父亲位置 parentIndex
            int parentIndex=(index-1)/2;
            //出口 满足堆的性质 父亲的值小于左右孩子
            if(array[parentIndex]<array[index]){
                break;
            }
            // 不满足 交换index位置与parentIndex位置上的元素
            int t=array[parentIndex];
            array[parentIndex]=array[index];
            array[index]=t;
        }
   }
   public static void createHeap(int []array, int size){
        //找到层序遍历最后一个结点的下标
       int lastIndex=size-1;
       //找到最后一个结点父节点下标
       int parentIndex=lastIndex-1/2;
       for (int i = parentIndex; i >=0; i--) {
           adjustDown(array,size,i);
       }
   }
}
