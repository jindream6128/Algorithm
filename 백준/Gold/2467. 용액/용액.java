

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        //용액 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L=1,R=n;
        long best_sum = arr[1]+arr[n];
        int index1=1,index2=n;

        while(L<R){
            long sum = arr[L]+arr[R];
            if(Math.abs(sum)<Math.abs(best_sum)){
                best_sum = sum;
                index1 = L;
                index2 = R;
            }

            if(sum>0){
                R--;
            }else{
                L++;
            }
        }
        System.out.print(arr[index1] +" "+ arr[index2]);

        br.close();
    }
}
