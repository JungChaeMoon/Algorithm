import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [][] arr = new int [5000][5000];

    public static void main(String[] args) throws Exception{
        int x = Integer.parseInt(br.readLine());

        if(x==1){
            System.out.println("1/1");
            System.exit(0);
        }
        else {
            int i = 1;
            int j = 1;
            int cnt = 1;
            loop:
            while(true){
                if(i == 1){
                    if(cnt == x){
                        System.out.print(i);
                        System.out.print('/');
                        System.out.print(j);
                        break;
                    }
                    j++;
                    cnt++;
                    while(j!=1){
                        if(cnt == x){
                            System.out.print(i);
                            System.out.print('/');
                            System.out.print(j);
                            break loop;
                        }
                        i++;
                        j--;
                        cnt++;
                    }
                }

                else if(j == 1){
                    if(cnt == x){
                        System.out.print(i);
                        System.out.print('/');
                        System.out.print(j);
                        break;
                    }
                    i++;
                    cnt++;
                    while(i!=1){
                        if(cnt == x){
                            System.out.print(i);
                            System.out.print('/');
                            System.out.print(j);
                            break loop;
                        }
                        j++;
                        i--;
                        cnt++;
                    }
                }
            }
        }
    }
}

