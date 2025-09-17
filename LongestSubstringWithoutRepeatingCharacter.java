/* Program : Find the length of longest substring in a given string without repeating the 
             character.
   Example : Input - abcdabcbcc.
             Output - 4

             Name : Khemraj Kumawat.
             Date : 16 Sep 2025
 */
import java.util.HashMap;
public class LongestSubstringWithoutRepeatingCharacter{
    public static void findTheLargestSubstring(String str){
        int maxlen = 0; // store the maximum length of desire string.
        int ri = 0; // index which store the unrepeated character index.
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(m.containsKey(ch) && m.get(ch) > ri){    
                ri = m.get(ch);
                m.put(ch, i);
            }
            else m.put(ch, i);
            maxlen = Math.max(maxlen, i - ri);  // Assign the maximum length.
        }
        System.out.println(maxlen);
    }
    public static void main(String args[]){
        String str = "abcdabcefbb";
        findTheLargestSubstring(str);   // pass string to a function.
    }
}