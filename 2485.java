import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [] tree;
    static int [] dist;
    static int result;

    public static int gcd(int a, int b){
        int temp;

        if( b > a ){
            temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;

    }

    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(br.readLine());

        tree = new int [N+1];
        dist = new int [N+1];
        for(int i = 1; i<=N; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tree);

        for(int i = 1; i < N; i++)
            dist[i] = tree[i+1] - tree[i];

        int a = gcd(dist[1], dist[2]);
        for(int i =2; i < N; i++)
            a = gcd(a, dist[i+1]);

        for(int i =1; i<N; i++){
            int ans = dist[i] / a;
            if(ans > 1)
                result += (ans-1);
        }

        System.out.println(result);



    }
}
