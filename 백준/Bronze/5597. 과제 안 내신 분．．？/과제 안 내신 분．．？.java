import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //정수형 30개 배열생성
        int[] arr = new int[31];
        //28개 입력
        for(int i = 0; i < 28; i++){
            arr[Integer.parseInt(br.readLine())]=1;
        }
        //n은 1부터다
        for(int i =1;i<arr.length;i++){
            if (arr[i] != 1){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}