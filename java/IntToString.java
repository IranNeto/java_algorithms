package java;

public class IntToString {
    public static void main(String[] args) {
        int x = 100;
        //String s = new Integer(x).toString();
        String s = String.valueOf(x);
        System.out.println(s);
    }
}
