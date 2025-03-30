public class BinarySearchIn2d {
    public static int binarySearch(int[][] arr, int target){

        int row = arr.length;
        int col = arr[0].length;

        int left =0;
        int right = row*col-1;

        
        while(left<=right){
            int mid = (left+right)/2;
    
            int rowidx = mid/col;
            int colidx = mid%col;

            if(arr[rowidx][colidx] == target) return target;
            else if(arr[rowidx][colidx] <target) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 3;

        System.out.println(binarySearch(arr,target));

    }
}