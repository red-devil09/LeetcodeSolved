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

class Cord{
    int col;
    int row;
    int hash;

    Cord(int col,int row){
        this.col = col;
        this.row = row;
        this.hash = (row*104729%1000000007 + col*224737%1000000007)%1000000007;
    }

    // public boolean equals(Object obj){
    //     Cord nobj = (Cord)obj;
    //     return (this.hash == nobj.hash);
    // }

    // public int hashCode(){
    //    return this.hash;
    // }

    
}


class Pair{
    TreeNode root;
    int w;

    Pair(int w,TreeNode root){
        this.root = root;
        this.w = w;
    }
} 
class Solution {
    TreeMap<Cord,List<Integer>> mp = new TreeMap<>((a,b) -> {
        if(a.col<b.col)
        return -1;
        else if(a.col == b.col){
            if(a.row<b.row)
            return -1;
            //sara game iska tha, equality ka
            else if(a.row == b.row)
            return 0;
            else
            return 1;
        }else
        return 1;
    });

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));

        int row = -1;

        while(!q.isEmpty()){
            int sz = q.size();
            row++;
            while(sz-- > 0){
                
                
                Pair temp = q.poll();
                int width = temp.w;
                TreeNode Troot = temp.root;

                Cord c = new Cord(width,row);

                if(!mp.containsKey(c)){
                    mp.put(c,new ArrayList<>());
                }

                List<Integer> lis = mp.get(c);
                lis.add(Troot.val);
                Collections.sort(lis);
                mp.put(c,lis);

               //as apne ko sorted to chahiye lekin duplicates bhi hai to set nhi kaam dega
               //list ko hi sort krlo baar baar
               // mp.computeIfAbsent(c,a -> new TreeSet<>()).add(Troot.val);

                if(Troot.right!=null){
                    q.add(new Pair(width+1,Troot.right));
                }

                if(Troot.left!=null){
                    q.add(new Pair(width-1,Troot.left));
                }

                
            }
        }
        
        Map<Integer,List<Integer>> resm = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(var e:mp.entrySet())
        {
            Cord c = (Cord)e.getKey();
            resm.computeIfAbsent(c.col,a -> new ArrayList<>()).addAll(e.getValue());
        }

        for(var i:resm.values())
        res.add(new ArrayList<>(i));

        return res;
    }
}