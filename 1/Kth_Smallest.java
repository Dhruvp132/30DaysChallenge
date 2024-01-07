class Solution {
    public static String trimFromBack(String originalString, int n) {
        if (originalString == null || n <= 0) {
            return originalString;
        }

        int length = originalString.length();
        int startIndex = Math.max(0, length - n);

        return originalString.substring(startIndex);
    }

    public static int findKthSmallest(String[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Shuffle the array to ensure average-case linear time complexity
        shuffle(nums);

        // Perform QuickSelect to find the kth smallest element
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k - 1) {
                return pivotIndex;
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        throw new IllegalStateException("Should not reach here");
    }

    private static void shuffle(String[] nums) {
        Random rand = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(nums, i, j);
        }
    }

    private static int partition(String[] nums, int low, int high) {
        String pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j].compareTo(pivot) <= 0) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int c = 0;

        for (int i = 0; i < queries.length; i++) {
            int trimLength = queries[i][1];

            // Trim each number in nums to its rightmost trimi digits.
            for (int j = 0; j < nums.length; j++) {
                nums[j] = trimFromBack(nums[j], trimLength);
            }

            // Find the kth smallest index in the trimmed array.
            int index = findKthSmallest(nums, queries[i][0]);

            // Reset each number in nums to its original length.
            for (int j = 0; j < nums.length; j++) {
                nums[j] = trimFromBack(nums[j], 0);
            }

            ans[c++] = index;
        }

    return ans;
    }
}