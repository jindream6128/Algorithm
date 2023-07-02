import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		
		BigInteger ans = n.divide(m);
		BigInteger ans2 = n.remainder(m);
		

		System.out.println(ans);
		System.out.println(ans2);
		br.close();
	}

}