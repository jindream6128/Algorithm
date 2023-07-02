import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        System.out.println(Factorial(n));
        br.close();
    }

    static Long Factorial(Long n) {
        if(n <= 1){
            return 1L;
        }else{
            return n * Factorial(n-1L);
        }
    }
}
