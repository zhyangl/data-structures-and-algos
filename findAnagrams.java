// sliding window

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] sum = new int[26];
        for (char c : p.toCharArray()){
            sum[c-'a']++;
        }
        
        int start = 0, end = 0, match = 0;
        while (end < s.length()){
            if (sum[s.charAt(end) - 'a'] > 0) {
                match++;
            }
            sum[s.charAt(end) - 'a']--;
            end++;
            if (match == p.length()) {
                res.add(start);
            }
            
            if (end - start == p.length()){
                if (sum[s.charAt(start) - 'a'] >= 0) {
                    match--;
                }
                sum[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return res;
    }
}
