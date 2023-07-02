

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int n;
    static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //n까지 소수만 골라서 prime arraylist에 넣기
        isprime(n);

        //투포인터로 합 구하기
        int L = 0,R=0,sum=0,cnt=0;

        while(L<=prime.size()){
            if(sum>=n){
                sum -= prime.get(L);
                L++;
            }else if(R>=prime.size()){
                break;
            }else{
                sum += prime.get(R);
                R++;
            }

            if(sum==n){
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    //입력받은 n만큼의 합을 구하는거니까 n을 넘어갈순 없다.
    //n까지의 소수 만 찾아서 prime의 Arraylist에 넣어둔다
    static void isprime(int n) {
        boolean[] arr = new boolean[n + 1];
        //일단 모두 소수로 가정
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (long i = 2; i * i <= n; i++) {
            if (arr[(int) i]) {
                for (long j = i * i; j <= n; j += i) {
                    arr[(int) j] = false;
                }
            }
        }

        //prime array list에 소수만 넣기
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                prime.add(i);
            }
        }

    }


}
