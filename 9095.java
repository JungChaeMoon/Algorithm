import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        int T  = Integer.parseInt(br.readLine());

        int [] dp = new int [11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            for(int j = 4; j<=n; j++){

                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            System.out.println(dp[n]);
        }

    }

}
