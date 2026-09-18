import java.util.Scanner;

public class RoyalPalindrome {
    public static String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n <= 1) {
            return "";
        }
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[n - 1] = 'b';
        return new String(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println(breakPalindrome(input));
        scanner.close();
    }
}
