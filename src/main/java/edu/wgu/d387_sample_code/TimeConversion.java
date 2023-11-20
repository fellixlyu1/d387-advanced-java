package edu.wgu.d387_sample_code;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static String[] convertedTime() {
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Phoenix");
        ZoneId zUTC = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        String formattedEastern = "ET: " + localDateTimeEastern.format(DateTimeFormatter.ofPattern("HH:mm"));

        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        String formattedMountain = "MT: " + localDateTimeMountain.format(DateTimeFormatter.ofPattern("HH:mm"));

        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();
        String formattedUTC = "UTC: " + localDateTimeUTC.format(DateTimeFormatter.ofPattern("HH:mm"));

        return new String[]{formattedEastern, formattedMountain, formattedUTC};
    }
}
