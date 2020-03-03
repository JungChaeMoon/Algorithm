import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, R;
    static int [][] map;
    static boolean [][] visited;
    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, -1, 1};
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qy = new LinkedList<>();
    static Queue<Nation> checkList = new LinkedList<>();
    static int result = 0;
    static int cnt = 1;
    static int ans = 0;

    public static void update(){
        int move = result /(cnt);
        for(Nation nation : checkList){
            map[nation.x][nation.y] = move;
        }
    }


    public static boolean find(){
        boolean flag = true;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!visited[i][j]){
                    checkList = new LinkedList<>();
                    checkList.add(new Nation(i, j));
                    bfs(i, j);
                    if(checkList.size()>1){
                        update();
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }


    public static void bfs(int start, int end) {

        qx.add(start);
        qy.add(end);
        result = map[start][end];
        visited[start][end] = true;
        cnt = 1;

        while (!qx.isEmpty() && !qy.isEmpty()) {
            start = qx.poll();
            end = qy.poll();

            for(int i = 0; i < 4; i++){
                int nx = start + dir_x[i];
                int ny = end + dir_y[i];

                if((1<=nx && nx <=N)&&(1<=ny && ny<=N)){
                    int div = map[start][end] - map[nx][ny];
                    if((L <= Math.abs(div) && Math.abs(div) <= R) && !visited[nx][ny]){
                        result += map[nx][ny];
                        cnt ++;
                        checkList.add(new Nation(nx, ny));
                        qx.add(nx);
                        qy.add(ny);
                        visited[nx][ny] =true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        st= new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int [N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N+1][N+1];
            if(!find())
                ans++;
            else
                break;

            find();
        }
        System.out.println(ans);
    }
}

class Nation {
    int x;
    int y;

    Nation(int x, int y){

        this.x = x;
        this.y = y;
    }
}
