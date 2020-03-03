import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int [] pair;
    static char [] line;
    public static int func(int start, int end){

        int result = 0;

        for(int i = start; i < end; i++){
            if (line[i] == '('){
                result = result + (line[i-1] - '0') * func(i+1, pair[i]) -1;
                i = pair[i];
            }
            else if(line[i] == ')'){
                continue;
            }
            else {
                result += 1;
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        line = br.readLine().toCharArray();
        pair = new int [line.length];
        for(int i = 0; i < line.length; i++){

            if(line[i] == '('){
                stack.push(i);
            }
            else if(line[i] == ')'){
                pair[stack.pop()] = i;
            }
        }
        System.out.println(func(0, line.length));
    }
}
