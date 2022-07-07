package meetups;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MeetupFacade {

    private MeetupRepo meetupRepo;

    public void attend(int meetupId, List<String> attendees) {
        Meetup meetup = meetupRepo.findById(meetupId);
        meetup.attend(attendees);
    }
}
