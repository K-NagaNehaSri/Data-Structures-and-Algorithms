public class Uniformbs {
    static final int maxsize = 10; 
    static int[] lookuptable = new int[maxsize];

    static void createlookuptable(int n){
        int pow = 1; 
        int index = 0;

        do{ 
            pow <<= 1;
            lookuptable[index] = (n + (pow >> 1))/pow;

        }while (lookuptable[index++] != 0 );
    }

    static int uniformbinarysearch(int[] arr, int target){
        int index = lookuptable[0] - 1;
        int step = 0; 

        while(lookuptable[step] != 0){
            if( target == arr[index]){
                return index;
        }
        else if ( target < arr[index]){
            index -= lookuptable[++step];

        }else {
            index += lookuptable[++step];
        }
        if(index < 0 || index >= arr.length){
            return -1;
        }
    }
    return -1;
}

public static void main(String[] args){
    int [] arr = { 1, 3, 5, 6, 7, 8, 9};
    int target = 3;

    createlookuptable(arr.length);

    int result = uniformbinarysearch(arr, target);

    if(result != -1){
        System.out.println("element " + target + " found at "+ result);
    }else{
        System.out.println("the element is not found");
    }
}
}
