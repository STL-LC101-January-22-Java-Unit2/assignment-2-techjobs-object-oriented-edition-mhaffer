package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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

    Job testJob0, testJob1, testJob2, testJob3, testJob4, testJob5;
    Employer testEmployer;
    Location testLocation;
    PositionType testPositionType;
    CoreCompetency testCoreCompetency;

    @Before
    public void createTestJobs() {
        testJob0 = new Job("Taste Tester", new Employer("Guy Fieri"), new Location("Flavortown"), new PositionType("Critical"), new CoreCompetency("Tastebuds"));
        testJob1 = new Job();
        testJob2 = new Job();
        testEmployer = new Employer("ACME");
        testLocation = new Location("Desert");
        testPositionType = new PositionType("Quality Control");
        testCoreCompetency = new CoreCompetency("Persistent");
        testJob3 = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        testJob4 = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        testJob5 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, testJob2.getId() - testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob3.getName());
        assertEquals(testEmployer, testJob3.getEmployer());
        assertEquals(testLocation, testJob3.getLocation());
        assertEquals(testPositionType, testJob3.getPositionType());
        assertEquals(testCoreCompetency, testJob3.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob3.equals(testJob4));
    }

    @Test
    public void toStringWithBlankLines() {
        assertEquals("\n" +
                "ID: " + testJob0.getId() +
                "\n" +
                "Name: " + testJob0.getName() +
                "\n" +
                "Employer: " + testJob0.getEmployer() +
                "\n" +
                "Location: " + testJob0.getLocation() +
                "\n" +
                "Position Type: " + testJob0.getPositionType() +
                "\n" +
                "Core Competency: " + testJob0.getCoreCompetency() +
                "\n",
                testJob0.toString());
    }

        @Test
        public void toStringWhenEmpty() {
            String testy = testJob0.toString();
            assertTrue(testy.contains("Data not Available"));
        }


}