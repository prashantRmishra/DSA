public class Seven {
    /* Left view of the binary tree
    class Solution{
    //Function to return list containing elements of right view of binary tree.
    int height =0;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> leftView(Node node) {
        leftViewUtil(node,1);
        return list;
    }
    public void leftViewUtil(Node node , int level){
        
        if( node!=null && height < level){
            height=level;
            list.add(node.data);
        }
         if(node!=null && node.left!=null)
        leftViewUtil(node.left,level+1);
        if(node!=null && node.right!=null)
        leftViewUtil(node.right,level+1);
       
    }
} */
}
