import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            //s 입력받기
            long s = Long.parseLong(br.readLine());
            // s만큼의 arr받기
            int[] s_arr = new int[1000001];
            String result = "YES";
            for(int j =2; j <1000001; j++){
                if(s%j==0){
                    result = "NO";
                }
            }
            bw.write(result);
            bw.newLine();

        }


        br.close();
        bw.flush();
    }
}
