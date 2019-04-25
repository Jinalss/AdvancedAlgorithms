public class DistinctSubsequences {

    public static int getDistinctSubsequences(String S, String T){

        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<m; i++)
            dp[i][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];

            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {

        System.out.println("Number of Distinct Subsequences are " + getDistinctSubsequences("rabbbit", "rabbit"));

    }

}



