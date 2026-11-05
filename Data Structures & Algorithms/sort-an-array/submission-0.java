class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergesort(int [] arr, int i, int j) {
        if(i >= j) return;
        int mid = (i + j) / 2;
        mergesort(arr, i, mid);
        mergesort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private void merge(int[] arr, int i, int mid, int j) {
        List<Integer> ls = new ArrayList<>();
        int l = i, r = mid + 1;
        while(l <= mid && r <= j) {
            if(arr[l] <= arr[r]) {
                ls.add(arr[l]);
                l++;
            } else {
                ls.add(arr[r]);
                r++;
            }
        }

        while(l <= mid) {
            ls.add(arr[l]);
            l++;
        }

        while(r <= j) {
            ls.add(arr[r]);
            r++;
        }

        for(int k = i; k <= j; k++) {
            arr[k] = ls.get(k - i);
        }
    }
}