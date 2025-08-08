// Container With Most Water
// You are given an integer array heights where heights[i] represents the height of the ith bar.

// You may choose any two bars to form a container. Return the maximum amount of water a container can store.

// Example 1:

// Input: height = [1,7,2,5,4,7,3,6]

// Output: 36

class Solution {
    public int maxArea(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int maxArea = 0; 

        while(left < right){
            int width = right - left;
            int h = Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, width * h);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        } 
        return maxArea;
    }
}