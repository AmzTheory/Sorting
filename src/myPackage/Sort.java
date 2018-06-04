package myPackage;

import java.awt.*;
import java.util.*;

/**
 * stable sort
 * if two items are equal it
 * will pereserver the ordering otherwise it called unstable sort
 *
 * perhaps when sorting digit it might be meanless  but for instance if we odering objects who has
 * different attributes and you are performing nested sorts , at that kind of situation you want keep
 * mainting of perverious order sort when doing the second sort
 */


public class Sort {


    /**
     * Stable sort
     * it quiet long
     *  O(n^2)  it would be quadratic      100 steps to sort 10 items
     */

    public static void BubbleSort(int[] items){
       for (int unsorteredIndex=items.length-1;unsorteredIndex>-1;unsorteredIndex--){
           for (int b=0;b<unsorteredIndex;b++){
                if(items[b]>items[b+1]){
                    /*items[b]=OperandB;
                    items[b+1]=OperandA;*/
                    swap(items,b,b+1);
                }
           }
       }
    }
    /**
     * Selection  (is called selection becuase at every cycle it would take the largest
     * and put at the end)
     * it will split the array to unsorted and sorted partion
     *
     *  unsortedlastindex (initially it will be length -1)
     *  i  (which will bacicall represent the index of the element to be compared with largest
     *  largest   will contain the index for largest number at the unsorted parition
     *
     *  it's O(n^2)  will have two loops
     *  however it would take less time comparing to bubble
     *  unstable algorthims
     *
     */
    public static void selectionSort(int[] items){
        for (int lastUnsortedIndex=items.length-1;lastUnsortedIndex>0;lastUnsortedIndex--){
            int largest=0;
            for (int i=1;i<=lastUnsortedIndex;i++){
                if (items[i]>items[largest]) {
                    largest = i;
                }

            }
            swap(items,largest,lastUnsortedIndex);
        }

    }

    /**
     * Insertion sort
     * so the main concept is that we'll split the array to sorted and sorted
     * part .The sorted list will be at begining of the Array. first step will be
     * to meke element at index 0 sorted , and from 1 until the end will be unsorted.
     * The next step will be take every element from index one to the end and add them to where it
     * fit in the sorted list
     *
     * O(n^2) complexity    Stable sort   in-place algortihm
     *
     * firstIndexSortedList   will containt the firt element index that is unsorted
     * i                      will be used to start from he end of array when looking where is correcting sorting place for the element
     * newElement             will contain the value for the element where look to fit in the sorted array
     *
     * @param items will contain the array of element to be sorted
     */
    public static void insertionSort(int[] items){
       for(int firstUnsortedIndex=1;firstUnsortedIndex<items.length;firstUnsortedIndex++){
           int newElement=items[firstUnsortedIndex];
           int i;
           for(i=firstUnsortedIndex;i>0&&items[i-1]>newElement;i--){
               items[i]=items[i-1];
           }
           items[i]=newElement;
       }
    }

    public static void swap(int[] items,int i ,int j){
        if(i==j)
            return;

        int temp=items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    /**
     * Merge sort
     *
     * Spliting phase
     * start with unsorted list
     * divide the array into to array until you get bunch of one element phase
     *
     * Merge sort
     * Merger the right and left pair
     * repeate until you get single array
     *
     * not inplace  , however it's stable
     *
     * merge process
     * O(nlogn) base 2
     *end is always one greater that the last index
     */
    
    public static void mergeSort(int[] input,int start,int end){
        if((end-start)<2)
            return ;
        else{
            int mid=(start+end)/2;
            //left
            mergeSort(input,start,mid);
            //Right
            mergeSort(input,mid,end);
            
            
            merge(input,start,mid,end);
        }
    }

    private static void merge(int[] input, int start, int mid, int end) {
        //in this case the two array is sorted(optimization)
        if(input[mid-1]<=input[mid])
            return ;

        int i=start;
        int j=mid;
        int tempIndex=0;
        int[] temp=new int[end-start];
        while (i < mid && j < end) {
            temp[tempIndex++]=input[i]<=input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input,i,input,start+ tempIndex,mid-i);
        System.arraycopy(temp,0,input,start,tempIndex);
    }

    /**
     * Quick sort
     * divide and conquer
     *
     * its inplace algorithm
     * unstable algorithm
     *
     * O(log n)   base 2          it could be qudratic
     */
    public static void quickSort(int[] input,int start,int end){
        if(end-start<2){
            //One element array
            return;
        }
        int pivotIndex=partition(input,start,end);
        quickSort(input,start,pivotIndex);
        quickSort(input,pivotIndex+1,end);
    }

    private static int partition(int[] input, int start, int end) {
        //this is using the first Index as the pivot
        int pivot=input[start];
        int i=start;
        int j=end;

        while(i<j){
            //Empty loop
            while(i<j && input[--j]>=pivot);
            if(i<j){
                input[i]=input[j];
            }
            //Empty  loop
            while(i<j && input[++i]<=pivot);
            if(i<j){
                input[j]=input[i];
            }
        }
        input[j]=pivot;
        return j;//return the correct order for the pivot in the array
    }

    /**
     *Counting Sort
     * count occurence of each value
     * only works non-negative discrete values
     * it have to be with range(value must be specific)
     *
     * Not in place algorithm
     * O(N) can be achieved
     */

    public static void countingSort(int[] input,int min,int max){
        int[] countArray=new int[(max-min)+1];

        for(int i=0;i<input.length;i++){
            countArray[input[i]-min]++;
        }
        int j=0;
        for(int i=min;i<=max;i++){
            while(countArray[i-min]>0){
                input[j++]=i;
                countArray[i-min]--;
            }
        }
    }
    public static void countingSortLinkedList(int[] input,int min,int max){
        //int[] countArray=new int[(max-min)+1];
        LinkedList<Integer>[] Elements=new LinkedList[(max-min)+1];
        for(LinkedList<Integer> instance:Elements){
            instance=new LinkedList<>();
        }
        for(int i=0;i<input.length;i++){
            Elements[input[i]-min].add(input[i]);
        }

        int j=0;
        for(int i=min;j<=max;j++){
            Integer next=Elements[i].getFirst();
            while(next!=null){
                input[j++]=next;
                next=Elements[i].getFirst();
            }
        }

    }
}
