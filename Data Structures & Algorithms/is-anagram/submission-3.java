class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Map<Character, Integer> sCount= new HashMap<>();
        Map<Character, Integer> tCount= new HashMap<>();
        for(int i=0; i<sArray.length; i++) {
            sCount.put(sArray[i], sCount.getOrDefault(sArray[i], 0)+1);
            tCount.put(tArray[i], tCount.getOrDefault(tArray[i], 0)+1);
        }
        return sCount.equals(tCount);
    }
}
