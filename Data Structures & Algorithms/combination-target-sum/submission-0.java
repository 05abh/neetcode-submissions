class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backTrack(nums,0,target,new ArrayList(),res);
        return res;
    }
    public void backTrack(int[] nums,int idx,int target, List<Integer> list,List<List<Integer>> res){
        if(target<0){
            return ;
        }
        if(target==0){
            res.add(new ArrayList(list));
        }
            for(int i=idx;i<nums.length;i++){
                list.add(nums[i]);
                backTrack(nums,i,target-nums[i],list,res);
                list.remove(list.size()-1);
            
        }
    }
}
