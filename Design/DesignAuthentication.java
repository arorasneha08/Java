

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAuthentication {
    class AuthenticationManager {
        HashMap<String , Integer> mpp ; 
        int time ; 

        public AuthenticationManager(int timeToLive) {
            mpp = new HashMap<>(); 
            time = timeToLive; 
        }
        
        public void generate(String tokenId, int currentTime) {
            mpp.put(tokenId , time + currentTime); 
        }
        
        public void renew(String tokenId, int currentTime) {
            if(!mpp.containsKey(tokenId)){
                return ; 
            }
            if(mpp.get(tokenId) > currentTime){
                mpp.put(tokenId , time + currentTime); 
            }
        }
        
        public int countUnexpiredTokens(int currentTime) {
            // can not remove from the map when traversing the map
            List<String> expired = new ArrayList<>(); 
            for(Map.Entry<String , Integer> entry : mpp.entrySet()){
                if(entry.getValue() <= currentTime){
                    expired.add(entry.getKey()); 
                }
            }
            for(String key : expired){
                mpp.remove(key); 
            }
            return mpp.size(); 
        }
    }
}
