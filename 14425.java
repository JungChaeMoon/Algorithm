import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Trie trie = new Trie();

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            trie.insert(line);
        }

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            cnt += trie.check(line);
        }
        System.out.println(cnt);
    }
}

class Trie{

    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String s){
        int len = s.length();
        TrieNode current = this.root;

        for(int i = 0;i < len; i++){
            char a = s.charAt(i);
            int next = a - 'a';
            if(current.children[next] == null){
                current.children[next] = new TrieNode();
            }

            if(i == len -1){
                current.isTerminal = true;
                break;

            }
            current = current.children[next];
        }
    }

    public int check(String s){
        int len = s.length();
        TrieNode current = this.root;

        for(int i = 0;i < len; i++){
            char a = s.charAt(i);
            int next = a - 'a';
            if(current.children[next] == null){
                break;
            }

            if(i == len -1){
                if(!current.isTerminal){
                    current.isTerminal = true;
                    return 0;
                }
                return 1;
            }
            current = current.children[next];
        }
        return 0;
    }
}


class TrieNode{
    TrieNode [] children = new TrieNode[27];
    boolean isTerminal;

    TrieNode(){
        this.isTerminal = false;
    }
}

