
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //일단 입력 n 자체는 2억까지
        long n = Long.parseLong(br.readLine());
        long ans = 0;

        ans -= n;
        ans -= (n*(n+1))/2;
        ans += 1;
        for(int i =1;i<=n;i++){
            ans += (i*(n/i));
            ans %= 1_000_000;
        }

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}
