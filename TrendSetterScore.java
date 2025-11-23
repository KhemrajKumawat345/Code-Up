public class TrendSetterScore{
    public static void main(String args[]){
        int arr[] = {1,2,1,3,2,1};
        int w = 3;
        int n = arr.length;
        int count = 0;
        for(int i=0; i < n-w+1; i++){
            if(arr[i] == arr[i+1]) count++;
            else{
                if(arr[i] == arr[i+2]) count++;
                if(arr[i+1] == arr[i+2]) count++;
            }
        }
        System.out.println(count);
    }
}