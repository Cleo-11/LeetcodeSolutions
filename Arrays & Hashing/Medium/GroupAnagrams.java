// Group Anagrams
//Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

//Example 1:
//Input: strs = ["act","pots","tops","cat","stop","hat"]
//Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
//Example 2:
//Input: strs = ["x"]
//Output: [["x"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key,newList);
            }else{
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
