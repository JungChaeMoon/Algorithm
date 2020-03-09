import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), " ");

        int JE = Integer.parseInt(st.nextToken());
        int JS = Integer.parseInt(st.nextToken());
        int JM = Integer.parseInt(st.nextToken());

        int E = 0;
        int S = 0;
        int M = 0;

        int cnt = 0;

        while (true) {
            if(JE == E && JS == S && JM == M)
                break;
            else {
                E++;
                S++;
                M++;
                if(E % 16 ==0) E = 1;
                if(S % 29 ==0) S = 1;
                if(M % 20 ==0) M = 1;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
