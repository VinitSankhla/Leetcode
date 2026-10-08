class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if(c=='(' && count==0){
                count++;
            }
            else if(c=='(' && count!=0){
                sb.append('(');
                count++;
            }
            else if(c==')' && count==1){
                count--;
            }
            else {
                sb.append(')');
                count--;
            }
        }
        return sb.toString();
    }
}