import java.util.Scanner;
public class ScrambledSubstring{
    public static boolean containsScrambled(String p, String s) {
        int m = p.length();
        int n = s.length();
        if (m > n) return false;
        int[] freq = new int[26];     

        for (int i = 0; i < m; i++) {
            freq[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            freq[s.charAt(i) - 'a']--;
        }

        if (allZero(freq)) return true;

        for (int i = m; i < n; i++) {
            freq[s.charAt(i) - 'a']--;      
            freq[s.charAt(i - m) - 'a']++;  

            if (allZero(freq)) return true;
        }

        return false;
    }

    private static boolean allZero(int[] arr) {
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a super string : ");
        String superString = sc.nextLine();
        System.out.print("Enter a sub string : ");
        String subString = sc.nextLine();
        System.out.println(containsScrambled(subString, superString)); 
    }
}