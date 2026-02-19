public class CountBinarySubstrings {
    public static void  main(String args[]){
       String str = "00110011";
       System.out.println(countBinarySubstrings(str));
    }
    public static int countBinarySubstrings(String s) {
        int n = s.length();
        int prevGroup = 0;
        int currGroup = 1;
        int count = 0;

        for(int k = 1; k<n; k++){
            if(s.charAt(k) == s.charAt(k-1)){
                currGroup++;
            }else{
                count += Math.min(currGroup , prevGroup);
                prevGroup = currGroup ;
                currGroup = 1 ;
            }
        }

        count += Math.min(currGroup , prevGroup);
        return count ;
    }
}
// Question Link -> https://leetcode.com/problems/count-binary-substrings/