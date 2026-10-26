class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int res=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(set.contains(num-1))
            continue;
            int streak=0;
            int curr=num;
            while(set.contains(curr)){
                streak++;
                curr++;
            }
            res=Math.max(res,streak);
        }
        return res;
    }
}
