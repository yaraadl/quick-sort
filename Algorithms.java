//yara adel hassan mohamed 
//19100683 
//algorithms 12th programming assignmnet 
// a program for un sorted arrays to be sorted using quick sort algorithm then searching for a specific element and returning its index

package algorithms;
import java.util.*;  
import java.lang.Math;

public class Algorithms {
    
    static void swapping(int[] arr, int i, int j) // a function for swapping elements to be sorted
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

static int divideconquer(int[] arr, int low, int high)
{
    int pivot = arr[high]; // set pivot on last element on the array
   
    int i = (low - 1); // set i to be outside the array as an initial position
 
    for(int j = low; j <= high - 1; j++) 
    {
       
        if (arr[j] < pivot) // if pivot value is greater than j 
        {
           
            i++;              // increment postition of i 
            swapping(arr, i, j); // swapp i and j 
        }
    }
    swapping(arr, i + 1, high); // if looping upon array is fifnished   = position of pivot is same as j  then swap i+1 element with pivot 
    return (i + 1);  // return old pivot even after swapping
}

static void quickSort(int[] arr, int low, int high)
{
    if (low < high) // checking codithion of array is not  sorted 
    {
         
     
        int pi = divideconquer(arr, low, high);// then apply algorithm 
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

static void print(int[] arr, int size) // a simple function for printing the array after being sorted 
{
    for(int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");
         
    System.out.println();
}
   
    public static int binarysearch(int[] arr, int target) // a function to search for a specific elemnt which is 1 in this program 
    {
        int low = 0;// position of low at the beggining of array 
        int high = arr.length - 1;// position of high at the last posithion of the array 
        int result = -1; // -1 untill being found
        while (low <= high)//STOPPING CONDITHION
        {
            int mid = (low + high) / 2; // mid posithion for cutting th array to sub arrays to ease  the search process
            if (target == arr[mid])
            {
                result = mid;// found 
                high = mid - 1;
            }
            else if (target < arr[mid]) { // go left 
                high = mid - 1;
            }
            else {
                low = mid + 1;// go right 
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] arr = {4,3,2,1,1,5}; // array 
        int n = arr.length;// lenght of array 
        int target = 1;
        System.out.println("unSorted array: ");
        print(arr,n); // printing array before being sorted
        System.out.println("__________________");
        quickSort(arr, 0, n - 1);// calling sorting function by quick sort algorithm
        System.out.println("Sorted array: ");
        print(arr, n);
        System.out.println("__________________");
        System.out.println("Searching for 1: ");
        int index = binarysearch(arr, target);
        if (index != -1)// if we are not out of the array index means if we fifnished looping upon the array 
        {
            System.out.println("founded  " + target + " after sorting is index " + index);
        }
        else {
            System.out.println("error we didnt find your traget value  ");
           
        }
         System.out.println("__________________");
    }
}

    

