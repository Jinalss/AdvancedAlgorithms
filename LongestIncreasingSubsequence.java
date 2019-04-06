public class LongestIncreasingSubsequence {

    private static int ceilElement( int[] table, int l, int r, int key){

        while(r-l > 1){
            int m = l+(r-1)/2;
            if(table[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    private static int getLongestIncreasingSubsequenceLength(int[] A){

        int lengthOfSequence = 1;
        int[] table = new int[A.length];
        table[0] = A[0];
        for (int i = 1; i < A.length; i++) {

            if(A[i] < table[0]){
                table[0] = A[i];
            }else if(A[i] > table[lengthOfSequence-1]){
                table[lengthOfSequence++] = A[i];
            }else{
                table[ceilElement(table, 1, lengthOfSequence-1, A[i])] = A[i];
            }

        }

        return lengthOfSequence;

    }

    public static void main(String[] args) {

        int A[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        System.out.println("Longest increaing subsequence length is " + getLongestIncreasingSubsequenceLength(A));

    }

}
