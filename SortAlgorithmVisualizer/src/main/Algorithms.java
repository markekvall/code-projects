package main;

public class Algorithms {

    //==========================================================

    public void bubbleSort(SortAlgorithmVisualizer simulation, int[] array) {
        for(int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
            simulation.render();
            sleep();
        }
    }

    //===========================================================

    public void insertSort(SortAlgorithmVisualizer simulation, int[] array) {
        for(int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
            simulation.render();
            sleep();
        }
    }

    //==========Merge sort==================================

    void mergeTheMergeSort(int array[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(SortAlgorithmVisualizer simulation, int array[], int l, int r) {
        if (l < r) {

            int m =l+ (r-l)/2;

            mergeSort(simulation, array, l, m);
            mergeSort(simulation, array, m + 1, r);

            mergeTheMergeSort(array, l, m, r);
            simulation.render();
            sleep();

        }
    }

    //============================================================================

    //future sort algorithms to add

    //quick sort    <-- this one after merge sort

    //heap sort

    //radix sort

    //shell sort

    public void sleep() {
        try{
            Thread.sleep(30);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
