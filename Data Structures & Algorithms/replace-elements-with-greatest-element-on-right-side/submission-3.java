class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int i = length-1;
        int max = arr[i];
        arr[i] = -1;
        i--;
        for(; i>=0; i--) {
            int num = arr[i];
            arr[i] = max;
            if (max < num) {
                max = num;
            }
        }
        return arr;
    }
}