
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int cnt; //사전순인지 chk할때 index
    //정답이 저장될 arr
    static int[] arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //n의 최대값이 10 이므로 10 + 1만큼의 배열만들기
        //-> why? 10을 제일 길게 나타낸게 1이 10번 더해진것이기 때문
        arr = new int[n+1];
        recur(0,0);

        if(cnt < k){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }

        br.close();
    }

    static void recur(int cur, int sum){

        if(cnt == k){
            return;
        }

        if(sum > n){
            return;
        }

        if(sum == n){
            cnt++;
            //내가찾는 k번째 수일때만 sb에 append
            if(cnt == k){
                for(int i = 0; i<cur;i++){
                    sb.append(arr[i]);
                    if(i != cur -1){
                        sb.append('+');
                    } //제일 마지막이 아닐때만
                }
            }
            return;
        }

        for(int i = 1;i<=3;i++){
            arr[cur] = i;
            recur(cur+1, sum+i);
        }

    }
}
