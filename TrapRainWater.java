class TrapRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        if (left >= right) {
            return res;
        }
        
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if (leftHeight < rightHeight){
                left++;
                // 下坡
                if (leftHeight > height[left]){
                    res += leftHeight - height[left];
                } else {
                    // 上坡
                    leftHeight = height[left];
                }
            } else {
                // leftHeight >= rightHeight
                right--;
                if (rightHeight > height[right]){
                    res += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return res;
    }
}
