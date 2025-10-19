package Math;

public class O6_WaterBottleII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles ; 
        int count = numBottles; 

        while(empty >= numExchange){
            empty -= numExchange ; 
            numExchange ++ ; 
            count ++; 
            empty ++; 
        }
        return count ; 
    }
}

// leetcode 3100 