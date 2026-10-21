class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        if(sorted.equals(s)) return 0;

        if(n==2 && !sorted.equals(s)) return -1;

        int smallest = chars[0];
        int biggest = chars[n-1];

        int countsmall = 0;
        int countbig = 0;

        for(int i =0;i<n;i++){
            if(s.charAt(i)==smallest) countsmall++;
            if(s.charAt(i)==biggest) countbig++;
        }

        if(s.charAt(0)==smallest || s.charAt(n-1)==biggest) return 1;

        if(s.charAt(0)==biggest && s.charAt(n-1)==smallest && countsmall==1 && countbig==1) return 3;

        return 2;
    }
}