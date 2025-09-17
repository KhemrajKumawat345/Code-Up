/* Program : Expand the character of string according to given by followed number.
   Example : Input - a1b2c3
             Output - abbccc

             Name : Khemraj Kumawat.
             Date : 16 Sep 2025
 */
public class ExpandCharacterInString{
    public static void expandTheString(String str){    // function which expand the string.
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
    public static void main(String args[]){
        String s = "a1b4c3";        // Stirng which has to be expand.
        expandTheString(s);         // String pass to the function.
    }
}