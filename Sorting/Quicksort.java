public class Quicksort {

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int [] arr, int low, int high){
        int pivot = arr[high];           // pivot element.

        int i = low - 1;                 // the value is stored in this variable.

        for(int j = low; j < high; j++){ // traversal of the loop. 

            if( arr[j] < pivot){         // condition for swapping. 
                i++;
                swap(arr, i, j );
            }

        }
        swap ( arr, i+1, high);         //final swap 

        return i+1;

    }
    public static void quicksort(int[]arr, int low, int high){

        if(low < high){
            
        int partitionindex = partition(arr, low, high);

        quicksort(arr, low, partitionindex - 1 ); // recursion for the methods.
        quicksort(arr, partitionindex + 1, high);
    }
}
    
  public static void main(String[] args) {
        int[] data = {1, 5, 6, 4, 89, 86};
        quicksort(data, 0, data.length - 1);
        System.out.println(java.util.Arrays.toString(data));
    }
    
}


