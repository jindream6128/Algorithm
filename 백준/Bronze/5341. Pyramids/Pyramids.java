
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int pyramid(int n){
        int sum = 0;
        for(int i = 1; i<=n; i++){
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) {
                break;
            }
            System.out.println(pyramid(n));
        }
    }
}
