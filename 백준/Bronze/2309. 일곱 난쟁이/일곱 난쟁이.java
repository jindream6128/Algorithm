
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        };
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - arr[i] - arr[j]) == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for (int k = 2; k < 9; k++) {
                        bw.write(String.valueOf(arr[k]));
                        bw.newLine();
                    }
                    bw.close();
                    return;
                }
            }
        }
        br.close();
    }
}
