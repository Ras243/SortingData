package flowgorithm;
import java.util.Vector;

public class Sorting {
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
        for(int v:vector){
            System.out.print(" "+v);
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
        if(indexA>=0&&indexA<vector.size()&&indexB>=0&&indexB<vector.size()&&indexA!=indexB){
            int A,B,C;
            A = vector.get(indexA);
            B = vector.get(indexB);
            C = A;
            A = B;
            B = C;
            vector.set(indexA, A);
            vector.set(indexB, B);
        }
    }
    
    static public void main(String[]fosalgo){
        Vector<Integer>data = inisialisasiVector();
        System.out.print("Original Data: ");
        cetak(data);
        
        Vector<Integer>dataDua = kloning(data);
        System.out.print("Data1");
        cetak(data);
        System.out.print("Data2");
        cetak(dataDua);
        
        dataDua.set(3, 1769);
        System.out.print("Data1");
        cetak(data);
        System.out.print("Data2");
        cetak(dataDua);
        
        System.out.print("BEFORE TUKAR: ");
        cetak(data);
        tukarNilai(data, 3, 5);
        System.out.print("AFTER TUKAR : ");
        cetak(data);
    }
}