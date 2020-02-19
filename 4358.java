import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String,Integer> hashMap = new HashMap<>();
    static TreeMap<String, Integer> tm;

    public static void main(String[] args) throws Exception{

        String line = "";
        int cnt = 0;
        while ((line = br.readLine()) != null && line.length() != 0){
            cnt += 1;
            if(hashMap.containsKey(line))
                hashMap.put(line, hashMap.get(line)+1);
            else{
                hashMap.put(line, 1);
            }
        }

        tm = new TreeMap<String, Integer>(hashMap);
        Iterator<String> iteratorKey = tm.keySet().iterator();

        while(iteratorKey.hasNext()){
            String key = iteratorKey.next();
            Double result = (tm.get(key)/(double)cnt) *100;
            bw.write(key + " " + String.format("%.4f", result) + '\n');
        }
        bw.flush();
        bw.close();
    }
}
