import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt =0;
        int n = Integer.parseInt(br.readLine());

        //a b c 택희 영훈 남규
        //모두 1개이상
        for(int a =1;a<n+1;a++){
            for(int b = 1;b<n+1;b++){
                for(int c = b+2; c<n+1;c++){
                    if ((a+b+c == n) && (a%2 != 1)){
                        cnt +=1;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));

        br.close();
        bw.close();
    }
}
