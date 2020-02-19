import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, Integer> hashMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            hashMap.put(line, 1);
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            if (hashMap.containsKey(line))
                cnt += hashMap.get(line);
        }

        System.out.print(cnt);
    }
}
