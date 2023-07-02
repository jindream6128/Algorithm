import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = fact(n);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static int fact(int n){
        if(n<=1)
            return 1;
        else
            return fact(n-1)*n;
    }
}