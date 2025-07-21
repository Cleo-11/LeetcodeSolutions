//Valid Anagram
//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

//Example 1:
//Input: s = "racecar", t = "carrace"
//Output: true
//Example 2:
//Input: s = "jar", t = "jam"
//Output: false


class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();
        if(s1 != s2){
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}
