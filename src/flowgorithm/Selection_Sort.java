package flowgorithm;
import java.util.*;

public class Selection_Sort {
    
    private static Scanner input = new Scanner(System.in);
    
        public static void main(String[] args) {
            int size, i, j;
            
            size = input.nextInt();
            int[] a = new int[size];
            
            for (i = 0; i <= size - 1; i++) {
                a[i] = input.nextInt();
            }
            
            // memulai sorting menggunakan algoritma selection sort
            for (i = 0; i <= size - 2; i++) {
                int jMIN;
                
                jMIN = i;
                for (j = 1 + i; j <= size - 1; j++) {
                    if (a[j] < a[jMIN]) {
                        jMIN = j;
                    }
                }
                if (jMIN != i) {
                    
                    // swap
                    int temp;
                    
                    temp = a[i];
                    a[i] = a[jMIN];
                    a[jMIN] = temp;
                }
            }
            
            // cetak hasil sorting algoritma selection sort
            for (i = 0; i <= size - 1; i++) {
                System.out.print(Integer.toString(a[i]) + " ");
            }
        }
    }
    