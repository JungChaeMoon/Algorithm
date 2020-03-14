import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [][] map;
    static int N, M;
    static int max = 0;

    public static void changeMax(int a, int b){

        if(a < b){
            max = b;
        }
    }

    public static void tetromino1(){
        for(int i =0; i<N; i++){
            for(int j = 0 ; j<M; j++) {
                int result = 0;
                if (j + 4 > M)
                    break;
                result = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                changeMax(max, result);
            }
        }
        for(int i =0; i<N; i++){
            if(i + 4>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                changeMax(max, result);
            }
        }
    }

    public static void tetromino2(){


        for(int i = 0; i < N; i++){
            if(i + 2 > N)
                break;
            for(int j = 0; j < M; j++){
                int result = 0;
                if(j+2 > M)
                    break;
                result = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                changeMax(max, result);
            }
        }

    }
    public static void tetromino3(){

        for(int i = 0 ; i<N; i++){
            if(i+3 > N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(j+1 < M){
                    result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                    changeMax(max, result);
                }
            }
        }

        for(int i =0; i<N; i++){
            if(i+2>N)
                break;
            for(int j =0; j<M; j++){
                int result = 0;
                if(j+3 <= M){
                    result = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
                    changeMax(max, result);
                }
            }
        }

        for(int i = 0; i<N; i++){
            if(i+3>N)
                break;
            for(int j=0; j<M; j++){
                int result = 0;
                if(j+1 < M){
                    result = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    changeMax(max, result);
                }
            }
        }

        for(int i =0; i<N; i++){
            if(i+2 > N)
                break;
            for(int j =0;j<M; j++){
                int result = 0;
                if(0 <= j-2){
                    result = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+1][j-2];
                    changeMax(max, result);
                }
            }
        }

    }
    public static void tetromino4(){
        for(int i =0; i<N; i++){
            if(i +2 > N)
                break;
            for(int j =0; j<M; j++){
                if(0 <= j - 1 && j + 1 < M) {
                    int result = 0;
                    result = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i][j+1];
                    changeMax(max, result);
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(i + 3 > N)
                break;
            for(int j = 0; j < M; j++){
                int result = 0;
                if(j+2 > M)
                    break;
                result = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                changeMax(max, result);
            }
        }
    }
    public static void tetromino5(){

        for(int i = 0; i < N; i++){
            if(i+2 > N)
                break;
            for(int j = 0; j < M; j++){
                int result =0;
                if(j+3 > M)
                    break;
                result = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
                changeMax(max, result);
            }
        }

        for(int i = 0; i < N; i++){
            if(i+2>N)
                break;
            for(int j =0; j<M; j++){
                int result = 0;
                if(0 <= j-1 && j+1 < M) {
                    result = map[i][j] + map[i + 1][j - 1] + map[i + 1][j] + map[i + 1][j + 1];
                    changeMax(max, result);
                }
            }
        }

        for(int i =0; i<N; i++){
            if(i+3>N)
                break;
            for(int j =0; j<M; j++){
                int result = 0;
                if(0 <= j-1){
                    result = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+2][j];
                    changeMax(max, result);
                }
            }
        }

        for(int i =0; i<N; i++){
            if(i+3>N)
                break;
            for(int j = 0; j < M; j++){
                int result = 0;
                if(j+1 <  M){
                    result = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    changeMax(max, result);
                }
            }
        }
    }

    public static void tetromino6(){

        for(int i = 0; i<N; i++){
            if(i+2>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(j+2 < M){
                    result = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    changeMax(max, result);
                }

            }
        }

        for(int i = 0; i<N; i++){
            if(i+3>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(0<= j-1){
                    result = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+2][j-1];
                    changeMax(max, result);
                }
            }
        }
    }

    public static void tetromino7(){
        for(int i = 0; i<N; i++){
            if(i+2>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(j+3>M)
                    break;
                result = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                changeMax(max, result);
            }
        }

        for(int i = 0; i<N; i++){
            if(i+3>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(0<=j-1){
                    result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j-1];
                    changeMax(max, result);
                }
            }
        }

        for(int i = 0; i<N; i++){
            if(i+2>N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(0<=j-2){
                    result = map[i][j] + map[i+1][j] + map[i][j-1] + map[i][j-2];
                    changeMax(max, result);
                }
            }
        }

        for(int i = 0; i<N; i++){
            if(i+3 > N)
                break;
            for(int j = 0; j<M; j++){
                int result = 0;
                if(j+1<M){
                    result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
                    changeMax(max, result);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tetromino1();
        tetromino2();
        tetromino3();
        tetromino4();
        tetromino5();
        tetromino6();
        tetromino7();

        System.out.println(max);
    }
}
