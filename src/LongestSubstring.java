public class LongestSubstring {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3 ;
        System.out.println(longestSubstring(s,k));
    }
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }
        return n;
    }
}
// Question Link -> https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/