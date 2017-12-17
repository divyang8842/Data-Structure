package sortings;

public class HeapSort 
{    
    private static int N;
    /* Sort Function */
    public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
    /* Function to build a heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i; //starting from 0 it is 2i+1  11
        int right = 2*i + 1; //s starting from 0 it is 2i+2 12
        int max = i; 
        
        
        
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
    //    int tmp = arr[i];
        arr[i] = arr[i] + arr[j]; // 10 5 15
        arr[j] = arr[i] - arr[j];//15-5 10
        arr[i] = arr[i] - arr[j]; //15-10 5
    }    
    /* Main method */
    public static void main(String[] args) 
    {
  
        int arr[] ={ 4, 2, 9, 6, 23, 12, 34, 0, 1 };;

        sort(arr);
               
    }    
}