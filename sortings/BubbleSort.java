
public class BubbleSort {
	public  void bubble_srt(int array[]) {
		int n = array.length;
		        int k;
		        for (int m = n; m >= 0; m--) {
		            for (int i = 0; i < n - 1; i++) {
		                k = i + 1;
		                if (array[i] > array[k]) {
		                    swapNumbers(i, k, array);
		                }
		            }
		            printNumbers(array);
		        }
		    }
		  
		    private  void swapNumbers(int i, int j, int[] array) {
		        array[i] = array[j]+array[i];
		        array[j] =  array[i]-array[j];
		        array[i] =  array[i]-array[j];
		    }
		  
		    private  void printNumbers(int[] input) {
		          
		        for (int i = 0; i < input.length; i++) {
		            System.out.print(input[i] + ", ");
		        }
		        System.out.println("\n");
		    }
		  
		    public static void main(String[] args) {
		    	BubbleSort sort = new BubbleSort();
		        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		        sort.bubble_srt(input);
		  
		    }
}
