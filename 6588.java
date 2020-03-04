import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean [] primeNumCheckList = new boolean[1000003];

    public static void calcPrimeNumber(){

        Arrays.fill(primeNumCheckList, true);
        for(int i = 2; i <= 1000000; i++) {
            for(int j = i * 2; j <= 1000000; j += i) {
                if(!primeNumCheckList[j])
                    continue;
                primeNumCheckList[j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {


        calcPrimeNumber();
        boolean flag = false;
        while(true){

            n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }

            int i = 3;
            int isPrimeNum = 0;
            for(; i<=1000000; i++){
                if(primeNumCheckList[i]){
                    isPrimeNum = n - i;
                    if(primeNumCheckList[isPrimeNum]){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag)
                bw.write(n + " " + '=' + " " + i + " "+ '+' +" " + isPrimeNum + "\n");
            else
                bw.write("Goldbach's conjecture is wrong." + "\n");
        }
        bw.flush();
        bw.close();
    }
}

