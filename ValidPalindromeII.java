class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validSubstring(s, left + 1, right) || validSubstring(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean validSubstring(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
