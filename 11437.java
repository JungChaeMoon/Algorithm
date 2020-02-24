import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [] parent;
    static int [] depth;
    static int N;
    static boolean [][] graph;
    static ArrayList<Integer> [] list;
    static boolean[] visited;
    static Stack<Integer> stk = new Stack<>();

    public static void dfs (int start, int height){
        visited[start] = true;
        stk.push(start);

        while(!stk.isEmpty()){
            int node = stk.pop();
            for(int i : list[node]) {
                if(!visited[i]) {
                    stk.push(i);
                    depth[i] = depth[node] +1;
                    parent[i] = node;
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        visited = new boolean [N+1];
        parent = new int [N+1];
        depth = new int [N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[r].add(c);
            list[c].add(r);
        }
        dfs(1, 1);

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int aDepth;
            int bDepth;

            while (depth[a] != depth[b]) {
                aDepth = depth[a];
                bDepth = depth[b];

                if (depth[a] > depth[b]) {
                    a = parent[a];
                } else if (depth[a] < depth[b]) {
                    b = parent[b];
                }
            }

            while (parent[a] != parent[b]) {

                a = parent[a];
                b = parent[b];
            }

            if (a == b) {
                System.out.println(a);
            } else {
                System.out.println(parent[a]);
            }
        }
    }
}

