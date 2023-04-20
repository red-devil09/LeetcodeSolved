class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        while(arr[i]==' ')
            i++;
        int j = arr.length-1;
        while(arr[j]==' ')
            j--;
        
        String str = "";
        String word = "";
        while(i<=j){
            if(arr[i]!=' '){
                word+=arr[i];
                i++;
            }else{
                
                if(arr[i-1]==' '){
                    i++;
                    continue;
                }
                str = " " + word + str;
                i++;
                word = "";
            }
        }
        str = word + str;
        return str;
        
    }
}