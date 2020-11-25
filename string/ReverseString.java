package string;

public class ReverseString {

    public static void main(String[] args) {

    }

    public static String reverseStringStringBuilder(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static String reverseStringByteArray(String s){
        byte[] result = new byte[s.length()];
        byte[] stringByteArray = s.getBytes();

        for(int i = 0; i < s.length(); i++){
            result[i] = stringByteArray[s.length() - i - 1];
        }

        return new String(result);
    }
}
