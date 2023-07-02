import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    //1. 우선 1부터 n까지 중에서 k의 소인수가 몇개 들어가있는지 구하는 함수 하나 만들기.
    //n은 n k는 k의 소인수, k의 소인수의 갯수 (승)
    static long countNum(long n, long k, int c) {
        long sum = 0;
        long primeFactor = k;
        while (true) {
            sum = sum + (n / primeFactor); // k가 몇개 들어있는지
            if (primeFactor > n / k) {
                break;
            }
            primeFactor = primeFactor * k;
        }
        return sum / c;
    }

//    static boolean prime(int n){
//        for(long i =2;i*i<=n;i++){
//            if(n%i==0) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tcc = 0; tcc < tc; tcc++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long tmp = Long.MAX_VALUE; //임의로 tmp에는 max값을 넣어둔다.

            for (long i = 2; i * i <= k; i++) {
                //존재하면 소수가 아니다
                if (k % i == 0) {
                    int cnt = 0;
                    //k에 i가 몇개 존재하는지 check -> 여기서 check는 모두 소수만 한다.
                    while (k % i == 0) {
                        cnt++;
                        k = k / i;
                    }
                    //여기서 cnt는 k에 i즉 k의 소인수 i가 k몇개 들어있는가 찾기
                    // 다음으로는 이 i가 n!즉 1부터 n까지 몇개가 들어있는지 찾고, i의 지수의 배수만큼 몇개가 존재하는지 구해서 tmp값에 저장
                    tmp = Math.min(countNum(n, i, cnt), tmp);
                }
            }
            //소인수분해 마지막 즉 나누고 남은값이 1이 아닐때, -> 6을 소인수분해하면 2*3 3이 남는다 -> 1이 남는건 소수일때 밖에 없다.
            if (k > 1) {
                tmp = Math.min(countNum(n, k, 1), tmp);
            }
            sb.append(tmp).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }

}
