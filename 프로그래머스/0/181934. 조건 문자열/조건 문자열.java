class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        // eq가 "="인 경우
        if (eq.equals("=")) {
            if (ineq.equals("<")) {
                return n <= m ? 1 : 0;
            } else {
                return n >= m ? 1 : 0;
            }
        } 
        // eq가 "!="인 경우
        else {
            if (ineq.equals("<")) {
                return n < m ? 1 : 0;
            } else {
                return n > m ? 1 : 0;
            }
        }
        
    }
}