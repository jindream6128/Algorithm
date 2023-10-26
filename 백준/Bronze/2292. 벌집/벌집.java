import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력
        int n = Integer.parseInt(br.readLine());

        //cnt(몇 겹인지)
        int cnt = 1;

        //total (벌집 갯수) -> 1일땐 위에서 거르므로
        int total = 2;

        //한겹 일때
        if(n == 1){
            System.out.println("1");
        }else{
            //전체 벌집갯수 <= n 이어야 한다
            while(total <= n){
                total = total + (6*cnt);
                cnt++;
            }
            System.out.println(cnt);
        }

        br.close();
    }
}
