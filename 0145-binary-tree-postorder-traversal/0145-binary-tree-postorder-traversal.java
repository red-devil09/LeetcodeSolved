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
    List<Integer> res = new ArrayList<>();
    
    void func(TreeNode root){
        if(root==null)
            return;
        
        func(root.left);
        func(root.right);
        res.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        func(root);
        return res;
    }
}