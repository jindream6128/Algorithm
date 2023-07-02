import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char al = br.readLine().charAt(0);
        int ans = (int)al;

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();

    }
}
