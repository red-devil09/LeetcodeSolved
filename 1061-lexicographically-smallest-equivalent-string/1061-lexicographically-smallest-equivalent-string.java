class UnionFind{
    int[] parent;
    
    UnionFind(){
        parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
    }
    
    int findParent(int x){
        if(x==parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
    
    boolean union(int a,int b){
        a = findParent(a);
        b = findParent(b);
        
        if(a==b)
            return false;
        else{
            if(a<b)
                parent[b] = a;
            else
                parent[a] =b;
            
            return true;
        }
    }
}


class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        UnionFind uf = new UnionFind();
        
        
        for(int i=0;i<s1.length();i++){
            int x = s1.charAt(i)-'a';
            int y = s2.charAt(i)-'a';
            
            uf.union(x,y);
        }
        
        String ans = "";
        
        for(int i=0;i<baseStr.length();i++){
            int a = baseStr.charAt(i)-'a';
            int b= uf.findParent(a);
            char ch =(char)(b+'a');
            ans+=ch+"";
        }
        
        return ans;
        
        
    }
}