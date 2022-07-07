package meetups;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MeetupMain {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        MeetupRepo repo = new MeetupRepo(factory);

        long id = repo.createMeetup(10);
        Meetup meetup = repo.findById(id);
        System.out.println(meetup.getLimit());

    }

}
