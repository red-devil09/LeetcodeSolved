class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b) ->{
            if(a[0]<b[0])
                return -1;
            else if(a[0]==b[0]){
                if(a[1]<b[1])
                    return 1;
                else
                    return -1;
            }
            else return 1;
        });
        
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0][1]);
        
        
        for(int i=1;i<arr.length;i++){
             int s = 0;
            int e = lis.size()-1;
            
            while(s<e){
                int mid = (s+e)>>>1;
                
                if(lis.get(mid)<arr[i][1]){
                    s = mid+1;
                }else
                    e = mid;
            }
            
            if(lis.get(e)<arr[i][1])
                lis.add(arr[i][1]);
            else{
                lis.set(e,arr[i][1]);
            }
            
         
        }
        
        return lis.size();
        
    }
}