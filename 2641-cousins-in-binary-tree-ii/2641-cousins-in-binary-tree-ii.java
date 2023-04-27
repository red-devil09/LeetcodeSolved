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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();
            List<TreeNode> l = new ArrayList<>();
            int tsum = 0 ;
            while(sz-- > 0){

                TreeNode temp = q.poll();

                if(temp.left!=null){
                    tsum+=temp.left.val;
                    q.offer(temp.left);
                }

                if(temp.right!=null){
                    tsum+=temp.right.val;
                    q.offer(temp.right);
                }

                l.add(temp);

            }

            for(var node : l){
                int sum =0;
                if(node.left!=null)
                sum+=node.left.val;

                if(node.right!=null)
                sum+=node.right.val;

                if(node.left!=null){
                    node.left.val = tsum-sum;
                }
                if(node.right!=null){
                    node.right.val = tsum-sum;
                }
            }
        }

        root.val= 0;
        return root;
        
    }
}