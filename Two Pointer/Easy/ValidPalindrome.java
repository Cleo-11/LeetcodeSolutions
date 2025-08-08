// //Valid Palindrome
// Given a string s, return true if it is a palindrome, otherwise return false.

// A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

// Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

// Example 1:

// Input: s = "Was it a car or a cat I saw?"

// Output: true
// Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.

// Example 2:

// Input: s = "tab a cat"

// Output: false
// Explanation: "tabacat" is not a palindrome.


class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while(left < right){
            while(left < right && !isAlphaNumeric(chars[left])){
                left++;
            }

            while(left < right && !isAlphaNumeric(chars[right])){
                right--;
            }

            if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])){
                return false;
            }
            left++;
            right--;
        } 
        return true;
        
    }

    private boolean isAlphaNumeric(char c){
        return(c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') || 
            (c >= '0' && c <='9');

    }
}
