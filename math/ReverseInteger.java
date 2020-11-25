package math;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-210));
    }
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0){
            negative = true;
        }

        byte[] strAsByteArray = String.valueOf(x).getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for(int i = 0; i < strAsByteArray.length; i++){
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }

        String resultString = new String(result).replace("-", "");

        return negative ? -1 * Integer.parseInt(resultString) : Integer.parseInt(resultString);
    }
}
