import java.util.HashMap;
import java.util.Map;

public class LongestKSubstr {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestKSubstr(s, k));

    }

    public static int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int low = 0;
        int res = -1;
        Map<Character, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {
                char leftCh = s.charAt(low);
                freq.put(leftCh, freq.get(leftCh) - 1);
                if (freq.get(leftCh) == 0) {
                    freq.remove(leftCh);
                }
                low++;
            }

            if (freq.size() == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;
    }
}

// Question Link -> https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
