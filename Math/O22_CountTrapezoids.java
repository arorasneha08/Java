public class O22_CountTrapezoids{
    public int countTrapezoids(int[][] mat) {
        int n = mat.length; 
        int mod = (int) 1e9+7 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int p[] : mat){
            mpp.put(p[1] , mpp.getOrDefault(p[1] , 0) + 1); 
        }
        List<Long> list = new ArrayList<>(); 
        for(int key : mpp.keySet()){
            int val = mpp.get(key) ;
            if(val >= 2){
                // calculate nc2 
                long segment = ((long) val * (val - 1) / 2L); 
                list.add(segment % mod); 
            }
        }
        if(list.size() < 2) return 0 ;  // no trapezoid -> because no horizantal parallel edges found
        long total = 0L ; 
        long sum = 0L  ; 
        for(long num : list){
            total = (total + (sum * num) % mod) % mod; 
            sum = (sum + num) % mod; 
        }
        return (int)total ; 
    }
}
// letcode 3623 
