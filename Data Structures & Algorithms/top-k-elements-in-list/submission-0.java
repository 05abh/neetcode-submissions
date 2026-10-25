class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        
        List<Integer> unique=new ArrayList<>(map.keySet());

        unique.sort((a,b)->map.get(b)-map.get(a));

        int[] result =new int[k];
        for(int i=0;i<k;i++){
            result[i]=unique.get(i);
        }
        return result;
    }
}
