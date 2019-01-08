class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n-1, n - k + 1);
        return nums[p];
    }

    //return the index of the kth smallest number
    private int quickSelect(int[] a, int low, int high,int k) {
        //using quick sort
        //put nums that are <= pivot to the left
        //put nums that are > pivot to the right
        int i = low, j = high, pivot = a[high];
        while(i < j) {
            if(a[i++] > pivot)
                swap(a, --i, --j);
        }
        swap(a, i, high);

        //count the nums that are <= pivot from low
        int m = i - low + 1;
        if(m == k)
            return i;
        //pivot is too big
        else if(m > k)
            return quickSelect(a, low, i-1, k);
        else
            return quickSelect(a, i+1, high, k - m);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}