
import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] array) {
        int n = array.length ;
        String arr[] = new String[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = String.valueOf(array[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b)); 
        if(arr[0].equals("0")){
            return "0"; 
        }
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < n ; i ++){
            str.append(arr[i]);
        }
        return str.toString();
    }
}
