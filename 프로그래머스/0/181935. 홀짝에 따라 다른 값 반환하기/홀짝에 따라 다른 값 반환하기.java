class Solution {
    public int solution(int n) {
        
         if(n % 2 ==0){
             //짝수합
             return num2(n);
         }else{
             //홀수합
             return num1(n);
         }
        
    }
    //홀수합
    private int num1(int n){
        //n이하의 모든 양의 홀수의 합
        int num1_sum = 0;
        for(int i =0 ;i<=n ; i++){
            if(i%2 != 0){
                num1_sum += i;
            }
        }
        return num1_sum;
    }
    //짝수 합
    private int num2(int n){
        //n이하의 모든 짝수의 제곱의합
        int num2_sum = 0;
        for(int i =0; i<=n; i++){
            if(i%2 == 0){
                num2_sum += i*i;
            }
        }
        return num2_sum;
    }
}