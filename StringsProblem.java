import java.util.Scanner;
public class StringsProblem{
    // Expand the string.
    public static String expand(String str){
        int i = 0;
        String newString = "";
        char previousCharacter = 'a';
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            return "";
        }
        while(i < str.length()){
            char character = str.charAt(i);
            int count = 0;
            if(character < '0' || character > '9'){
                previousCharacter = character;
                if(str.charAt((i+1)) < '0' || str.charAt((i+1)) > '9'){
                    return "";
                }
            }
            else if(character >= '0' && character <= '9'){
                while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    character = str.charAt(i);
                    count = count * 10 + (character - '0');
                    i++;
                }
                while(count > 0){
                    newString += previousCharacter;
                    count--;
                }
                i--;
            }
            i++;
        }
        return newString;   
    }

    // frequency calculation in a string.
    public static String frequency(String str){
        int count = 1;
        String newString = "";
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)) count++;
            else{
                newString = newString + str.charAt(i-1) + count;
                count = 1;
            }
        }
        newString = newString + str.charAt(str.length()-1) + count;
        return newString;
    }

    // Longest Length of unique Substring.
    public static int uniqueSubstringLength(String str){
        int ri = -1;    // repeating character index
        int maxLength = 0;
        int count = 0;
        for(int i=1; i<str.length(); i++){
            for(int j=(i-1); j>=0; j--){
                if(str.charAt(i) == str.charAt(j)){
                    ri = j;
                    break;
                }
            }
            if(ri == -1) count = i + 1;
            else count = i - ri;
            if(count > maxLength) maxLength = count;
        }
        return maxLength;
    }

    // Converting number into words
    public static String numberToWords(int num){
        int count = 0;
        int val = num;
        while(num > 0){
            count++;
            num /= 10;
        }
        num = val;
        int arr[] = new int[count];
        int rem = 0;
        for(int i=arr.length-1; i>=0; i--){
            rem = num % 10;
            arr[i] = rem;
            num /= 10;
        }
        String arr1[] = {"", "One", "Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",};
        String arr2[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"};
        String arr2b[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
        String newString = "";
        switch(count){
            case 1 : System.out.println(arr1[arr[0]]);
                     break;
            case 2 : if(arr[0] == 1) newString = arr2[arr[1]];
                     else newString = arr2b[arr[0]] + " " + arr1[arr[1]];
                     break;
            case 3 : if(arr[1] == 0) newString = arr1[arr[0]] + " hundred " + arr1[arr[2]];
                     else if(arr[1] == 1) newString = arr1[arr[0]] + " hundred " + arr2[arr[1]];
                     else newString = arr1[arr[0]] + " hundred " + arr2b[arr[1]] + " " + arr1[arr[2]];
                     break;
        }
        return newString;
    }

    // Check number prime or not.
    public static void isPrime(int num){
        if(num == 0 || num == 1){
            System.out.print(num + " is a neither prime nor composite number");
            return;
        }
        boolean flag = true;
        for(int i=2; i<Math.sqrt(num); i++){
            if(num % i == 0){
                flag = false;
                System.out.print(num + " is composite number");
                return;
            }
        }
        if(flag) System.out.println(num + " is prime number.");
    }

    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        String text = """
                        0. Do not perform any operation.
                        1. Expand the String.
                        2. Frequency of a character.
                        3. Longest unique Substring.
                        4. Number in string.
                        5. check no. prime or not. """;
        System.out.println(text);
        int operation = 1;
        String newString = "";
        String string = "";
        int num = 0;
        try{
            while(operation != 0){
                System.out.print("Enter a operation : ");
                operation = userInput.nextInt();
                if(operation == 0) return;
                if(operation < 4){
                    System.out.print("Enter a string : ");
                    string = userInput.next();
                }
                else if(operation <= 5){
                    System.out.print("Enter a number : ");
                    num = userInput.nextInt();
                }
                switch(operation){
                    case 1 : newString = expand(string);
                             if(newString.equals("")){
                                System.out.println("Invalid input");
                                break;
                             }
                             System.out.println("Expanded String : " + newString);
                             break;
                    case 2 : newString = frequency(string);
                             System.out.println("Frequency in string : " + newString);
                             break;
                    case 3 : int length = uniqueSubstringLength(string);
                             System.out.println("Longest Length of unique Substring : " + length);
                             break;
                    case 4 : newString = numberToWords(num);
                             System.out.println(num + " in words : " + newString);
                             break;
                    case 5 : isPrime(num);
                             break;
                    default : System.out.println("Invalid input");
                }
            }
        }
        catch(Exception e){
            System.out.print("Invalid input.");
        }
    }
}