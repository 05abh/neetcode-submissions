class Solution {
    public static boolean isAnagram(String s, String t) {
       HashMap<Character,Integer> Smap=new HashMap<>();
       HashMap<Character,Integer> Tmap=new HashMap<>();

       for(char c:s.toCharArray())
           Smap.put(c,Smap.getOrDefault(c,0)+1);

       for(char d:t.toCharArray())
           Tmap.put(d,Tmap.getOrDefault(d,0)+1);

       if(Smap.equals(Tmap))
           return true;
       else
           return false;
    }
}
