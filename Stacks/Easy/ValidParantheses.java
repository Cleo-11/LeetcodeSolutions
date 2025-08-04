//Valid Parantheses
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

//An input string is valid if:

//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
 
//Example 1:

//Input: s = "()[]{}"

//Output: true

//Example 2:

//Input: s = "(]"

//Output: false



class Solution {
    public boolean isValid(String s) {
        Stack<Character> ValidPar = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                ValidPar.push(ch);
            }else{
                if(ValidPar.isEmpty()) return false; 

                   char top = ValidPar.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
            }
        }
    }
    return ValidPar.isEmpty();
}
}