import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int MAX = 1000000001;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine(), " ");
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long beforeZ = Y * 100 / X ;

        if(beforeZ >= 99){
            System.out.println(-1);
            System.exit(0);
        }

        int first = 1;
        int last = MAX;

        while (first < last) {

            int mid = (first + last) /2;

            long afterZ = (Y + mid) * 100 / (X + mid);

            if(afterZ > beforeZ){
                last = mid;
            }
            else {
                first = mid + 1;
            }
        }
        System.out.println(first);
    }
}

