package java12;

import java.time.LocalDate;

public class SwitchDemo {
    static void main() {
        int value = LocalDate.now().getDayOfWeek().getValue();

        String message =switch (value){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "No Match";
        };

        System.out.println(message);
    }
}
