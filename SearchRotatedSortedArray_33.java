class RotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length < 1)
            return -1;
        int pivot = findPivot(nums);
        if(nums[pivot] == target) {
            return pivot;
        }
        if(pivot == 0 || target < nums[0]) {
            return binSearch(nums, pivot+1, nums.length-1, target);
        }
        return binSearch(nums, 0, pivot-1, target);
    }
    
    private int binSearch(int[] nums,int begin,int end,int target) {
        while(begin <= end) {
            int mid = begin + (end - begin)/2;
            if(nums[mid] < target) {
                begin = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid == 0 || nums[mid] < nums[mid - 1]) {
                return mid;
            } 
            if(nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }            
        }
        return 0;
    }

    public static void main(String[] args) {
        RotatedSortedArray rsa = new RotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int res = rsa.search(nums, 0);
        System.out.println(res);
    }
}