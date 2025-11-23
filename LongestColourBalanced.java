public class LongestColourBalanced{
    public static void main(String args[]){
        int arr[] = {1,2,1,0,0,2,2,1};
        int n = arr.length;
        int arr1[] = new int[n];
        int count1 = 0;
        int arr2[] = new int[n];
        int count2 = 0;
        for(int i=0; i<n; i++){         // for count 1's
            if(arr[i] == 1) count1++;
            arr1[i] = count1;
        }
        for(int i=0; i<n; i++){         // for count 2's
            if(arr[i] == 2) count2++;
            arr2[i] = count2;
        }
        int length = 0;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(i == 0){
                    if(arr2[j] == arr1[j]){
                        length = j+1;
                        break;
                    }
                }
                else{
                    if(arr2[j] - arr2[i] == arr1[j] - arr1[i]){
                        length = j - i;
                        break;
                    }
                }
            }
            if(length != 0) break;
        }
        System.out.println("lnegth : " + length);
    }
}