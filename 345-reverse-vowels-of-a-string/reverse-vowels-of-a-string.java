class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        String vow = "aeiouAEIOU";
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(vow.indexOf(arr[i]) == -1){i++;}
            else if(vow.indexOf(arr[j]) == -1){j--;}
            else{
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    public static void swap(char [] arr, int i , int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp; 
    }
}