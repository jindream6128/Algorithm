
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //arr배열 먼저 입력받기 -> arr[1][1], arr[1][2], arr[1][3]이렇게 가로로 만들기
        //i가 x좌표 j가 y좌표
        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //sum배열 반들기
        //i가 x좌표 j가 y좌표
        int[][] sumarr = new int[n+1][n+1];
        for(int i =1;i<n+1;i++){
            for(int j = 1; j<n+1;j++){
                sumarr[i][j] = sumarr[i-1][j]+sumarr[i][j-1]-sumarr[i-1][j-1] + arr[i][j];
            }
        }

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = sumarr[x2][y2] - sumarr[x2][y1 - 1] - sumarr[x1 - 1][y2] + sumarr[x1 - 1][y1 - 1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
