package flowgorithm;
import java.util.*;

public class Sorting_ArrayList {
    
    // method isi data
    static ArrayList<Double> inisialisasiArrayList(){
        ArrayList<Double> arrList = new ArrayList<>();
        arrList.add(3.1);
        arrList.add(1.7);
        arrList.add(5.2);
        arrList.add(7.6);
        arrList.add(4.5);
        arrList.add(2.8);
        // Scanner input = new Scanner(System.in);
        // System.out.print("Masukkan banyaknya data : ");
        // int n = input.nextInt();
        // for (int k = 0; k <= n-1; k++) {
        //     Double nilai = input.nextDouble();
        //     arrList.add(nilai);
        // }
        return arrList;
    }
    // method cetak
    static void cetak(ArrayList<Double> arrList){
        System.out.print("[");
        // for (Double value : arrList) {
        //     System.out.print(" "+value);
        // }
        for(int i=0; i<arrList.size();i++){
            System.out.print(" "+arrList.get(i));
        }
        System.out.println(" ]");
    }
    // method kloning
    static ArrayList<Double> kloning(ArrayList<Double> arrList){
        ArrayList<Double> arrlistNew =null;
        if (arrList != null) {
            arrlistNew =new ArrayList<>();
            for (Double value1 : arrList) {
                arrlistNew.add(value1);
                
            }
        }
        return arrlistNew;
    }
    // method Sorting
    static void tukarNilai(ArrayList<Double> arrList, int indexA, int indexB){
        if(indexA >= 0 && indexA < arrList.size() && indexB >= 0 && indexB < arrList.size() && indexA != indexB){
            Double A, B, C;
            A = arrList.get(indexA);
            B = arrList.get(indexB);
            C = A;
            A = B;
            B = C;
            arrList.set(indexA, A);
            arrList.set(indexB, B);
        }
    }
    // Algoritma Bubble Sort
    static void bubbleSort(ArrayList<Double> arrList){
        int n = arrList.size();
        boolean adaPertukaran = true;
        do {
            adaPertukaran = false;
            for(int i=1;i<n;i++){
                if(arrList.get(i-1)>arrList.get(i)){
                    tukarNilai(arrList, (i-1), i);
                    adaPertukaran = true;
                }
            }
            n--;

        } while (adaPertukaran);
    }
    // Algoritma Selection Sort
    static void selectionSort(ArrayList<Double> arrList){
        int n = arrList.size();
        for(int i=0;i<n-1;i++){
            int jMin = i;
            for(int j=i+1;j<n;j++){
                if(arrList.get(j)<arrList.get(jMin)){
                    jMin = j;
                }
            }
            if(jMin != i){
                tukarNilai(arrList, i, jMin);
            }
        }
    }
    // Algoritma Insertion Sort
    static void insertionSort(ArrayList<Double> arrList){
        int n = arrList.size();
        int i = 1;
        int j;
        while(i<n){
            Double temp = arrList.get(i);
            for(j=i;j>0;j--){
                if(temp<arrList.get(j-1)){
                    arrList.set(j, arrList.get(j-1));
                }else{
                    break;
                }
            }
            arrList.set(j, temp);
            i++;
        }
    }
    // Algoritma Merge Sort
    static void mergeSort(ArrayList<Double> arrList){
        int n = arrList.size();
        if(n<2){
            return;
        }
        
        int tengah = n/2;
        
        ArrayList<Double> arrListKiri = new ArrayList<>();
        for(int i=0;i<tengah;i++){
            arrListKiri.add(arrList.get(i));
        }
        
        ArrayList<Double> arrListKanan = new ArrayList<>();
        for(int i=tengah;i<n;i++){
            arrListKanan.add(arrList.get(i));
        }
        
        mergeSort(arrListKiri);
        mergeSort(arrListKanan);
        
        merge(arrList, arrListKiri, arrListKanan);        
    }
    
    static void merge(ArrayList<Double> arrList, ArrayList<Double> arrListKiri, ArrayList<Double> arrListKanan){
        int i=0, j=0, k=0;
        int sKiri = arrListKiri.size();
        int sKanan = arrListKanan.size();
        
        while(i<sKiri && j<sKanan){
            if(arrListKiri.get(i)<arrListKanan.get(j)){
                arrList.set(k++, arrListKiri.get(i++));
            }else{
                arrList.set(k++, arrListKanan.get(j++));
            }
        }
        while(i<sKiri){
            arrList.set(k++, arrListKiri.get(i++));
        }
        while(j<sKanan){
             arrList.set(k++, arrListKanan.get(j++));
        }
    }
    // Algoritma Quick Sort
    static int partisi(ArrayList<Double> arrList, int low, int high){
        Double pivot = arrList.get(high);
        int i = low -1;
        for(int j=low;j<high;j++){
            if(arrList.get(j)<pivot){
                i++;
                tukarNilai(arrList, i, j);
            }
        }
        tukarNilai(arrList, i+1, high);
        return i+1;
    }
    
    static void quickSort(ArrayList<Double> arrList, int low, int high){
        if(low<high){
            int indexPartisi = partisi(arrList, low, high);
            quickSort(arrList, low, indexPartisi-1);
            quickSort(arrList, indexPartisi+1, high);
        }
    }
    // Algoritma Random Quick Sort
    
    

    public static void main(String[] args) {
        ArrayList<Double> data = inisialisasiArrayList();
        System.out.print("Original Data: ");
        cetak(data);
        
        // pembuktian menggunakan kloning
        // ArrayList<Double> data1 = kloning(data);
        // data.set(0, 2.5);
        // System.out.print("Original Data1: ");
        // cetak(data);
        // System.out.print("Original Data2: ");
        // cetak(data1);
        
        // data1.set(2, 1.1);
        // System.out.print("Original Data1: ");
        // cetak(data);
        // System.out.print("Original Data2: ");
        // cetak(data1);
        
        // System.out.print("BEFORE TUKAR  : ");
        // cetak(data);
        // tukarNilai(data, 2, 4);
        // System.out.print("AFTER TUKAR   : ");
        // cetak(data);

        ArrayList<Double> data1 = kloning(data);
        System.out.print("Bubble Sort   : ");
        bubbleSort(data1);
        cetak(data1);

        ArrayList<Double> data2 = kloning(data);
        System.out.print("Selection Sort: ");
        selectionSort(data2);
        cetak(data2);

        ArrayList<Double> data3 = kloning(data);
        System.out.print("Selection Sort: ");
        insertionSort(data3);
        cetak(data3);
        
        ArrayList<Double> data4 = kloning(data);
        System.out.print("Merge Sort    : ");
        mergeSort(data4);
        cetak(data4);
        
        ArrayList<Double> data5 = kloning(data);
        System.out.print("Quick Sort    : ");
        quickSort(data5, 0, data5.size()-1);
        cetak(data5);
    }
}
