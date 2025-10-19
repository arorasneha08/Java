package Strings;

public class O18_ValidateIPAddress {
    private int checkAddress(String str){
        if(str.contains(".")) return 1 ; 
        if(str.contains(":")) return 2 ; 
        return 0 ; 
    }
    private String checkIPv6(String str){
        int n = str.length(); 
        String parts[] = str.split("\\:", -1); 
        String res = "Neither"; 
        if(parts.length != 8) return res; 
        for(int i = 0 ; i < parts.length ; i++){
            String s = parts[i]; 
            int len = s.length(); 
            if(len > 4 || len == 0) return res ;
            for(char ch : parts[i].toCharArray()){
                if(!Character.isDigit(ch) && !(ch >= 'a' && ch <= 'f') && !(ch >= 'A' && ch <= 'F')){
                    return res; 
                }
            }
        }
        return "IPv6"; 
    }
    private String checkIPv4(String str){
        int n = str.length(); 
        String parts[] = str.split("\\.", -1);
        String res = "Neither";
        if(parts.length != 4) return res ; 
        for(int i = 0 ; i < parts.length ; i++){
            String s = parts[i]; 
            if(s.length() > 1 && s.charAt(0) == '0') return res; 
            if(s.length() == 0 || s.length() > 3) return res; 

            for(char ch : s.toCharArray()){
                if(!Character.isDigit(ch)){
                    return res; 
                }
            }
            int num = Integer.parseInt(s); 
            if(num < 0 || num > 255) return res ; 
        }
        return "IPv4"; 
    }

    public String validIPAddress(String str) {
        int check = checkAddress(str); 
        if(check == 0) return "Neither"; 
        boolean isIPv4 = false; 
        boolean isIPv6 = false; 
        if(check == 1) isIPv4 = true ; 
        if(check == 2) isIPv6 = true ;
        String res = "Neither"; 

        if(isIPv4){
            res = checkIPv4(str); 
        }
        if(isIPv6){
            res = checkIPv6(str); 
        }
        return res ; 
    }
}
