import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long [] maxTree;
    static long [] minTree;
    static int N;
    static int M;
    static int INF = 1000000000 + 1;

    public static long minUpdate(int nodeL, int nodeR, int node, int idx, int value){

        if(idx > nodeR || idx < nodeL){
            return minTree[node];
        }

        if(nodeL == nodeR){
            minTree[node] = value;
            return minTree[node];
        }

        int mid = (nodeL + nodeR)/2;
        minTree[node] = Math.min(minUpdate(nodeL, mid, node*2, idx, value) , minUpdate(mid+1, nodeR, node*2+1, idx, value));
        return minTree[node];

    }

    public static long maxUpdate(int nodeL, int nodeR, int node, int idx, int value){

        if(idx > nodeR || idx < nodeL){
            return maxTree[node];
        }

        if(nodeL == nodeR){
            maxTree[node] = value;
            return maxTree[node];
        }

        int mid = (nodeL + nodeR)/2;
        maxTree[node] = Math.max(maxUpdate(nodeL, mid, node*2, idx, value) , maxUpdate(mid+1, nodeR, node*2+1, idx, value));
        return maxTree[node];

    }

    public static long checkMax(int nodeL, int nodeR, int node, int idxL, int idxR){

        if(idxR < nodeL || idxL > nodeR){
            return 0;
        }
        if(idxL <= nodeL && nodeR <= idxR){
            return maxTree[node];
        }

        int mid = (nodeL + nodeR)/2;

        return Math.max(checkMax(nodeL, mid, node*2, idxL, idxR), checkMax(mid+1, nodeR, node*2+1, idxL,idxR));
    }

    public static long checkMin(int nodeL, int nodeR, int node, int idxL, int idxR){

        if(idxR < nodeL || idxL > nodeR){
            return INF;
        }
        if(idxL <= nodeL && nodeR <= idxR){
            return minTree[node];
        }

        int mid = (nodeL + nodeR)/2;
        return Math.min(checkMin(nodeL, mid, node*2, idxL, idxR), checkMin(mid+1, nodeR, node*2+1, idxL,idxR));
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxTree = new long[500001];
        minTree = new long[500001];

        for(int i = 1; i<= N; i++){
            int value = Integer.parseInt(br.readLine());
            maxUpdate(1, N, 1, i, value);
            minUpdate(1, N, 1, i, value);

        }
//        for(int i=1; i<=N*4; i++){
//            System.out.print(maxTree[i] + " ");
//        }

        for(int i =1; i<= M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idxL = Integer.parseInt(st.nextToken());
            int idxR = Integer.parseInt(st.nextToken());

            bw.write(checkMin(1, N, 1, idxL, idxR) + " " + checkMax(1, N, 1, idxL, idxR) + "\n");
        }
        bw.flush();
        bw.close();
    }
}

