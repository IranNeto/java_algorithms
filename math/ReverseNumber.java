package math;

public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println(reverseNumberWithOverflowCheck(123));
    }

    //Reverse numbers always positive
    public static int reverseNumber(int n){
        int result = 0;
        int digit;
        while(n > 0){
            digit = n % 10;
            result = (10 * result) + digit;
            n /= 10;
        }

        return result;
    }

    //Reverse any Integer
    public static int reverseNumberWithOverflowCheck(int n){
        int result = 0;
        int digit, prev_result;
        boolean negative = false;

        if (n < 0) {
            negative = true;
            n = -n;
        }

        while(n != 0){
            prev_result = result;
            digit = n % 10;
            result = result * 10 + digit;
            n /= 10;
            if(result / 10 != prev_result){
                return 0;
            }

        }

        return negative ? -result : result;
    }
}
