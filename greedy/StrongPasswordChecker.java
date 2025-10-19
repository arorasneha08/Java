
public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int n = s.length(); 
        boolean hasLower = false; 
        boolean hasUpper = false; 
        boolean hasDigit = false;

        // check character types
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                hasLower = true; 
            }
            else if(Character.isUpperCase(ch)){
                hasUpper = true; 
            }
            else if(Character.isDigit(ch)){
                hasDigit = true; 
            }
        }

        int missing = 0; 
        if(!hasLower) missing++; 
        if(!hasUpper) missing++; 
        if(!hasDigit) missing++; 

        // check repeating sequences
        int countPairs = 0; 
        int i = 2;
        while(i < n){
            if(s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == s.charAt(i-2)){
                int len = 2; 
                while(i < n && s.charAt(i) == s.charAt(i-1)){
                    len++; 
                    i++; 
                }
                countPairs += len / 3; 
            } else {
                i++; 
            }
        }

        // case 1: too short
        if(n < 6){
            return Math.max(missing, 6 - n); 
        }
        // case 2: within valid length
        else if(n <= 20){
            return Math.max(missing, countPairs); 
        }
        // case 3: too long
        else{
            int deletions = n - 20; 
            int remDel = deletions; 
            int[] mods = new int[3]; 
            i = 2; 
            while(i < n){
                if(s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == s.charAt(i-2)){
                    int len = 2; 
                    while(i < n && s.charAt(i) == s.charAt(i-1)){
                        len++; 
                        i++; 
                    }
                    mods[len % 3]++; 
                }
                else{
                    i++; 
                }
            }

            // use deletions to reduce replacements
            for(int k = 0; k < 3; k++){
                if(k == 2) continue; 
                while(remDel >= (k + 1) && mods[k] > 0){
                    remDel -= (k + 1); 
                    countPairs--; 
                    mods[k]--; 
                }
            }

            countPairs -= remDel / 3; 

            return deletions + Math.max(missing, countPairs); 
        }
    }
}

// leetcode 420 