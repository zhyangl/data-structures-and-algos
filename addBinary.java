class Solution {
    
    boolean carry;
    
    public String addBinary(String a, String b) { 
        int first = a.length() - 1;
        int second = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        while (first >=0 && second >= 0) {
            int res = getResult(a.charAt(first), b.charAt(second));
            sb.insert(0, res);
            first--;
            second--;
        }
        
        while (first >= 0) {
            int res = getResult(a.charAt(first), '0');
            sb.insert(0, res);
            first--;
        }
            
        while (second >=0) {
            int res = getResult('0', b.charAt(second));
            sb.insert(0, res);
            second--;
        }
        
        if (carry){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
    
    private int getResult(char x, char y) {
        int res = 0;
        if (carry){
            if (x == '0' && y == '0') {
                res = 1;
                carry = false;
            } else if (x=='0' && y =='1' || x=='1' && y=='0'){
                res = 0;
                carry = true;
            } else if (x == '1' && y == '1') {
                res = 1;
                carry = true;
            }
        } else {
            if (x == '0' && y == '0') {
                res = 0;
                carry = false;
            } else if (x=='0' && y =='1' || x=='1' && y=='0'){
                res = 1;
                carry = false;
            } else if (x == '1' && y == '1') {
                res = 0;
                carry = true;
            }
        }
        return res;
    }
}
