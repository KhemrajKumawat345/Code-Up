public class PairSumEqualToK{
    public static void main(String args[]){
        int arr[] = {1,2,3,2,1,2};
        int n = arr.length;
        int target = 4;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && arr[i]+arr[j] == target){
                    count++;
                    arr[i] = 0;
                    arr[j] = 0;
                }
            }
        }
        System.out.println(count);
    }
}