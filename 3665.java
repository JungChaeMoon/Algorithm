import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [] oldRank;
    static boolean [][] graph;
    static int [] indegree;

    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();

            oldRank = new int [n+1];
            indegree = new int [n+1];
            graph = new boolean [n+1][n+1];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 1; i <= n; i++){
                oldRank[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                for(int j = i + 1; j <= n; j++){
                    graph[oldRank[i]][oldRank[j]] = true;
                    indegree[oldRank[j]] += 1;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for(int i = 0; i < m; i++){

                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!graph[a][b]){
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
                else{
                    indegree[a] += 1;
                    indegree[b] -= 1;

                }
                graph[a][b] = !graph[a][b];
                graph[b][a] = !graph[b][a];
            }

            for(int i =1; i <= n; i++){         //위상정렬
                if (indegree[i] == 0){
                    q.add(i);
                }
            }
            int loopCnt = 0;
            String result ="";
            while(!q.isEmpty()){
                if(q.size() >= 2){
                    System.out.println("?");
                    break;
                }
                loopCnt++;

                int node = q.poll();
                result = result + node + " ";
                for(int i = 1; i <= n; i++){
                    if(graph[node][i]) {
                        graph[node][i] = false;
                        indegree[i] -= 1;
                        if(indegree[i] == 0)
                            q.add(i);
                    }

                }
            }
            if(loopCnt != n){
                System.out.println("IMPOSSIBLE");
            }
            else{

                System.out.println(result);
            }
        }
    }
}

