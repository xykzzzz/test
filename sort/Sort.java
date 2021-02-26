package sort;

import java.util.Arrays;
import java.util.Random;

/*
具备稳定性的排序：3个 插入 冒泡 归并
时间复杂度最坏是n^2：插入 冒泡 选择 希尔 快速
最好可以达到o（n）:插入 冒泡
空间复杂度不是o（1）:快排 归并
*/


public class Sort {
    public static void main(String[] args) {
 /*       long [] array=构建有序数组();
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(    "-------------"  );
        long [] array1=构建随机数组();
        System.out.println(Arrays.toString(array1));
        rubbleSort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(    "-------------"  );*/
        long [] array3=构建随机数组();
        System.out.println(Arrays.toString(array3));
        mergeSort(array3);
        System.out.println(Arrays.toString(array3));

    }

    private static long[] 构建随机数组() {
        Random random=new Random(20201);
        long[] arr=new long[10];
        for (int i = 0; i <10 ; i++) {
            arr[i]=random.nextInt(100);
        }
        return arr;
    }
    private static long[] 构建有序数组(){
        long []arr=构建随机数组();
        Arrays.sort(arr);
        return arr;
    }
    // 时间复杂度
    // 最好： O(n)       有序
    // 最坏： O(n^2)     逆序
    // 平均： O(n^2)
    // 空间复杂度
    // 最好/最坏/平均：   O(1)
    // 具备稳定性
    public static void insertSort(long[]array){
        //将数组分为有序区间和无序
        //有序[0,i]
        //无序[i+1,arr.lenth)
        for (int i = 0; i < array.length-1 ; i++) {
            //找到无序中第一个数
            long key=array[i+1];
            int j;
            //key与有序区间进行比较
            for(j=i;j>=0;j--){
                //key小于有序区间最后个元素下标（j）则把最后一个元素赋值到下标（j+1）
                if(key<array[j]){
                    array[j+1]=array[j];
                }else{
                    //break的情况有两种等于和大于跳出循环
                    break;
                }
            }
            //跳出后直接将key赋值到j+1下标下的位置
            array[j+1]=key;
        }
    }
    // 时间复杂度
    // 最好: O(n) 有序
    // 最坏: O(n^2) 逆序
    // 平均: O(n^2)
    // 空间复杂度
    // 最好/平均/最坏：O(1)
    // 具备稳定性
    public static void rubbleSort(long[]array){
        //外层循环表示冒几轮
        for (int i = 0; i < array.length-1 ; i++) {
            //假设每轮冒泡都有序 优化冒泡排序
            boolean isSort=true;
            //内层循环每轮冒几次
            for (int j = 0; j < array.length-1-i ; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    isSort=false;
                }
                //每一轮冒完泡则最后个数一定数组中最大的下次进行循环时要减去已经冒了几轮的次数（数组长度-1-i）来表示
            }
            //条件满足说明冒泡有序 减少循环
            if(isSort){
                break;
            }
        }
    }
    private static void swap(long[] array, int i, int j) {
        long t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    // 时间复杂度
    // 最好: O(n^2)
    // 最坏: O(n^2)
    // 平均: O(n^2)
    // 空间复杂度
    // 最好/平均/最坏：O(1)
    // 不具备稳定性
    public static void selectSort(long[]array){
        //将数组分为有序区间和无序
        //无序[0,arr.lenth-i)
        //有序[arr.Lenth-i,arr.lenth)
        for (int i = 0; i < array.length-1; i++) {
            int maxIndex=0;
            for (int j = 1; j <array.length-i ; j++) {
                if(array[maxIndex]<array[j]){
                    maxIndex=j;
                }
            }
            swap(array,maxIndex,array.length-i-1);
        }
    }
    public static void heapSort(long[] array) {
        // 1. 建大堆
        createHeap(array, array.length);

        // 2. 进行选择的过程，一共需要 array.length - 1 组
        for (int i = 0; i < array.length - 1; i++) {
            // 无序：[0, array.length - i)
            swap(array, 0, array.length - i - 1);
            // 无序：[0, array.length - i - 1)
            adjustDown(array, array.length - i - 1, 0);
        }
    }

    private static void adjustDown(long[] array, int size, int index) {
        while (2 * index + 1 < size) {
            int maxIndex = 2 * index + 1;
            if (maxIndex + 1 < size && array[maxIndex + 1] > array[maxIndex]) {
                maxIndex++;
            }

            if (array[index] >= array[maxIndex]) {
                break;
            }

            swap(array, index, maxIndex);

            index = maxIndex;
        }
    }

    private static void createHeap(long[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustDown(array, size, i);
        }
    }
    private static void insertGap(long[] array,int gap){ //希尔排序
        //外层for循环代表从gap下标一直往后走
        for (int i = gap; i < array.length; i++) {
            long key=array[i];
            int j;
            //内层循环代表从下标0位置开始走
            for (j = i-gap; j >=0 ; j=j-gap) {
                if(key<array[j]){
                    //gap位置元素小于j位置元素条件满足  交换j与gap位置交换 然后都分别都走一步
                    array[j+gap]=array[j];
                }else {
                    break;
                }
            }
            //内层循环退出 说明key等于或大于j位置的元素
            array[j+gap]=key;
        }
    }
    private static void shellSort(long[]array){
        int gap=array.length/2;
        while (true){
            insertGap(array,gap);
            if(gap==1){
                break;
            }
            gap=gap/2;
        }
    }
    public static void quickSort(long[]array){
        quickSortInternal(array,0,array.length-1);
    }

    private static void quickSortInternal(long[] array, int lowIndex, int highIndex) {
        if(highIndex-lowIndex+1<=1){
            return;
        }
        int key=partition(array,lowIndex,highIndex);
        quickSortInternal(array,lowIndex,key-1);
        quickSortInternal(array,key+1,highIndex);
    }

    private static int partition(long[] array, int lowIndex, int highIndex) {
       /* return partitionHover(array, lowIndex, highIndex);*/
        /*return partition挖坑(array,lowIndex,highIndex);*/ //挖坑法
        return partition前后(array,lowIndex,highIndex);
    }
    private static int partition挖坑(long[] array, int lowIndex, int highIndex){
        int left=lowIndex;
        int right=highIndex;
        long key=array[lowIndex];
        while (left<right){
            while (left<right&&key<=array[right]){
                right--;
            }
                array[left]=array[right];

            while (left<right&&key>=array[left]){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=key;
        return left;
    }
    private static int partition前后(long[] array, int lowIndex, int highIndex){
        int blueIndex=lowIndex+1;
        for (int blackIndex = lowIndex+1; blackIndex <=highIndex ; blackIndex++) {
            if(array[lowIndex]>array[blackIndex]){
                swap(array,blueIndex,blackIndex);
                blueIndex++;
            }
        }
        swap(array,lowIndex,blueIndex-1);
        return blueIndex-1;
    }

    private static int partitionHover(long[] array, int lowIndex, int highIndex) {
        int left=lowIndex;
        int right=highIndex;
        long key=array[lowIndex];
        while (left<right){
            while (left<right&&key<=array[right]){
                right--;
            }
            while (left<right&&key>=array[left]){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,lowIndex,left);
        return left;
    }
    public static void mergeSort(long[] array){
        mergeSortInternal(array,0,array.length);
    }

    private static void mergeSortInternal(long[] array, int lowIndex, int highIndex) {
        int size=highIndex-lowIndex;
        if(size<=1){
            return;
        }
        int middleIndex=(lowIndex+highIndex)/2;
        mergeSortInternal(array,lowIndex,middleIndex);
        mergeSortInternal(array,middleIndex,highIndex);
        合并两个有序区间(array,lowIndex,middleIndex,highIndex);
    }

    private static void 合并两个有序区间(long[] array, int lowIndex, int middleIndex, int highIndex) {
        int size=highIndex-lowIndex;
        long[] extraArray=new long[size]; //定义一个额外的数组
        int leftIndex=lowIndex;  //
        int rightIndex=middleIndex;
        int extraIndex=0;
        while (leftIndex<middleIndex&&rightIndex<highIndex){
            if(array[leftIndex]<=array[rightIndex]){ //归并
                extraArray[extraIndex]=array[leftIndex];
                leftIndex++;
                extraIndex++;
            }else{
                extraArray[extraIndex]=array[rightIndex];
                rightIndex++;
                extraIndex++;
            }
        }
        if(leftIndex<middleIndex) {
            while (leftIndex < middleIndex) {
                extraArray[extraIndex++] = array[leftIndex++];
            }
        }else{
            while (rightIndex < highIndex) {
                extraArray[extraIndex++] = array[rightIndex++];
            }
        }
        // 最后，把数据从新数组统一搬回去
        // 新数组 [0, size)
        // 搬回去的下标范围 [lowIndex, highIndex)
        for (int i = 0; i < size; i++) {
            array[i+lowIndex] = extraArray[i];
        }
    }     //注：其实归并的思想和当时学过的单链表合并两个有序链表思路相似
}
