public class TrappingRainWater {

    public static int trap(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                if (height[lo] > leftMax) leftMax = height[lo];
                res += leftMax - height[lo];
                lo += 1;
            } else {
                if (height[hi] > rightMax) rightMax = height[hi];
                res += rightMax - height[hi];
                hi -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

}
