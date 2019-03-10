public class KMPAlgorithm {

    private int[] computeTempArray(String pattern){

        int[] result = new int[pattern.length()];

        int j=0;
        for (int i = 1; i < pattern.length(); i++) {

            result[i] = 0;
            if(pattern.charAt(j) == pattern.charAt(i)){
                result[i] = ++j;
            }else{
                while(pattern.charAt(j) != pattern.charAt(i) && j > 0) {
                    j = result[j - 1];
                }
                if(pattern.charAt(j) == pattern.charAt(i)) result[i] = ++j;
            }

        }

        return result;

    }

    public void kmpPatternMatching(String pattern, String text){

        int[] arr = computeTempArray(pattern);
        int i = 0, j=0;
        while(i < text.length()){

            if(pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }

            if(j==pattern.length()){
                System.out.println("Pattern found at location " + (i-j));
                j = arr[j-1];
            }else{
                if(i < text.length() && pattern.charAt(j) != text.charAt(i)){
                    if( j > 0)
                        j = arr[j-1];
                    else
                        i++;
                }
            }

        }

    }

    public static void main(String[] args) {

        String pattern = "abcaby";
        String text = "abxabcabcaby";
        new KMPAlgorithm().kmpPatternMatching(pattern, text);

    }

}
