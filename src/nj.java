import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element in nums
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the elements based on their frequencies
        List<Integer> elements = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(elements,(a,b)->
        {
            int compare=frequencyMap.get(a).compareTo(frequencyMap.get(b));
            if(compare!=0)
            {
                return compare;
            }
            else {
                return a.compareTo(b);
            }
        });
        System.out.println(elements);

        // Step 3: Construct the result array
        int[] result = new int[nums.length];
        int index = 0;
        for (int element : elements) {
            int frequency = frequencyMap.get(element);
            for (int i = 0; i < frequency; i++) {
                result[index++] = element;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] sortedNums = solution.frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums)); // Output: [3, 1, 1, 2, 2, 2]

        nums = new int[]{2, 3, 1, 3, 2};
        sortedNums = solution.frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums)); // Output: [1, 3, 3, 2, 2]

        nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        sortedNums = solution.frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums)); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
