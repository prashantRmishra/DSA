public class Eight {
    
    /* 
    Right view Of the Binary tree
    
    class Solution{
    //Function to return list containing elements of right view of binary tree.
    int height =0;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> rightView(Node node) {
        rightViewUtil(node,1);
        return list;
    }
    public void rightViewUtil(Node node , int level){
        
        if( node!=null && height < level){
            height=level;
            list.add(node.data);
        }
        if(node!=null && node.right!=null)
        rightViewUtil(node.right,level+1);
        if(node!=null && node.left!=null)
        rightViewUtil(node.left,level+1);
    }
}*/
}
