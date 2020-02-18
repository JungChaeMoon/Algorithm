import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long [] tree;
    static int N;
    static int M;
    static int K;


    public static long update(int nodeL, int nodeR, int node, int idx, int value){

        if (idx < nodeL || nodeR < idx)
            return tree[node];

        if(nodeL == nodeR){
            return tree[node] = value;
        }

        int mid = (nodeL + nodeR)/2;
        return tree[node] = update(nodeL, mid, node*2, idx, value) + update(mid+1, nodeR, node*2 +1, idx, value);

    }

    public static long sum(int nodeL, int nodeR, int node, int idxL, int idxR){

        if(idxL > nodeR || idxR <nodeL){
            return 0;
        }

        if(idxL <= nodeL  && nodeR <= idxR ){
            return tree[node];
        }

        int mid = (nodeL+nodeR)/2;
        return sum(nodeL, mid, node*2, idxL, idxR) + sum(mid+1, nodeR, node*2+1, idxL, idxR);

    }


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long [4000001];

        for (int i = 1; i <= N; i++) {
            int init = Integer.parseInt(br.readLine());
            update(1, N, 1, i, init);
        }

        for (int i = 1; i <= M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, N, 1, b, c);
            } else {
                System.out.println(sum(1, N, 1, b, c));
            }
        }
    }
}
