package meetups;

import lombok.Getter;

import javax.persistence.*;
import java.util.*;

/**
 * Jelentkezők száma mindig kisebb kell, hogy legyen, mint a határ. -> Invariáns.
 */
@Entity
public class Meetup {

    @Id
    @GeneratedValue    @Getter
    private Long id;

    @Getter
    @Column(name = "attendees_limit")
    private int limit;

    @ElementCollection
    private final Set<String> attendees = new HashSet<>();

    private Meetup() {
        // For Hibernate and EclipseLink
    }

    public Meetup(int limit) {
        this.limit = limit;
    }

    public int getNumberOfAttendees() {
        return attendees.size();
    }

    /**
     * Előfeltétel: newAttendees legalább egy jelentkezőt tartalmaznia kell
     *
     * Idempotens
     */
    public void attend(List<String> newAttendees) {
        validateNotEmpty(newAttendees);
        validateNumberOfAttendees(newAttendees);
        attendees.addAll(newAttendees);
    }

    private void validateNotEmpty(List<String> newAttendees) {
        if (newAttendees == null || newAttendees.isEmpty()) {
            throw new IllegalArgumentException(String.format("Zero attendees can not attend to meetup %d", id));
        }
    }

    private void validateNumberOfAttendees(List<String> newAttendees) {
        if (!placeForAttendees(newAttendees)) {
            throw new IllegalArgumentException(
                    String.format("%d new attendees can not attend to meetup %d, because size is %d",
                            newAttendees.size(), id, attendees.size()));
        }
    }

    public List<String> getAttendees() {
        return Collections.unmodifiableList(new ArrayList<>(attendees));
    }

    private boolean placeForAttendees(List<String> newAttendees) {
        // Set<String> notDuplicatedAttendees = newAttendees.stream().filter(a -> !attendees.contains(a)).collect(Collectors.toSet());
        return attendees.size() + newAttendees.size() <= limit;
    }
}
