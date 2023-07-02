import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //제일작은 수
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); //제일 큰수
        int n = Integer.parseInt(st.nextToken());
        int ans=0;
        int re;

        for(int i =0;i<50;i++){
            for(int j =0;j<50;j++){
                for(int k =0; k<50;k++){
                    if (((a*i)+(b*j)+(c*k))==0) ans =1;
                }
            }
        }
        
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
    }
}
