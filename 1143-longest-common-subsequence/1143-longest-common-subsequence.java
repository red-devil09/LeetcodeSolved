class Solution {
    
   
    public int longestCommonSubsequence(String text1, String text2) {
    
        
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                if(i==n || j==m)
                    dp[i][j] = 0;
                else{
                    int op1 = 0;
                    if(text1.charAt(i)==text2.charAt(j))
                        op1 = 1 + dp[i+1][j+1];
                    else
                        op1 = Math.max(dp[i][j+1],dp[i+1][j]);
                    dp[i][j]=op1;
                    
                }
                
            }
        }
        
        return dp[0][0];
        
       // return func(0,0,text1,text2);
    }
}