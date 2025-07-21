package org.rdutta.ezflight.infrastructure.configuration;

import java.util.regex.*;
import java.util.*;

public class FlightNERParser {

    public static Map<String, String> parseSentence(String sentence) {
        Map<String, String> result = new HashMap<>();

        // Regex: from <city1> to <city2> at <time>
        Pattern pattern = Pattern.compile("from\\s+(\\w+)\\s+to\\s+(\\w+)\\s+at\\s+(\\d{1,2})(AM|PM)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        if (matcher.find()) {
            String from = matcher.group(1);
            String to = matcher.group(2);
            String hour = matcher.group(3);
            String meridiem = matcher.group(4);

            // Convert to 24-hour format
            String time24 = convertTo24Hour(hour, meridiem);

            result.put("from", capitalize(from));
            result.put("to", capitalize(to));
            result.put("start", time24);
        } else {
            result.put("from", null);
            result.put("to", null);
            result.put("start", null);
        }

        return result;
    }

    private static String convertTo24Hour(String hourStr, String meridiem) {
        int hour = Integer.parseInt(hourStr);
        if (meridiem.equalsIgnoreCase("PM") && hour != 12) {
            hour += 12;
        } else if (meridiem.equalsIgnoreCase("AM") && hour == 12) {
            hour = 0;
        }
        return String.format("%02d:00:00", hour);
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
