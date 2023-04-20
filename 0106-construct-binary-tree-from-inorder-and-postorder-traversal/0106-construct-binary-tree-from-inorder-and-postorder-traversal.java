/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    TreeNode func(int postEnd,int ins,int ine,int[] ino,int[] pos){
        if(postEnd<0 || ins > ine)
            return null;
        
        TreeNode root  = new TreeNode(pos[postEnd]);
        
        int idx = -1;
        for(int i=ins;i<=ine;i++){
            if(pos[postEnd]==ino[i]){
                idx = i;
                break;
            }
        }
        
        root.left  = func(postEnd-(ine-idx)-1,ins,idx-1,ino,pos);
        root.right = func(postEnd-1,idx+1,ine,ino,pos);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return func(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
}