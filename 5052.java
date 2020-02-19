import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int n;
    static String [] list;

    public static void main(String[] args) throws Exception{
        T= Integer.parseInt(br.readLine());
        for(int t =0; t<T; t++){
            n = Integer.parseInt(br.readLine());

            list= new String[n];
            boolean result = true;
            Trie trie = new Trie();

            for(int i=0;i<n;i++){
                list[i] = br.readLine();
            }
            Arrays.sort(list);

            for(int i = 0; i<n;i++){
                if(!trie.insert(list[i])){
                    result = false;
                    break;
                }
            }

            if(result)
                bw.write("YES" + "\n");
            else
                bw.write("NO" + '\n');
        }
        bw.flush();
        bw.close();
    }
}

class Trie{
    public static TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public boolean insert(String s) {
        TrieNode current = root;
        int len = s.length();
        for(int i=0;i<len;i++){
            char a = s.charAt(i);
            int next = a - '0';
            if(current.children[next]==null)
                current.children[next] = new TrieNode();

            current = current.children[next];

            if(current.isTerminal && i + 1 < len)
                return false;
        }
        current.isTerminal = true;
        return true;
    }

}


class TrieNode{
    TrieNode [] children = new TrieNode[10];
    boolean isTerminal;

    public TrieNode() {
        this.isTerminal = false;
    }
}
