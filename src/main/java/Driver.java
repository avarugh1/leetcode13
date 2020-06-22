import java.util.HashMap;
import java.util.Map;

public class Driver {
    private HashMap<Character, Integer> m = new HashMap<>(Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    ));
    public int romanToInt(String s) {
        int ret = 0;

        for(int i=0;i<s.length();i++){
            // get in substrings with length 2
            int val1 = m.get(s.charAt(i));
            int val2 = 0;

            // if last char (can't get next substring) - keep val2 at 0
            if((i+1) < s.length()){
                val2 = m.get(s.charAt(i+1));
            }

            // IX, IV - when we need to subtract
            if(val1 < val2){
                ret += (val2 - val1);
                i++; // skip the next char since we factored it in
            }else{
                ret += val1; // else, just do a simple addition for this char
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        {
            Driver d = new Driver();
            String in = "I";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
        {
            Driver d = new Driver();
            String in = "III";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
        {
            Driver d = new Driver();
            String in = "IV";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }        {
            Driver d = new Driver();
            String in = "IX";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
        {
            Driver d = new Driver();
            String in = "LVIII";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
        {
            Driver d = new Driver();
            String in = "MCMXCIV";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
        {
            Driver d = new Driver();
            String in = "XIV";
            int ret = d.romanToInt(in);
            System.out.println(ret);
        }
    }
}
