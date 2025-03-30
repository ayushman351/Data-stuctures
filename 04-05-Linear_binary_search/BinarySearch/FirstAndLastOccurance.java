import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurance {

    public static int findFirst(int[] arr,int x){
        
        int left =0;
        int right = arr.length-1;
        int first = -1;

        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] ==x){
                first = mid;
                right = mid-1;
            }else if ( arr[mid] > x){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }
        return first;
    }


    public static int findLast(int[] arr,int x){
        int left =0;
        int right = arr.length-1;
        int last =-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == x){
                last = mid;
                left = mid+1;
            }else if(arr[mid] > x ){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return last;
    }


    public static int[] find(int[] arr, int x){
        int[] res = new int[2];

        res[0]  = findFirst(arr,x);
       res[1] = findLast(arr,x);

        return res;
    }


    public static void main(String[] args) {
        

        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        int[] res = find(arr, x);

        System.out.println(Arrays.toString(res));


    }
}