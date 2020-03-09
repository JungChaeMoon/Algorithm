import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Machine> mc = new ArrayList<>();
    static int R, C, T;
    static int [] dir_x = {-1, 0, 1, 0};
    static int [] dir_y = {0, 1, 0, -1};
    static boolean [] visited = new boolean[4]; //북동남서
    static int [][] map;
    static int [][] diffusionMap;

    public static void diffusion(){

        for(int i =1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                int cnt = 0;
                Arrays.fill(visited, false);
                if(map[i][j] > 0){
                    for(int t = 0; t < 4; t++){
                        int nx = i + dir_x[t];
                        int ny = j + dir_y[t];
                        if((1<=nx && nx <= R) && (1 <= ny && ny <=C)){
                            if(map[nx][ny] != -1){
                                cnt++;
                                visited[t] = true;
                            }
                        }
                    }
                    diffusionMap[i][j] = diffusionMap[i][j] + map[i][j] - (map[i][j]/5) * cnt;
                    for(int t =0; t<4; t++){
                        if(visited[t]){
                            int nx = i + dir_x[t];
                            int ny = j + dir_y[t];
                            if((1<=nx && nx <= R) && (1 <= ny && ny <=C))
                                diffusionMap[nx][ny] = diffusionMap[nx][ny] + (map[i][j] / 5);
                        }
                    }
                }
            }
        }
    }

    public static void air(){

        for(int t = 0; t < 2; t++) {
            Machine machine = mc.get(t);

            if(t == 0){
                int temp = diffusionMap[machine.x][C];
                for(int i = C; i >= machine.y+1; i--){
                    if(i == machine.y + 1){
                        diffusionMap[machine.x][i] = 0;
                        continue;
                    }
                    diffusionMap[machine.x][i] = diffusionMap[machine.x][i-1];
                }
                int temp2 = diffusionMap[1][C];

                for(int i = 1; i < machine.x; i++){
                    if(i == machine.x -1){
                        diffusionMap[i][C] = temp;
                        continue;
                    }
                    diffusionMap[i][C] = diffusionMap[i+1][C];
                }
                temp = diffusionMap[1][machine.y];
                for(int i = 1; i < C; i++){
                    if(i == C-1){
                        diffusionMap[1][i] = temp2;
                        continue;
                    }
                    diffusionMap[1][i] = diffusionMap[1][i+1];
                }
                temp2 = diffusionMap[machine.x - 1][machine.y];
                for(int i = machine.x -1; i > 1; i--){
                    if(i == 2){
                        diffusionMap[i][machine.y] = temp;
                        continue;
                    }
                    diffusionMap[i][machine.y] = diffusionMap[i-1][machine.y];
                }
            }
            else {
                int temp = diffusionMap[machine.x][C];
                for(int i = C; i >= machine.y+1; i--){
                    if(i == machine.y + 1){
                        diffusionMap[machine.x][i] = 0;
                        continue;
                    }
                    diffusionMap[machine.x][i] = diffusionMap[machine.x][i-1];
                }

                int temp2 = diffusionMap[R][C];
                for(int i = R; i > machine.x; i--){
                    if(i == machine.x + 1){
                        diffusionMap[i][C] = temp;
                        continue;
                    }
                    diffusionMap[i][C] = diffusionMap[i-1][C];
                }
                temp = diffusionMap[R][machine.y];
                for(int i = machine.y; i < C; i++){

                    if(i == C-1){
                        diffusionMap[R][i] = temp2;
                        continue;
                    }
                    diffusionMap[R][i] = diffusionMap[R][i+1];
                }
                temp2 = diffusionMap[machine.x+1][machine.y];
                for(int i = machine.x+1; i < R; i++){

                    if(i == R -1){
                        diffusionMap[i][machine.y] = temp;
                        continue;
                    }
                    diffusionMap[i][machine.y] = diffusionMap[i+1][machine.y];
                }
            }
        }
        for (int i = 0; i < diffusionMap.length; i++) {
            System.arraycopy(diffusionMap[i], 0, map[i], 0, diffusionMap[i].length);
        }
    }

    public static void ans(){
        int result = 0;
        for(int i = 1; i<=R; i++){
            for(int j =1; j<=C; j++){
                if(map[i][j] > 0)
                   result += map[i][j];
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        diffusionMap = new int [R+1][C+1];

        for(int i = 1; i <= R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    diffusionMap[i][j] = -1;
                    mc.add(new Machine(i, j));
                }
            }
        }

        for(int k = 0; k<T; k++){
            diffusion();
            air();
            diffusionMap = new int [R+1][C+1];
            diffusionMap[mc.get(0).x][mc.get(0).y] = -1;
            diffusionMap[mc.get(1).x][mc.get(1).y] = -1;
        }
        ans();
    }
}

class Machine {
    int x, y;

    Machine(int x, int y){
        this.x = x;
        this.y = y;
    }
}
