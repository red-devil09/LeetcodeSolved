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
        
        res.add(root.val);
        func(root.left);
        func(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        func(root);
        return res;
    }
}