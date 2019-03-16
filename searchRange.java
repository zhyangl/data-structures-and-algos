class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int leftMost = findMost(nums, target, true);
        int rightMost = findMost(nums, target, false);
        return new int[]{leftMost, rightMost};    
    }
    
    // binary search template
    private int findMost(int[] nums, int target, boolean findLeft) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if(findLeft) high = mid;
                else low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        if (findLeft) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target){
                return high;
            }
        } else {
            if (nums[high] == target) {
                return high;
            }
            if (nums[low] == target){
                return low;
            }
        }
        return -1;
    }
}
