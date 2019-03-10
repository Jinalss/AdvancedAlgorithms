public class UnboundedKnapsackProblem {

    public static int ukb(int[] values, int[] weights, int W){
        int[] dp = new int[W+1];
        dp[0] = 0;
        for(int c=1; c<=W; c++){
            dp[c]=dp[c-1];
            for (int i = 0; i < values.length; i++) {
                if(weights[i] <= c){
                    dp[c] = Math.max(dp[c], dp[c-weights[i]]+values[i]);
                }
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 5};
        int[] values = {50, 100, 140};
        int W = 17;
        System.out.println(ukb(values, weights, W));
    }

}
