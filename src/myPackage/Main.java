package myPackage;

/**
 * Complexity
 * O(n)    linear
 * O(1)    constant
 * O(n^2)   qudratic
 * O(log n)base 2
 *
 * number of loop can help to deternmine the time complexity
 * one loop O(n)     two loop  O(n^2)
 *
 *
 * Arrays getting the element O(1)  it will alway will take 2 steps
 * reteriving the element index by value    O(n)  where n is length of area
 * adding element    O(1)
 * Insert or Update  O(1)
 * Adding elemnt to Full Array   O(n)
 * deleteing element by seting null O(1)
 * Deleting element by shifting eleemnts    O(n)
 */
public class Main {

    public static void main(String[] args) {
	    int[] myArray=new int[12];
        myArray[0]=3;
        myArray[1]=6;
        myArray[2]=6;
        myArray[3]=1;
        myArray[4]=1;
        myArray[5]=9;
        myArray[6]=2;
        myArray[7]=1;
        myArray[8]=4;
        myArray[9]=2;
        myArray[10]=5;
        myArray[11]=6;

        Sort.quickSort(myArray,0,myArray.length);

        for(int i=0;i<myArray.length;i++){
            System.out.print((myArray[i]+","));
        }
    }
}
