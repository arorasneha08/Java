import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignFoodRatingSystem {
    class FoodRatings {
    class Pair implements Comparable<Pair>{
        String food ; 
        String cuisine ;
        int rating ; 
        Pair(String food , String cuisine , int rating){
            this.food = food; 
            this.cuisine = cuisine ; 
            this.rating = rating  ;
        } 
        public int compareTo(Pair other){
            if(this.rating != other.rating){
                return other.rating - this.rating ; 
            }
            return this.food.compareTo(other.food); 
        }
    }
    HashMap<String , Pair> foodMap = new HashMap<>();
    HashMap<String , PriorityQueue<Pair>> cuisineMap = new HashMap<>(); 

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0 ; i < foods.length ; i++){
            Pair p = new Pair(foods[i] , cuisines[i] , ratings[i]) ;
            foodMap.put(foods[i] , p); 
            cuisineMap.putIfAbsent(cuisines[i] , new PriorityQueue<>()); 
            cuisineMap.get(cuisines[i]).offer(p); 
        }
    }
    
    public void changeRating(String food, int newRating) {
        if(!foodMap.containsKey(food)) return ;
        Pair curr = foodMap.get(food) ;
        Pair newPair = new Pair(food , curr.cuisine , newRating) ; 
        foodMap.put(food , newPair); 
        cuisineMap.get(curr.cuisine).offer(newPair); 
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = cuisineMap.get(cuisine); 

        while(true){
            Pair top = pq.peek(); 
            Pair curr = foodMap.get(top.food); 
            if(top.rating == curr.rating){
                return top.food; 
            }
            pq.poll(); 
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
