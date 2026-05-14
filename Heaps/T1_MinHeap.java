import java.util.ArrayList;
import java.util.List;

public class T1_MinHeap {
    List<Integer> list ; 
    
    public int left(int i){
        return 2 * i + 1 ; 
    }
    public int right(int i){
        return 2 * i + 2 ; 
    }
    public int parent(int i){
        return (i - 1)/ 2 ; 
    }
    public T1_MinHeap() {
        list = new ArrayList<>(); 
    }
    public void heapify(int i){
        int left = left(i);
        int right = right(i); 
        int smallest = i ; 
        
        if(left < list.size() && list.get(left) < list.get(smallest)){
            smallest = left; 
        }
        if(right < list.size() && list.get(right) < list.get(smallest)){
            smallest = right; 
        }
        if(smallest != i){
            int temp = list.get(i); 
            list.set(i , list.get(smallest)); 
            list.set(smallest , temp); 
            heapify(smallest); 
        }
    }

    public void push(int x) {
        list.add(x); 
        int pos = list.size()-1; 
        
        while(pos > 0 && list.get(pos) < list.get(parent(pos))){
            int temp = list.get(pos); 
            list.set(pos , list.get(parent(pos))); 
            list.set(parent(pos) , temp); 
            
            pos = parent(pos); 
        }
    }

    public void pop() {
        if(list.size() == 0) return ; 
        int last = list.size()-1; 
        list.set(0 , list.get(last)); 
        list.remove(last); 
        if(list.size() > 0){
            heapify(0);
        }
    }

    public int peek() {
        if(list.size() == 0) return -1; 
        return list.get(0); 
    }

    public int size() {
        return list.size(); 
    }
}
