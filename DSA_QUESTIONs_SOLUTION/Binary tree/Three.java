public class Three {
    
    /* Mirror of a node 
    
    actual code 
    class Solution
{
    //Function to convert a binary tree into its mirror tree.
    void mirror(Node node)
    {
        Node x =mirrorUtil(node);
    }
    public Node mirrorUtil(Node node){
        if(node==null) return node;
        else{
            Node left = mirrorUtil(node.left);
            Node right = mirrorUtil(node.right);
            node.left = right;
            node.right = left;
            return node;
        }
    }
}*/
}
