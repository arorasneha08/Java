
public class O14_CalculateMoneyLeetcodeBank {
    public int totalMoney(int n) {
        int total = 0 ; 
        if(n <= 7){
            for(int i = 1 ; i <= n ; i++){
                total += i ; 
            }
            return total ; 
        }
        else{
            int start = 1 ; 
            int days = n % 7 ; 
            int week = n / 7 ;
            
            for(int i = 0 ; i < week ; i++){
                for(int j = 0 ; j < 7 ; j++){
                    total += (start + j); 
                }
                start ++ ; 
            }
            for(int i = 0 ; i < days ; i++){
                total += (start + i); 
            }
        }
        return total ; 
    }
}

// leetcode 1716 