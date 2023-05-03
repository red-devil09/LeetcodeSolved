class Solution {

    public int minCostConnectPoints(int[][] arr) {
        int n = arr.length;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        int[] vis = new int[n];
        Arrays.fill(vis,0);

        dist[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));

        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();

            int idx = temp[0];
            vis[idx]=1;
            //jo bhi PQ se pop ho gya, mtlb uska final dist set ho chuka hai, usme koi change nhi ayega hence mark it visited
            //we don't need vis in Dijsktra kyuki vaha pr vaise vaise hi path ka distance Source se measure krte hai, lekin yaha aisa nhi hai, isliye suppose 0-1 ka 14 weight aaya
            //1-2 ka 2 wt aaya, to enxt time 2-1 ka wieght 2 set ho jaega btao, 0-1 ka link hi khtm , bina visited array ke

            for(int i=0;i<n;i++){
                int dis = Math.abs(arr[idx][0]-arr[i][0]) + Math.abs(arr[idx][1] - arr[i][1] ); 

                 if(vis[i]==0 && dist[i]>dis){

                     dist[i]=dis;
                     pq.offer(new int[]{i,dis});
                 }
            }
        }
        
        int sum=0;
        for(var i:dist){
          sum+=i;
        }

        return sum;
        
    }
}