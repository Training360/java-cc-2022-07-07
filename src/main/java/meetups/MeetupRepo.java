package meetups;

import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@AllArgsConstructor
public class MeetupRepo {

    private EntityManagerFactory entityManagerFactory;

    public Meetup findById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Meetup.class, id);
    }

    public long createMeetup(int limit) {
        Meetup meetup = new Meetup(limit);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(meetup);
        em.getTransaction().commit();
        em.close();
        return meetup.getId();
    }
}
