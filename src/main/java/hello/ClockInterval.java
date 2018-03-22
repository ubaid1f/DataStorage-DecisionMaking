package hello;

import java.time.LocalTime;

public class ClockInterval {
	final LocalTime start;
    final LocalTime end;

    private ClockInterval(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    static ClockInterval between(LocalTime start, LocalTime end) {
        return new ClockInterval(start, end);
    }

    boolean contains(LocalTime time) {
        return !time.isBefore(start) && time.isBefore(end);
    }

}
