class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m+n-1; i>=0; i--) {
            if (i>=n) {
                nums1[i] = nums1[i-n];
            } else {
                nums1[i] = 0;
            }
        }
        int p1 = n;
        int p2 = 0;
        for(int i=0; i<m+n; i++) {
            if (nums2.length == p2 || (p1 < nums1.length && nums1[p1] <= nums2[p2])) {
                nums1[i] = nums1[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
    }
}