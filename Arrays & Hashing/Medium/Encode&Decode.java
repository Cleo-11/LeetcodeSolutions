//Encode and Decode Strings
//Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
//Please implement encode and decode

//Example 1:
//Input: ["neet","code","love","you"]
//Output:["neet","code","love","you"]

//Example 2:
//Input: ["we","say",":","yes"]
//Output: ["we","say",":","yes"]

//Constraints:
//0 <= strs.length < 100
//0 <= strs[i].length < 200
//strs[i] contains only UTF-8 characters.

class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder(); 
        for(String s : strs){
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            result.add(str.substring(i,i+length));
            i += length;
        }
        return result;
    }
}



// Manual Implementation
class Solution {

    // Encode: Converts array of strings into a single string
    public String encode(String[] strs) {
        String encoded = "";
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int len = s.length();
            encoded += intToString(len) + "#" + s;
        }
        return encoded;
    }

    // Decode: Converts a single string back into array of strings
    public String[] decode(String str) {
        String[] temp = new String[100]; // You can use a large enough size
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = stringToInt(str.substring(i, j));
            i = j + 1;
            String word = str.substring(i, i + length);
            temp[count++] = word;
            i += length;
        }

        // Copy only valid part to result array
        String[] result = new String[count];
        for (int k = 0; k < count; k++) {
            result[k] = temp[k];
        }
        return result;
    }

    // Convert integer to string manually
    private String intToString(int num) {
        if (num == 0) return "0";
        String res = "";
        while (num > 0) {
            int digit = num % 10;
            res = (char)('0' + digit) + res;
            num /= 10;
        }
        return res;
    }

    // Convert string to integer manually
    private int stringToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }
}
