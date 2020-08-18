import java.io.*;
import java.util.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] nx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int [] ny = {-1, 1, 2, 2, 1, -1, -2, -2};
    static char [] row = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    static char [] col = {'1', '2', '3', '4', '5', '6', '7', '8'};
    public static void main(String[] args) throws Exception{
        String line = br.readLine();
        int x = 0;
        int y = 0;
        for(int i = 0; i < 8; i++){
            if(line.charAt(0) == row[i]){
                x = col[i] - '0';
                y = line.charAt(1) - '0';
                break;
            }
        }
        int count = 0;
        for(int i = 0; i < 8; i++){
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (1<=nextX && nextX<=8 && 1<=nextY && nextY <=8){
                count++;
            }
        }
        System.out.println(count);
    }
}
