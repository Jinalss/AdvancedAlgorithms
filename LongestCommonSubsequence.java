public class LongestCommonSubsequence {

    public static void findLongestCommonSubsequence(char[] a, char[] b){

        int m = a.length, n=b.length;
        int dp[][] = new int[m+1][n+1];

        StringBuilder sb = new StringBuilder();

        for(int ax=0; ax <= m; ax++){

            for(int bx=0; bx <= n; bx++){

                if(ax==0 || bx==0){

                    dp[ax][bx] = 0;

                }else if(a[ax-1] == b[bx-1]){

                    dp[ax][bx] = dp[ax-1][bx-1] + 1;

                }else{

                    dp[ax][bx] = Math.max(dp[ax-1][bx], dp[ax][bx-1]);

                }

            }

        }

        System.out.println("Length of longest common subsequence is " + dp[m][n]);


        while(m > 0 && n > 0){

            if(Math.max(dp[m-1][n], dp[m][n-1]) != dp[m][n]){
                sb.insert(0,a[m-1]);
                m--; n--;
            }else{

                if(dp[m-1][n] == dp[m][n]){
                    m--;
                }else{
                    n--;
                }

            }

        }

        System.out.println("The sequence is "+sb.toString());

    }

    public static void main(String[] args) {
        String a = "AGGTAB", b="GXTAYB";

        findLongestCommonSubsequence(a.toCharArray(), b.toCharArray());
    }
}
