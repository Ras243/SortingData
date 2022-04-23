package tugas_pert7;
import java.util.*;

public class random_Quick {
    public static void main(String[] args) {
        ArrayList<Double> elements=new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke "+i+" : ");
            Double nilai = scan.nextDouble();
            elements.add(nilai);
        }
        System.out.println("Data Original : "+elements);
        randomquicksort(elements,0, elements.size()-1);
        System.out.print("Random Quick Sort : ");
        for(int i=0;i<elements.size();i++){
            System.out.print(elements.get(i)+" ");
        }
        scan.close();
    }
    
    public static void swap(ArrayList<Double> elements, int i, int j){
        Double temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public static int partition(ArrayList<Double> elements, int beg, int end){
        
        int random=beg + ((int)Math.random()*(elements.size()))/(end-beg+1);
        int last=end;
        swap(elements, random, end);
        end--;
        
        while(beg<=end){
            if(elements.get(beg)<elements.get(last)) beg++; 
            else {
                swap(elements, beg, end);
                end--;
            }
        }
        swap(elements, beg, last);
        
        return beg;
    }
    
    public static void randomquicksort(ArrayList<Double> elements, int beg, int end){
        if(beg>=end) return;
        if(beg<0) return;
        if(end>elements.size()-1) return;
        
        int pivot = partition(elements, beg, end);
        randomquicksort(elements, beg, pivot-1);
        randomquicksort(elements, pivot+1, end);
    }
}