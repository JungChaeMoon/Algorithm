import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [][] map;
    static int N, M;
    static int [] dir_x = {-1, 0, 1, 0};
    static int [] dir_y = {0, 1, 0, -1};
    static int possibleAria = 0;

    public static int ans(){
        int area = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == -1)
                    area++;
            }
        }
        return area;
    }

    public static void Robot(int r, int c, int d) {

        int cnt = 0;

        while(true) {

            if (cnt == 4) {
                int br = r - dir_x[d];
                int bc = c - dir_y[d];

                if(map[br][bc] != 1){
                    r = br;
                    c = bc;
                    cnt = 0;
                }
                else{
                    System.out.println(ans());
                    break;
                }
            }

            if (map[r][c] == 0) {
                map[r][c] = -1;
            }
            int nd = (d + 3) % 4;
            int nr = r + dir_x[nd];
            int nc = c + dir_y[nd];

            if(map[nr][nc] == 0){
                r = nr;
                c = nc;
                d = nd;
                cnt = 0;
            }
            else {
                d = nd;
                cnt++;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Robot(r, c, d);
    }
}
