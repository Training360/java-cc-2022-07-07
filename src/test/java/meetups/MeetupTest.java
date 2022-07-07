package meetups;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeetupTest {

    @Test
    void testAttend() {
        Meetup meetup = new Meetup( 3);
        meetup.attend(List.of("john", "jack"));
        assertEquals(2, meetup.getNumberOfAttendees());
    }

    @Test
    void testTwiceAttend() {
        Meetup meetup = new Meetup(3);
        meetup.attend(List.of("john", "jack", "jane"));

        meetup.attend(List.of("john", "jack", "jane"));
        assertEquals(3, meetup.getNumberOfAttendees());
    }

    @Test
    void testUpdateAttendees() {
        assertThrows(Exception.class, () -> new Meetup(3).getAttendees().add("john"));
    }

    @Test
    void testAttendToFullMeetup() {
        Meetup meetup = new Meetup(3);
        meetup.attend(List.of("john", "jack", "jane"));

        List<String> newAttendees = List.of("joe");
        assertThrows(IllegalArgumentException.class, () -> meetup.attend(newAttendees));
    }
}
