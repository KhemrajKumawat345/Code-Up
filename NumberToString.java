/* Program : Print the given no. in String.
   Example : Input - 34
             Output - Thirty Four

             Name : Khemraj Kumawat.
             Date : 16 Sep 2025
 */
import java.util.Scanner;
public class NumberToString{
    public static void printInString(int n){
        if(n == 0){         // if n is zero.
            System.out.println("Zero");
            return;
        }
        if(n == 1000){      // if n is thousand.
            System.out.println("Thousand");
            return;
        }
        int count = 0;
        int num = n;
        while(num > 0){     // count the no. of digits.
            count++;
            num /= 10;
        }
        int rem = 0;
        int arr[] = new int[count];
        int x = arr.length - 1;
        while(n > 0){   // separate digit in array.
            rem = n % 10;
            arr[x--] = rem;
            n /= 10;
        }
        String str;
        int y = 0;
        String ar1[] = {"" , "one", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String ar2[] = {"" , "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
        if((count == 2 && arr[0] == 1) || (count == 3 && arr[1] == 1)){
            // For 10 to 19 in two or three digit no.
            System.out.print(ar1[arr[0]] + " hundred ");
            if(count == 2) y = 1;
            if(count == 3) y = 2;
            switch(arr[y]){
                case 0 : System.out.println("Ten");
                         break;
                case 1 : System.out.println("Eleven");
                         break;
                case 2 : System.out.println("Twelve");
                         break;
                case 3 : System.out.println("Thirteen");
                         break;
                case 4 : System.out.println("Fourteen");
                         break;
                case 5 : System.out.println("Fifteen");
                         break; 
                case 6 : System.out.println("Sixteen");
                         break;
                case 7 : System.out.println("Seventeen");
                         break;
                case 8 : System.out.println("Eighteen");
                         break;
                case 9 : System.out.println("Ninteen");
                         break;
            }
            return;
        }
        switch(count){
            case 1 : System.out.println(ar1[arr[0]]);   // For 1 to 9.
                     break;
            case 2 : System.out.println(ar2[arr[0]] + " " + ar1[arr[1]]);   // For 20 to 99.
                     break;
            case 3 : if(arr[1] == 0){   // For 100 to 999.
                     System.out.println(ar1[arr[0]] + " Hundred " + ar2[arr[1]] + ar1[arr[2]]);
                     break;
                     }
                     else{
                     System.out.println(ar1[arr[0]] + " Hundred " + ar2[arr[1]]+ " " + ar1[arr[2]]);
                     break;
                     }
        }
    }
    public static void main(String args[]){
        System.out.print("Enter a No. : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printInString(n);
    }
}