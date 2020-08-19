import javax.swing.plaf.TreeUI;
import java.io.*;
import java.util.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [][] map;
    static int [] direction = {0, 1, 2, 3};
    static int [] dx = {0, -1, 0, 1};
    static int [] dy = {-1, 0, 1, 0};

    static boolean [] check = {false, false, false, false};

    public static boolean checkDirection(){
        int count = 0;
        for(int i =0; i<4;i++){
            if (check[i]){
                count ++;
            }
        }
        return count == 4;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int count = 1;
        for(int i = 0; i < N; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        loop:
        while (true){
            map[x][y] = 1;
            for(int i =0;i<4;i++){
                int k = (i + 1) % 4;
                if (d== direction[i]){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if(map[nextX][nextY] == 1){
                        d = direction[k];
                        check[k] = true;
                    }
                    else{
                        d = direction[k];
                        x = nextX;
                        y = nextY;
                        map[x][y] = 1;
                        count ++;
                        break;
                    }

                    if(checkDirection()){
                        int m = d + 2 % 4;
                        nextX = x + dx[m];
                        nextY = x + dy[m];
                        if(map[nextX][nextY] == 1){
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
}
