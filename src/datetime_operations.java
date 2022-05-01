import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class datetime_operations {
    static LocalDateTime getDate() {
        return LocalDateTime.now();
    }
    static DateTimeFormatter getFormat() {
        return DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    }
    public static void main(String[] args) {
        DateTimeFormatter dtf = getFormat();
        LocalDateTime now = getDate();
        System.out.println("Current time: " + dtf.format(now));
        LocalDate date_300_earlier = LocalDate.now().plusYears(1);
        System.out.println("Date before a year: " + date_300_earlier);
        LocalDate date_300_later = LocalDate.now().minusYears(1);
        System.out.println("Date after a year: " + date_300_later);
    }
}
