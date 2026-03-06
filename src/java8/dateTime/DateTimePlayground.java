package java8.dateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimePlayground {
    public static void main(String[] args) {
        // LocalDate - current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        // Create specific date
        LocalDate customDate = LocalDate.of(2024, 3, 15);
        System.out.println("Custom Date: " + customDate);
        // Get parts
        System.out.println("\nYear: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());
        System.out.println("Day of Week: " + today.getDayOfWeek());
        // Plus / Minus
        System.out.println("\nPlus 5 days: " + today.plusDays(5));
        System.out.println("Minus 2 months: " + today.minusMonths(2));
        System.out.println("Plus 1 year: " + today.plusYears(1));
        // Leap year check
        System.out.println("\nIs Leap Year: " + today.isLeapYear());
        // Before / After
        System.out.println("Is today before customDate? " + today.isBefore(customDate));
        System.out.println("Is today after customDate? " + today.isAfter(customDate));
        // Parse default format
        LocalDate parsed = LocalDate.parse("2024-03-15");
        System.out.println("Parsed Default: " + parsed);
        // Custom formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedCustom =  LocalDate.parse("15/03/2024", formatter);
        System.out.println("Parsed Custom: " + parsedCustom);
        // Format date to string
        String formattedDate = today.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
        System.out.println("---------------");
        
        // LocalTime - current time
        LocalTime nowTime = LocalTime.now();
        System.out.println("Current Time: " + nowTime);
        // Specific time
        LocalTime time = LocalTime.of(10, 30);
        System.out.println("Custom Time: " + time);
        // Noon
        System.out.println("Noon: " + LocalTime.NOON);
        // Get parts
        System.out.println("Hour: " + nowTime.getHour());
        System.out.println("Minute: " + nowTime.getMinute());
        System.out.println("Second: " + nowTime.getSecond());
        // Format time with AM/PM
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println("Formatted Time: " + nowTime.format(timeFormatter));
        System.out.println("---------------");

        // LocalDateTime
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + dateTime);
        // Extract date and time
        System.out.println("To LocalDate: " + dateTime.toLocalDate());
        System.out.println("To LocalTime: " + dateTime.toLocalTime());
        // Custom DateTime format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formatted DateTime: " + dateTime.format(dateTimeFormatter));
    }
}