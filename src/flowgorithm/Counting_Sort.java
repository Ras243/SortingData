package flowgorithm;

public class Counting_Sort {
    public static void main(String[] args) {
        int n, i, j;
        
        n = 12;
        int[] data = new int[n];
        
        data[0] = 40;
        data[1] = 2;
        data[2] = 1;
        data[3] = 43;
        data[4] = 3;
        data[5] = 65;
        data[6] = 0;
        data[7] = (int) (-1);
        data[8] = 68;
        data[9] = 3;
        data[10] = 42;
        data[11] = 4;
        
        // Cetak Array Data
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print("  " + data[i]);
        }
        System.out.println("  ]");
        
        // Memulai Counting Sort
        // 1. cari nilai MIN dan MAX
        int mIN, mAX;
        
        mIN = 99999;
        mAX = (int) (-99999);
        for (i = 0; i <= n - 1; i++) {
            if (data[i] > mAX) {
                mAX = data[i];
            }
            if (data[i] < mIN) {
                mIN = data[i];
            }
        }
        
        // buat array arrCount berukuran (MAX-MIN)+1
        int nCount;
        
        nCount = mAX - mIN + 1;
        int[] arrCount = new int[nCount];
        
        // inisialisasi array arrCount
        for (i = 0; i <= nCount - 1; i++) {
            arrCount[i] = 0;
        }
        
        // melakukan counting
        for (i = 0; i <= n - 1; i++) {
            int value;
            
            value = data[i];
            j = value - mIN;
            arrCount[j] = arrCount[j] + 1;
        }
        
        // meletakkan hasil counting ke array hasil sorting
        int k;
        
        k = 0;
        for (i = 0; i <= nCount - 1; i++) {
            if (arrCount[i] > 0) {
                int nK;
                
                nK = arrCount[i];
                int value;
                
                value = mIN + i;
                for (j = 1; j <= nK; j++) {
                    data[k] = value;
                    k = k + 1;
                }
            }
        }
        
        // Cetak Hasil Sorting
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print("  " + data[i]);
        }
        System.out.println("  ]");
    }
}
