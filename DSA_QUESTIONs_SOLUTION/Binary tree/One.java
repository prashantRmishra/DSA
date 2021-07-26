import java.util.*;
import java.io.*; 
/* Level order traversal is nothing but breadth first search */
public class One { 
    public static void main(String args[])  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            
            t--;
        }
    }
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    } 

} 

/* main code that you can use :
 static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> list =new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            list.add(temp.data);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            
        }
        return list;
    } */
