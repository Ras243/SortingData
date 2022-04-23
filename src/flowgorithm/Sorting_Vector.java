package flowgorithm;
import java.util.Vector;

public class Sorting_Vector {
    
    static Vector<Integer> inisialisasiVector(){
        Vector<Integer> vector = new Vector<>();
        vector.add(40);
        vector.add(2);
        vector.add(1);
        vector.add(43);
        vector.add(3);
        vector.add(65);
        vector.add(0);
        vector.add(-1);
        vector.add(68);
        vector.add(3);
        vector.add(42);
        vector.add(4);
        return vector;
    }
    
    static void cetak(Vector<Integer> vector){
         System.out.print("[");
        for(int i=0;i<vector.size();i++){
            System.out.print(" "+vector.get(i));
        }
        System.out.println(" ]");
    }
    
    static Vector<Integer> kloning(Vector<Integer> vector){
        Vector<Integer> vectorBaru = null;
        if(vector!=null){
            vectorBaru = new Vector<>();
            for(int v:vector){
                vectorBaru.add(v);
            }
        }
        return vectorBaru;
    }
    
    static void tukarNilai(Vector<Integer> vector, int indexA, int indexB){
        int A = vector.get(indexA);
        int B = vector.get(indexB);
        int C = A;
        A = B;
        B = C;
        vector.set(indexA, A);
        vector.set(indexB, B);
    }
    
    
    static void bubbleSort(Vector<Integer> vector){
        int n = vector.size();
        boolean adaPertukaran = true;
        while(adaPertukaran){
            adaPertukaran = false;
            for(int i=1;i<n;i++){
                if(vector.get(i-1)>vector.get(i)){
                    tukarNilai(vector, (i-1), i);
                    adaPertukaran = true;
                }
            }
            n--;
        }
    }
    
    static void selectionSort(Vector<Integer> vector){
        int n = vector.size();
        for(int i=0;i<n-1;i++){
            int iMAX = i;
            for(int j = i+1;j<n;j++){
                if(vector.get(iMAX)>vector.get(j)){
                    iMAX = j;                    
                }
            }
            if(iMAX != i){
                tukarNilai(vector, i, iMAX);
            }
        }
    }
    
    static void insertionSort(Vector<Integer> vector){
        int n = vector.size();
        int i = 1;
        int j;
        while(i<n){
            int temp = vector.get(i);
            for(j=i;j>0;j--){
                if(temp < vector.get(j-1)){
                    vector.set(j, vector.get(j-1));
                }else{
                    break;
                }
            }
            vector.set(j, temp);
            i++;
        }
    }
    
    static void mergeSort(Vector<Integer> vector){
        int n = vector.size();
        if(n<2){
            return;
        }
        
        int tengah = n/2;
        
        Vector<Integer> vectorKiri = new Vector<>();
        for(int i=0;i<tengah;i++){
            vectorKiri.add(vector.get(i));
        }
        
        Vector<Integer> vectorKanan = new Vector<>();
        for(int i=tengah;i<n;i++){
            vectorKanan.add(vector.get(i));
        }
        
        mergeSort(vectorKiri);
        mergeSort(vectorKanan);
        
        merge(vector, vectorKiri, vectorKanan);        
    }
    
    static void merge(Vector<Integer> vector, Vector<Integer> vectorKiri, Vector<Integer> vectorKanan){
        int i=0, j=0, k=0;
        int sKiri = vectorKiri.size();
        int sKanan = vectorKanan.size();
        
        while(i<sKiri && j<sKanan){
            if(vectorKiri.get(i)<vectorKanan.get(j)){
                vector.set(k++, vectorKiri.get(i++));
            }else{
                vector.set(k++, vectorKanan.get(j++));
            }
        }
        while(i<sKiri){
            vector.set(k++, vectorKiri.get(i++));
        }
        while(j<sKanan){
             vector.set(k++, vectorKanan.get(j++));
        }
    }
    
    static int partisi(Vector<Integer> vector, int low, int high){
        int pivot = vector.get(high);
        int i = low -1;
        for(int j=low;j<high;j++){
            if(vector.get(j)<pivot){
                i++;
                tukarNilai(vector, i, j);
            }
        }
        tukarNilai(vector, i+1, high);
        return i+1;
    }
    
    static void quickSort(Vector<Integer> vector, int low, int high){
        if(low<high){
            int indexPartisi = partisi(vector, low, high);
            quickSort(vector, low, indexPartisi-1);
            quickSort(vector, indexPartisi+1, high);
        }
    }
    
    public static void main(String[] args) {
        Vector<Integer> myVector = inisialisasiVector();
        System.out.print("Original       : ");
        cetak(myVector);//original
        
        Vector<Integer> myVectorBub = kloning(myVector);
        bubbleSort(myVectorBub);
        System.out.print("Bubble Sort    : ");
        cetak(myVectorBub);
        
        Vector<Integer> myVectorSel = kloning(myVector);
        selectionSort(myVectorSel);
        System.out.print("Selection Sort : ");
        cetak(myVectorSel);
        
        Vector<Integer> myVectorIns = kloning(myVector);
        insertionSort(myVectorIns);
        System.out.print("Insertion Sort : ");
        cetak(myVectorIns);
        
        Vector<Integer> myVectorMer = kloning(myVector);
        insertionSort(myVectorMer);
        System.out.print("Merge Sort     : ");
        cetak(myVectorMer);
        
        Vector<Integer> myVectorQui = kloning(myVector);
        quickSort(myVectorQui, 0, myVectorQui.size()-1);
        System.out.print("Quick Sort     : ");
        cetak(myVectorQui);
    }
}