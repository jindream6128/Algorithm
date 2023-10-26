import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 데이터
        int tc = Integer.parseInt(br.readLine());

        //H 층수 W 방수 N 몇 번째 손님
        for(int i = 0; i<tc ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //그냥 1호 배정해주면 된다
            if(N % H == 0){
                sb.append((H*100) + (N/H)).append("\n");
            }else {
                sb.append((N % H) * 100 + ((N / H) + 1)).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
