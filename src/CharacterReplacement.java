public class CharacterReplacement {

        // Helper function to find the maximum frequency in the array
        private static int find(int[] a) {
            int maxc = -1;
            for (int i = 0; i < 256; i++) {
                maxc = Math.max(maxc, a[i]);
            }
            return maxc;
        }

        public static int characterReplacement(String s, int k) {
            int n = s.length();
            int[] f = new int[256];  // frequency array
            int low = 0, high = 0, res = Integer.MIN_VALUE;

            for (high = 0; high < n; high++) {
                f[s.charAt(high)]++;  // increment frequency of current character
                int maxcnt = find(f);
                int len = high - low + 1;
                int diff = len - maxcnt;

                while (diff > k) {
                    f[s.charAt(low)]--;  // shrink window from left
                    low++;
                    maxcnt = find(f);
                    len = high - low + 1;
                    diff = len - maxcnt;
                }

                len = high - low + 1;
                res = Math.max(res, len);
            }

            return res;
        }

        // Example usage
        public static void main(String[] args) {

            String s = "ABAB";
            int k = 2;
            System.out.println(characterReplacement(s, k));
        }
    }

// Question Link -> https://leetcode.com/problems/longest-repeating-character-replacement/
