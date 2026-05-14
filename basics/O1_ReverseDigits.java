package basics;

public class O1_ReverseDigits {
    int rev =  0 ; 
    public int reverseDigits(int n) {
        // Code here
        if(n == 0) return rev; 
        
        int digit = n % 10 ; 
        rev = rev * 10 + digit; 
        
        return reverseDigits(n / 10); 
    }
}
