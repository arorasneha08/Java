package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class O8_SortCharacterFreq {
    public class Pair implements Comparable<Pair>{
        char ch ;
        int val ; 
        Pair(char ch , int val){
            this.ch = ch ; 
            this.val = val; 
        }
        public int compareTo(Pair other){
            return other.val - this.val ; 
        }
    }
    public String frequencySort(String s) {
        int n = s.length(); 
        HashMap<Character , Integer> mpp = new HashMap<>(); 
        for(char ch : s.toCharArray()){
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        for(Map.Entry<Character , Integer> entry : mpp.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue(); 
            pq.offer(new Pair(key , val)); 
        }
        StringBuilder str = new StringBuilder(); 
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            char c = curr.ch ;
            int v = curr.val ; 

            for(int i = 0 ; i < v ; i++){
                str.append(c) ;
            }
        }
        return str.toString(); 
    }
}

// leetcode 451 
