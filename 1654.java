import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long [] lanCable;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        lanCable = new long [K+1];

        for(int i =1; i <= K; i++){
            lanCable[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanCable);

        long first = 1;
        long last = lanCable[K];

        while (first <= last){
            long mid = (first + last) /2;
            long cnt = 0;
            for(int i = 1; i<= K; i++){
                cnt += (lanCable[i] / mid);
            }

            if(N > cnt){
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }
        System.out.println(first -1);
    }
}
