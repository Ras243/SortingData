package flowgorithm;
import java.util.*;

public class random_Quick {
    private static Random random = new Random();

    public static void main(String[] args) {
        int n, i;
        
        n = 5;
        int[] data = new int[n];
        
        data[0] = 40;
        data[1] = 2;
        data[2] = 1;
        data[3] = 43;
        data[4] = 3;
        
        // Cetak Array Data
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print("  " + data[i]);
        }
        System.out.println("  ]");
        
        // Memulai Quick Sort
        quickSort(data, 0, n - 1);
        
        // Cetak Hasil Sorting
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print("  " + data[i]);
        }
        System.out.println("  ]");
    }
    
    public static int partisi(int[] data, int low, int high) {
        int indexPartisi;
        int pivot, i, j, temp, indexPivot, interval;
        
        interval = high - low;
        indexPivot = low + random.nextInt(interval);
        pivot = data[indexPivot];

        // set nilai pivot tetap diposisi high untuk memudahkan iterasi :)
        temp = data[indexPivot];
        data[indexPivot] = data[high];
        data[high] = temp;
        
        // memulai partisi Array
        i = low - 1;
        for (j = low; j <= high - 1; j++) {
            if (data[j] < pivot) {
                i = i + 1;
                
                // tukar data pada index i dan j
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        
        // tukar data pada index i+1 dan high
        temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        indexPartisi = 1 + i;
        
        return indexPartisi;
    }
    
    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int indexPartisi;
            
            indexPartisi = partisi(data, low, high);
            quickSort(data, low, indexPartisi - 1);
            quickSort(data, indexPartisi + 1, high);
        }
    }
}
