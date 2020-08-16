import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        while (true){
            while (true){
                if (N / K == 1){
                    N = N / K;
                    count++;
                    break;
                }
                if (N % K != 0){
                    break;
                }
                N = N / K;
                count++;
            }
            if (N == 1){
                break;
            }
            N -= 1;
            count++;
        }

        System.out.println(count);
    }
}
