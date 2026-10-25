class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();

        for(String s :strs){
            char[] charArr=s.toCharArray();
            Arrays.sort(charArr);
            String res=new String(charArr);

            if(!map.containsKey(res)){
                map.put(res,new ArrayList<>());
            }

            map.get(res).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
