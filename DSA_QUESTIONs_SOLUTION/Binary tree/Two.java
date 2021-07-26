public class Two {
    
    /* Height of a Binary tree
    code:
    class Solution {
     int maxLevel = 0;
    int height(Node node) {
       
        heightUtil(node,1);
        return maxLevel;
    }
    void heightUtil(Node node ,int level){
        
        if(maxLevel < level){
            maxLevel = level;
        }
        if(node.left!=null)
        heightUtil(node.left,level+1);
        if(node.right!=null)
        heightUtil(node.right,level+1);
    }
} */
}
