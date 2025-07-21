//Top K Frequent Elements
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//Example 1:
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//Input: nums = [1], k = 1
//Output: [1]


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map to 2D array: [num, frequency]
        int size = frequencyMap.size();
        int[][] freqArray = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            freqArray[index][0] = entry.getKey();   // number
            freqArray[index][1] = entry.getValue(); // frequency
            index++;
        }

        // Step 3: Sort using quicksort in descending order of frequency
        quickSort(freqArray, 0, size - 1);

        // Step 4: Extract top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqArray[i][0]; // top k elements by frequency
        }

        return result;
    }

    private void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[][] arr, int low, int high) {
        int pivotFreq = arr[high][1];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j][1] >= pivotFreq) { 
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[][] arr, int i, int j) {
        int tempNum = arr[i][0];
        int tempFreq = arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = tempNum;
        arr[j][1] = tempFreq;
    }
}

