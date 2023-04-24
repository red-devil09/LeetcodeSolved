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
   
    TreeNode func(int st,int en,int[] nums){
        if(st>en)
        return null;

        if(st==en)
        return new TreeNode(nums[st]);

        int mid = (st+en)>>>1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = func(st,mid-1,nums);
        root.right = func(mid+1,en,nums);

        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return func(0,nums.length-1,nums);
    }
}