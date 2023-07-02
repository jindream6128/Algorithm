import java.io.*;

public class Main {
    //모두 보일려면 겹치는 기울기가 있어서는 안된다 !
    // 따라서 서로 다른 기울기를 가지는 좌표의 갯수를 전부 구하면 된다.
    // 서로다른 기울기 -> 분모, 분자의 최대공약수가 1인 수를 찾으면 된다.

    //    최대공약수 구하기 gcd
    static int gcd(int a, int b) {
        int tmp;
        //항상 앞에가 더 크도록
        if (a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }

        while (a % b > 0) {
            //a%b!=0
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    //    private static long gcd(long a, long b) {
//        return b == 0 ? a : gcd(b, a % b);
//    }
    static int[] cache = new int[1001];
    
    static void precalculate() {
        //기울기가 1인거랑, x,y축 에 올라가있는거 각 1개씩 총2개
        //기본적으로 n이 1일때 x축, y축 기울기 1 인거 3개 존재
        cache[1] = 3;
        //n이 1000까지니까 각 n마다의 기울기 저장해놓기
        for (int a = 2; a <= 1000; a++) {
            int cnt = 0;
            //b는 a까지만 돌고 나중에 *2해주기
            for (int b = 1; b < a; b++) {
                //만약 최대공약수가 1이면 기울기가 다른거이므로 cnt +1
                if (gcd(a, b) == 1) {
                    cnt++;
                }
            }
            //직전꺼 + n이 커졌을때 꺼만 cnt하면 된다
            cache[a] = cache[a - 1] + cnt * 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        precalculate();

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i <tc;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(cache[n]));
            bw.newLine();
        }

//        while(tc-- > 0){
//            int n = Integer.parseInt(br.readLine());
//            bw.write(String.valueOf(allcase(n)));
//            bw.newLine();
//        }

        bw.close();
        br.close();
    }
}
