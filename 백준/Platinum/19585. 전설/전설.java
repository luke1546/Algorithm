import java.util.*;
import java.io.*;

public class Main{
    public static class Node{
    	char color;
        Node children[];
        boolean isEnd;
        public Node(char color){
        	this.color = color;
            children = new Node[26];
            isEnd = false;
        }
        public Node(){
        	children = new Node[26];
        	isEnd = false;
        }
        public Node child(char ch) {
        	return this.children[ch-'a'];
        }
    }
    static int C, N, Q;
    static Node colorRoot = new Node();
    static HashSet<String> names = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<C; i++){
	        String str = br.readLine();
	        addWord(colorRoot, str);
        }
        for(int i=0; i<N; i++){
	        String str = br.readLine();
	        names.add(str);
        }
        Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
	        String str = br.readLine();
		    if(colorCheck(str)) sb.append("Yes\n");
		    else sb.append("No\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void addWord(Node root, String str) {
    	Node curNode = root;
    	for(int j=0; j<str.length(); j++){
    		int index = str.charAt(j)-'a';
	        if(curNode.children[index] == null) curNode.children[index] = new Node(str.charAt(j));
	        curNode = curNode.children[index];
        }
        curNode.isEnd = true;
	}

	private static boolean colorCheck(String str){
	    Node curNode = colorRoot;
    	boolean flag = false;
	    for(int i=0; i<str.length(); i++){
	    	if(flag) break;
    		int index = str.charAt(i)-'a';
    		if(curNode.isEnd && str.length() - i <= 1000 && names.contains(str.substring(i))) return true;
		    if(curNode.children[index] != null) {
		    	curNode = curNode.children[index];
		    }else break;
	    }
	    return flag;
    }
}

/*
4 3
red
blue
purple
orange
shift
joker
noon
5
redshift
bluejoker
purplenoon
orangeshift
whiteblue

Yes
Yes
Yes
Yes
No
*/