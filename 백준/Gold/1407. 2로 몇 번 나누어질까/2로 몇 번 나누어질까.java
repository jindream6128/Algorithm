
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long function(long n) {
        long num = n;
        long sum = 0; //1 2 3 4 n이 4일때 합
        long tmp ;
        long i = 1;
        while (num > 0) {
            if (num % 2 == 0) {
                //짝수일때
                tmp = num / 2;
            } else {
                //그 이외의 것들은 모두 1
                tmp = num/2 + 1;
            }
            sum += tmp*i;
            num = num -tmp;
            i=i*2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());


        System.out.println(function(b) - function(a - 1));

        br.close();
    }
}
