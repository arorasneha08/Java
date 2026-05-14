
import java.util.*;

class T1_FractionalKnapsack {

    class Item {
		int value ;
		int weight ;
		Item(int value, int weight) {
			this.value = value ;
			this.weight = weight;
		}
		
	}
	public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
		int n = val.length ;
		Item[] items = new Item[n];
		
		for (int i = 0 ; i < n ; i++) {
			items[i] = new Item(val[i], wt[i]);
		}
		Arrays.sort(items, (a, b) ->
		Double.compare(
		(double) b.value / b.weight,
		(double) a.value / a.weight
		)
		);
		double res = 0 ;
		
		for (int i = 0 ; i < n ; i++) {
			if (items[i].weight <= capacity) {
				res += items[i].value;
				capacity -= items[i].weight ;
			}
			else {
				res += ((double)capacity / items[i].weight) * items[i].value;
				break ;
			}
		}
		return res ;
	}
}