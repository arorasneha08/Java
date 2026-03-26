import java.util.Arrays;

public class DP_AllSubsetXorSum {
    // dp approach : O(n * maxXor); 

    int func(int idx , int xor , int arr[] , int dp[][]){
        if(idx == arr.length) return xor; 
        if(dp[idx][xor] != -1) return dp[idx][xor]; 
        
        int nottake = func(idx + 1 , xor , arr , dp); 
        int take = func(idx + 1 , xor ^ arr[idx] , arr , dp); 
        return dp[idx][xor] = take + nottake; 
    }
    int subsetXORSum(int arr[]) {
        int n = arr.length ; 
        int total = 0 ; 
        
        for(int num : arr){
            total += num ; 
        }
        int dp[][]=  new int[n + 1][total + 1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        
        return func(0 , 0 , arr , dp); 
    }

    // CP Approach : O(n) 

    /**
     * sum of xor of all subsets :- 
     * now for xor , total ans = sum of contribution of each bit summed up 
     * take or of all the elements - if atlesast one element as the bit , it will contribute to 2 ^ n-1 cases 
     * Half subsets → even count → XOR = 0
     * Half subsets → odd count → XOR = 1
     * 
     * If the bit exists :- or * ( 2 ^ n-1)
     */
    int subsetXORSum2(int arr[]) {
        int n = arr.length ; 
        int or = 0 ; 
        for(int num : arr){
            or |= num ; 
        }
        int res = or * (1 << n-1); 
        return res; 
    }
}

