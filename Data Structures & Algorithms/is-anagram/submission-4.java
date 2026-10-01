class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> sCount= new HashMap<>();
        Map<Character, Integer> tCount= new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sCount.put(sChar, sCount.getOrDefault(sChar, 0)+1);
            tCount.put(tChar, tCount.getOrDefault(tChar, 0)+1);
        }
        return sCount.equals(tCount);
    }
}
