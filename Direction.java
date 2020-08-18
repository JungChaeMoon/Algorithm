import java.io.*;
import java.util.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        String [] dir = {"R", "U", "L", "D"};
        int [] dx = {0, -1, 0, 1};
        int [] dy = {1, 0, -1, 0};

        int row = 1;
        int col = 1;
        int nextRow = row;
        int nextCol = col;
        int count = st.countTokens();
        for(int i = 0; i< count; i++){
            String nd = st.nextToken();
            for(int j=0; j<4;j++){
                if (nd.equals(dir[j])){
                    nextRow = row + dx[j];
                    nextCol = col + dy[j];
                }
            }

            if(1<= nextRow && nextRow <=5 && 1<= nextCol && nextCol<=5){
                row = nextRow;
                col = nextCol;
            }
        }
        System.out.print(row);
        System.out.print(" "+col);
    }
}
