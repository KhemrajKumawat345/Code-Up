/* Program : Calculate the frequency of character in String.
   Example : Input - aabccd
             Output - a2b1c2d1

             Name : Khemraj Kumawat.
             Date : 16 Sep 2025
 */
public class FrequencyOfCharacters{
    public static void countTheFrequency(String str){
        String newstr = "";
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
    public static void main(String args[]){
        String str = "aabcccdeee";
        countTheFrequency(str);
    }
}