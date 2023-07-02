import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long gcd(long a, long b) {
        long tmp;
        //항상 앞에가 더 크도록
        if (a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        while (a % b > 0) {
            //a%b!=0
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ingcd = Long.parseLong(st.nextToken());
        long inlcm = Long.parseLong(st.nextToken());

        long tmp = ingcd * inlcm;
        long sumans = 0;
        long summin = tmp;
        long test;
        long ans1 = 0;
        long ans2 = 0;
        //ingcd랑 inlcm이 같은경우도 있다.
        if(ingcd == inlcm){
            ans1=ingcd;
            ans2=ingcd;
        }

        //i는 x,y의 약수이면서, gcd의 배수여야 한다.
        for (long i = ingcd; i * i <= tmp; i += ingcd) {
            //약수일때
            if (tmp % i == 0) {
                test = tmp / i;
                //찾은 쌍의 최대 공약수가 ingcd랑 같아야 한다.
                if (gcd(i, test) == ingcd) {
                    //쌍의 최솟값 찾기
                    sumans = test + i; //쌍의 합
                    if (summin > sumans) {
                        summin = sumans;
                        ans1 = i;
                        ans2 = test;
                    }
                }
            }
        }
        System.out.print(ans1 + " " + ans2);
        br.close();
    }
}
