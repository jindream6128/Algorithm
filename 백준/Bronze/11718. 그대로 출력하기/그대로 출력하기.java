import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            String test = br.readLine();
            //끝나는 부분 정하기, 공백이거나 비어있을떄
            if(test == null || test.isEmpty()){
                break;
            }
            //그게 아니면 한줄씩 sb에 append 하고 줄바꾸기
            sb.append(test).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}