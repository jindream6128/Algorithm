class Solution {
    public int solution(int a, int b) {
        int ab = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int ba = 2*a*b;
        
        if(ab >= ba){
            return ab;
        }else{
            return ba;
        }
        
    }
}