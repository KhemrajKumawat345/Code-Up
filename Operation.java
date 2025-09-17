/*  Assignment - 1 all problem

    Name : Khemraj Kumawat.
    Date : 16 Sep 2025
 */
import java.util.Scanner;
public class Operation{
    // Method that expand the string according to given followed number.
    public static void expand(String str){
        String newstr = "";
        for(int i=0; i<str.length(); i+=2){
            // store the character of ith index.
            char ch = str.charAt(i);            
            // take char. of ith index and convert into int.
            int digit = str.charAt(i+1) - 48;
            int count = 0;
            while(count < digit){
                // append the character into string when executing the loop.
                newstr += ch;
                count++;
            }
        }
        System.out.println("Given String is : " + str);
        System.out.println("Expanded String is : " + newstr);     // print the new String.
    }

    // Count the frequency of a character and print it just after the character.
    public static void getFrequency(String str){
        String newstr = "" + str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)) count++;
            // for last character else condition is never hit so we print it manually.
            else{
                //append the (i-1)th index and its frequency and initialize the count by 1.
                newstr = newstr + str.charAt(i-1) + count;
                count = 1;
            }
        }
        // manually append the last character and its frequency.
        newstr = newstr + str.charAt(str.length()-1) + count;
        System.out.println("Given String is : " + str);
        System.out.println("Frequency of character is : " + newstr);
    }

    // Print the maximum length of a substring without repeating the charcter.
    public static void subString(String str){
        String newstr = "" + str.charAt(0);
        int maxlen = 0; // store the maximum length of desire string.
        int ri = 0; // index which store the unrepeated character index.
        for(int i=1; i<str.length(); i++){
            int j;
            newstr = "";
            for(j=(i-1); j>=ri; j--){
                if(str.charAt(i) == str.charAt(j)){
                    ri = j;
                    break;
                }
            }
            if(ri == 0) maxlen = i - ri + 1;
            else if(maxlen < i-ri) maxlen = i - ri;
        }
        System.out.println(maxlen);
    }

    // Check the given no. is prime or not.
    public static void isPrime(int n){  // Check the given no. is prime or not.
        boolean flag = true;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n % i == 0) flag = false;
        }
        if(n == 1 || n == 0) System.out.println(n + " is not a prime or composite number.");
        else if(flag == true) System.out.println(n + " is prime number.");
        else System.out.println(n + " is composite number.");
    }


    // Method that print the string of a number.
    public static void inString(int n){
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
        while(n > 0){   // Store separate digit in array.
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
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Expand the string.\n2. Frequency of a Character.\n3. maximum length of a substring. \n4. Check No. prime or not. \n5. Print in String of a no.");
        System.out.print("Enter a number of operation : ");
        int operation = sc.nextInt();
        try{
            switch(operation){
                case 1 : System.out.print("Enter a string : ");
                         String str1 = sc.next();
                         expand(str1);
                         break;
                case 2 : System.out.print("Enter a string : ");
                         String str2 = sc.next();
                         getFrequency(str2);
                         break;
                case 3 : System.out.print("Enter a string : ");
                         String str3 = sc.next();
                         subString(str3);
                         break;
                case 4 : System.out.print("Enter a number : ");
                         int num1 = sc.nextInt();
                         isPrime(num1);
                         break;
                case 5 : System.out.print("Enter a number : ");
                         int num2 = sc.nextInt();
                         inString(num2);
                         break;
            }
        }
        catch(Exception e){
            System.out.println("Given input is not valid");
        }
    }
}