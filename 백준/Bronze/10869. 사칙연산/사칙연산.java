import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = a+b;
        int dif = a-b;
        int product = a*b;
        int na = a/b;
        int nam = a%b;

        //br bw모두 입출력이 string 이므로 형변환 꼭 해주기!
        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.write(String.valueOf(dif));
        bw.newLine();
        bw.write(String.valueOf(product));
        bw.newLine();
        bw.write(String.valueOf(na));
        bw.newLine();
        bw.write(String.valueOf(nam));

        // io close
        bw.close();
        br.close();
    }
}
