import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Integer [] array;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        array = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, Collections.reverseOrder());

        int count = 0;
        int answer = 0;
        for(int i = 0; i<M; i++){
            if(count == K){
                count = 0;
                answer += array[1];
            }
            else {
                answer += array[0];
                count++;
            }
        }

        System.out.print(answer);
    }
}
