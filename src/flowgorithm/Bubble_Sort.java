package flowgorithm;
import java.util.*;

public class Bubble_Sort {
    
        private static Scanner input = new Scanner(System.in);
    
        public static void main(String[] args) {
            int n, i, j;
            
            n = input.nextInt();
            int[] arr = new int[n];
            
            for (i = 0; i <= n - 1; i++) {
                arr[i] = input.nextInt();
            }
            
            // memulai pengurutan data menggunakan algoritma bubble sort
            for (i = 0; i <= n - 2; i++) {
                for (j = 0; j <= n - i - 2; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp;
                        
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            
            // cetak elemen-elemen array
            System.out.print(" | ");
            for (i = 0; i <= n - 1; i++) {
                System.out.print(Integer.toString(arr[i]) + " | ");
            }
            System.out.println("");
        }
    }
    