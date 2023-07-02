import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[101][101]; //2차원 배열 생성
        int sum =0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 1 ; i<n+1; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int xx = x; xx<x+10; xx++){
                for(int yy=y; yy<y+10;yy++){
                    arr[xx][yy] = 1;
                }
            }
        }
        for (int i = 1; i< 101; i++){
            for (int j = 1; j<101; j++){
                if(arr[i][j]!=0){
                    sum += 1;
                }
            }
        }
        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
    }
}
