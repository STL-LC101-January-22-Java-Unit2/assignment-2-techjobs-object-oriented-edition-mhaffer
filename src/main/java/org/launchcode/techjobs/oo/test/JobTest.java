package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job("Junior Developer", new Employer("Boeing"), new Location("St. Louis"), new PositionType("Backend"), new CoreCompetency("Patience"));
        Job testJob2 = new Job("Senior Developer", new Employer("Google"), new Location("Silicon Valley"), new PositionType("Frontend"), new CoreCompetency("Team Player"));
        assertTrue(testJob1.getId() != testJob2.getId() );
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(3, testJob3.getId());

        assertTrue(testJob3.getName() instanceof String);
        assertEquals("Product Tester", testJob3.getName());

        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob3.getEmployer().getValue());

        assertTrue(testJob3.getLocation() instanceof Location);
        assertEquals("Desert", testJob3.getLocation().getValue());

        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob3.getPositionType().getValue());

        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job testJob4 = new Job("Junior Developer", new Employer("Facebook"), new Location("Silicon Valley"), new PositionType("Front End"), new CoreCompetency("Spunk"));
        Job testJob5 = new Job("Junior Developer", new Employer("Facebook"), new Location("Silicon Valley"), new PositionType("Front End"), new CoreCompetency("Spunk"));
        assertFalse(testJob4.equals(testJob5));
    }
}
