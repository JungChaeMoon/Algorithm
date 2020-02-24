import java.io.*;
import java.util.*;

class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int [][] map;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int INF = 987654321;
    static boolean [] visited;

    public static int prim (int node) {
        int result = 0;

        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if(map[node][i] != 0)
                pq.add(new Edge(node, i, map[node][i]));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!visited[edge.v2]) {
                visited[edge.v2] = true;
                result += edge.cost;
                for (int i = 1; i <= N; i++) {
                    if (map[edge.v2][i] != 0) {
                        pq.add(new Edge(edge.v2, i, map[edge.v2][i]));
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception{

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int [N+1][N+1];
        visited = new boolean [N+1];

        for(int i =0 ; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[r][c] = w;
            map[c][r] = w;
        }
        System.out.println(prim(1));
    }
}

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        if(this.cost >= o.cost)
            return 1;
        else
            return -1;
    }
}
