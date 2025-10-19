
import java.util.*;

class FractionalKnapsack {

    private class Pair implements Comparable<Pair>{
        int weight ; 
        int value ; 
        Pair(int w , int v){
            weight = w ; 
            value = v; 
        }
        public int compareTo(Pair other){
            double ratio1 = (double)this.value / this.weight;
            double ratio2 = (double)other.value / other.weight;
            return Double.compare(ratio2, ratio1);
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length ; 
        List<Pair> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new Pair(weights[i] , values[i])); 
        }
        Collections.sort(list); 
        double val = 0 ; 
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).weight <= W){
                W -= list.get(i).weight; 
                val += list.get(i).value; 
            }
            else {
                if(W > 0){
                    val += ((double)list.get(i).value / list.get(i).weight) * W ; 
                    break ; 
                }
            }
        }
        return val ;
    }
}