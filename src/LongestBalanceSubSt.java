public class LongestBalanceSubSt {

    public static void main(String[] args) {
        String s = "abbac" ;
        System.out.println(longestBalanced(s));
    }
    public static int longestBalanced(String s) {
        int n = s.length() ;

        int maxLen = 0 ;

        for(int i = 0; i<n; i++){
            int[] count = new int[26];
            for(int j =i; j<n; j++){
                count[s.charAt(j)-'a']++;
                if(isBalance(count)){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }

        return maxLen ;
    }

    public static boolean isBalance(int[] count){
        int commonFreq = 0 ;
        for(int k = 0; k<count.length; k++){
            if(count[k] == 0 ) continue ;
            if(commonFreq == 0){
                commonFreq = count[k];
            }

            if(commonFreq != count[k]){
                return false ;
            }

        }

        return true ;
    }
}

// Question Link -> https://leetcode.com/problems/longest-balanced-substring-i/