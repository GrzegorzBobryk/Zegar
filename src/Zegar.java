import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zegar {

    public static void main(String... args) {
        clockReader();
    }

    private static void clockReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wpisz godzinę w formacie HH:MM");
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input == null || input.isEmpty() || input.length() > 5 || input.length() < 4 || !input.contains(":")) {
            System.out.println("Błędne dane");
            return;
        }
        String minuteFromInput = input.substring(input.indexOf(":") + 1, input.length());
        String hourFromInput = input.substring(0, input.indexOf(":"));

        System.out.println("Kąt między wskazówkami to: " + getAngle(Integer.parseInt(hourFromInput), Integer.parseInt(minuteFromInput)));

    }

    protected static String getAngle(int hour, int minute) {
        if (hour < 0 || minute < 0 || hour > 12 || minute > 60) {
            return "Błędne dane";
        }
        if (hour == 12) {
            hour = 0;
        }
        if (minute == 60) {
            minute = 0;
            hour += 1;
        }
        double hourAngle = (hour * 60 + minute) * 0.5;
        double minuteAngle = minute * 6;
        double absoluteAngle = Math.abs(hourAngle - minuteAngle);
        return String.valueOf(Math.min(360 - absoluteAngle, absoluteAngle));
    }
}