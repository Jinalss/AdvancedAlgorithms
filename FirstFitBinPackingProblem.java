import java.util.Arrays;

public class FirstFitBinPackingProblem {

    private static int firstFit(int[] weights, int binSize){

        int res = 0;
        int n = weights.length;
        int[] bins = new int[n];

        for (int i=n-1; i >= 0; i--){
            int j;

            for (j=0; j<res; j++)
            {
                if (bins[j] >= weights[i]){
                    bins[j] -= weights[i];
                    break;
                }
            }

            // If no bin could accommodate weights[i],
            // create a new bin
            if (j == res){
                bins[res] = binSize - weights[i];
                res++;
            }

        }
        return res;

    }

    public static void main(String[] args) {

        int[] weights = {2, 5, 4, 7, 1, 3, 8};
        Arrays.sort(weights);
        int binSize = 10;
        int numOfBinsReqd = firstFit(weights, binSize);
        System.out.println("Number of Bins Required: " + numOfBinsReqd);
    }

}
