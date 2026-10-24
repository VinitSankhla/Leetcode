class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] cumulative = new int[13];
        cumulative[1]=31;//january index 1 feb index 2 ...
        for(int i = 2; i <= 12; i++){
            cumulative[i]=cumulative[i-1]+monthDays[i-1];
        }

        int StartAlice = findDayOfYear(arriveAlice, cumulative);
        int EndAlice = findDayOfYear(leaveAlice, cumulative);
        int StartBob = findDayOfYear(arriveBob, cumulative);
        int EndBob = findDayOfYear(leaveBob, cumulative);

        int overlap = Math.min(EndAlice,EndBob)-Math.max(StartAlice,StartBob)+1;

        return overlap < 0 ? 0 : overlap;
    }
    public int findDayOfYear(String date, int[] cumulative){
        int month = Integer.parseInt(date.substring(0,2)); // MM
        int day = Integer.parseInt(date.substring(3,5)); // DD
        return cumulative[month-1] + day;
    }
}