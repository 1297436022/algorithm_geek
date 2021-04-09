package chapter16;

class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {5, 8, 1, 9, 6, 2, 4, 7};
        ms.mergeSort(arr, 0, 7);
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
    
    //O(nlogn)
    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1; //(left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }     

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; //中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; ++p) {
            arr[left + p] = temp[p];
        }
        //System.arraycopy(a, start1, b, start2, length);
    }
}