/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null||intervals.isEmpty()){
            return 0;
        }

        TreeMap<Integer,Integer> event=new TreeMap<>();
        for(Interval line:intervals){
            event.merge(line.start,1,Integer::sum);
            event.merge(line.end,-1,Integer::sum);
        }

        int curr=0,best=0;
        for(int d:event.values()){
            curr+=d;
            best=Math.max(best,curr);
        }
        return best;    }
}
