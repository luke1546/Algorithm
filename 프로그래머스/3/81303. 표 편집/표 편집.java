import java.util.*;

class Node{
    int id;
    Node next;
    Node prev;
    Node(int id){
        this.id = id;
    }
}

class Solution {
    static Node curNode;
    static Stack<Node> stack = new Stack<>();
    static int size;
    public String solution(int n, int k, String[] cmd) {
        size = n;
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i=0; i<n; i++) nodes.add(new Node(i));
        nodes.get(0).next = nodes.get(1);
        nodes.get(n-1).prev = nodes.get(n-2);
        for(int i=1; i<n-1; i++){
            nodes.get(i).prev = nodes.get(i-1);
            nodes.get(i).next = nodes.get(i+1);
        }
        curNode = nodes.get(k);
        for(int i=0; i<cmd.length; i++){
            String order[] = cmd[i].split(" ");
            if(order[0].equals("D")) move(0, Integer.parseInt(order[1]));
            else if(order[0].equals("U")) move(1, Integer.parseInt(order[1]));
            else if(order[0].equals("C")) delete();
            else restore();
        }
        StringBuilder answer = new StringBuilder("O".repeat(n));
        
        while(!stack.empty()) {
        Node node = stack.pop();
        answer.setCharAt(node.id, 'X');
        }
        return answer.toString();
    }
    
    void move(int d, int dis){
        for(int i=0; i<dis; i++) {
            if(d==0) curNode = curNode.next;
            else curNode = curNode.prev;
        }
    }
    
    void delete(){
        stack.push(curNode);
        Node preNode = curNode.prev;
        Node nextNode = curNode.next;
        if(preNode==null && nextNode != null){
            nextNode.prev = null;
            curNode = nextNode;
        }else if(preNode != null && nextNode == null){
            preNode.next = null;
            curNode = preNode;
        }else{
            preNode.next = nextNode;
            nextNode.prev = preNode;
            curNode = nextNode;
        }
    }
    
    void restore(){
        Node reNode = stack.pop();
        Node preNode = reNode.prev;
        Node nextNode = reNode.next;
        if(preNode != null) preNode.next = reNode;
        if(nextNode != null) nextNode.prev = reNode;
    }
}