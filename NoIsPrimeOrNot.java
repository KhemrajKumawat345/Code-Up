/* Program : Check given no. is prime or not.
   Example : Input - 7
             Output - 7 is prime number.

             Name : Khemraj Kumawat.
             Date : 16 Sep 2025
 */
public class NoIsPrimeOrNot{
    public static void isPrime(int n){  // Check the given no. is prime or not.
        boolean flag = true;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n % i == 0) flag = false;
        }
        if(n == 1 || n == 0) System.out.println(n + " is not a prime or composite number.");
        else if(flag == true) System.out.println(n + " is prime number.");
        else System.out.println(n + " is composite number.");
    }
    public static void main(String args[]){
        int n = 0;      // No. which has to be check prime or not.
        isPrime(n);     // No. pass to the function.
    }
}