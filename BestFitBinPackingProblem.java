public class BestFitBinPackingProblem {

    private static int bestFit(int[] weights, int binSize){

        int res = 0;
        int[] bins = new int[weights.length];

        for (int i=0; i<weights.length; i++){
            int j;

            // Initialize minimum space left and index 
            // of best bin 
            int min = binSize+1, bi = 0;

            for (j=0; j<res; j++)
            {
                if (bins[j] >= weights[i] &&
                        bins[j] - weights[i] < min)
                {
                    bi = j;
                    min = bins[j] - weights[i];
                }
            }

            // If no bin could accommodate weights[i], 
            // create a new bin 
            if (min==binSize+1)
            {
                bins[res] = binSize - weights[i];
                res++;
            }
            else // Assign the item to best bin 
                bins[bi] -= weights[i];
        }
        return res;

    }

    public static void main(String[] args) {

        int[] weights = {2, 5, 4, 7, 1, 3, 8};
        int binSize = 10;
        int numOfBinsReqd = bestFit(weights, binSize);
        System.out.println("Number of Bins Required: " + numOfBinsReqd);
    }

}
