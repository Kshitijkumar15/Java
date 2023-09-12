import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondLargest {
    static void Print2Largest(int arr[],int arr_size){
        int i,First,Second;
        if(arr_size <2){
            System.out.println("invalid");
            return;
        }
        Arrays.sort(arr);
        for(i=arr_size-2;i>=0;i--){
            System.out.println(arr[i]);
            return;
        }
        System.out.println("no");
    }

    public static void main(String[] args) {
        int arr[]={23,34,45,3,6};
        int n=arr.length;
        Print2Largest(arr,n);
    }
}
