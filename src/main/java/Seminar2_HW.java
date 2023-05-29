import java.util.Arrays;
public class Seminar2_HW {
    public static void main(String [] args){
        int[] array1 = new int[]{89, 5,2, 1, 89, 234, 23, 1, 65, 100};
        SortByHeapOne(array1);
        System.out.println(Arrays.toString(array1));
    }
    // Сщртировка кучей (пирамидальная):
    public  static void SortByHeapOne (int[]array) {
        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            SortByHeapTwo(array, array.length, i);
        }
        for (int i = array.length-1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            SortByHeapTwo(array, i, 0);
        }
    }
    private static void SortByHeapTwo (int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            SortByHeapTwo(array, heapSize, largest);
        }
    }

}
