//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] a, int n) 
    {
         Stack<Integer> st = new Stack<>();
        int[] mp = new int[n+1];
        Arrays.fill(mp,Integer.MIN_VALUE);

        for(int i=0;i<n;i++){
            int curr = a[i];

            while(!st.isEmpty() && curr<a[st.peek()]){
                int currIdx = i;
                int pp = a[st.peek()];
                st.pop();
                int lastidx = (st.isEmpty()?-1:st.peek());
                int len = currIdx - lastidx -1;
                mp[len] = Math.max(mp[len],pp);
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int currIdx = n;
            int pp = a[st.peek()];
            st.pop();
            int lastidx = (st.isEmpty()?-1:st.peek());
            int len = currIdx - lastidx -1;
            mp[len] = Math.max(mp[len],pp);
        }

       

        int[] res = new int[n];
        res[n-1]=mp[n];

        for(int i=n-2;i>=0;i--){
            int len = mp[i+1];
            res[i]=Math.max(len,res[i+1]);
        }

        return res;
    }
}