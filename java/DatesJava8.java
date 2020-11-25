package java;

import java.time.LocalDate;

public class DatesJava8 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(1995, 7, 20);
        System.out.println(ld.getDayOfWeek().toString());

    }
}
