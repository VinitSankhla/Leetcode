class Solution {
    public boolean checkString(String s) {
        int a = 0, b = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length; i++){
            if(chars[i]=='a' && b==0)a++;
            else if(chars[i]=='a') return false;
            else b++;
        }
        return true;
    }
}