package chapter16;

class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 9, 6, 2, 4, 7};
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, 7);
        for (int i = 0; i < 8; ++i)
            System.out.println(arr[i]);
    }
    
    //O(nlogn)
    public void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        //pivot:标杆位置, counter:小于pivot的元素的个数
        //有点快慢指针的思想
        int pivot = end, counter = begin;
        for (int i = begin; i < end; ++i) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}