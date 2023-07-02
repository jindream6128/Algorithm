import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //num안에 d가 포함되어 있는지 check
    public static boolean check(int num, int d) {
        while (num > 0) {
            if (num % 10 == d) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //일단 1부터 4_000_000 까지 전체 소수 체크
        boolean[] isNotPrime = new boolean[4_000_001];
        isNotPrime[1] = true; //1은 제외
        //소수가 아니면 true이다
        //에라토스테네스의 체 로 걸러내기
        for (int i = 2; i <= 4_000_000; i++) {
            if (isNotPrime[i] == false) {
                for (long chk =(long) i*i; chk < 4_000_001; chk+=i) {
                    isNotPrime[(int) chk] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = a; i <= b; i++) {
            //범위 내에서 확인하기
            if (!isNotPrime[i] && check(i, d)) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
