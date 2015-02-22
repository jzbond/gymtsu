package com.gymtsu;

import com.gymtsu.domain.Gym;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

/**
 * SimpleTest
 */
public class SimpleTest {

    @Test
    public void testConnection() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Gym gym = new Gym();
        gym.setName("testName2");
        gym.setCompany("testCompany2");
        gym.setAddress("testAddress2");

        session.beginTransaction();
        session.save(gym);
        session.getTransaction().commit();

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Gym gym2 = (Gym) session.load(Gym.class, gym.getId());
        Assert.assertEquals(gym, gym2);
        session.getTransaction().commit();

    }

}
