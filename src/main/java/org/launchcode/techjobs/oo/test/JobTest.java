package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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


    Job testJob1;
    Job testJob2;

    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        testJob1 = new Job();
        testJob2 = new Job();
        Assert.assertFalse(testJob1.getId() == testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType position = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Assert.assertTrue(testJob.getName() instanceof String);
        Assert.assertTrue(testJob.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob.getLocation() instanceof Location);
        Assert.assertTrue(testJob.getPositionType() instanceof PositionType);
        Assert.assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Product tester", testJob.getName());
        Assert.assertEquals("ACME", testJob.getEmployer().getValue());
        Assert.assertEquals("Desert", testJob.getLocation().getValue());
        Assert.assertEquals("Quality control", testJob.getPositionType().getValue());
        Assert.assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job oneJob = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"),
                new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job twoJob = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"),
                new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Assert.assertFalse(oneJob.equals(twoJob));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobbyJob = new Job("Ice cream tester", new Employer(""), new Location("Home"),
                new PositionType("UX"), new CoreCompetency("Tasting ability"));
        String data = "ID:" + jobbyJob.getId() +
                "\nName: " + jobbyJob.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + jobbyJob.getLocation() +
                "\nPosition Type: " + jobbyJob.getPositionType() +
                "\nCore Competency: "+ jobbyJob.getCoreCompetency();
        char firstChar = jobbyJob.toString().charAt(0);
        char lastChar = jobbyJob.toString().charAt(jobbyJob.toString().length()-1);
        Assert.assertEquals(firstChar, '\n');
        Assert.assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\nID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert" +
                "\nPosition Type: Quality control\nCore Competency: Persistence\n";
        Assert.assertEquals(expected, testJob.toString());
        System.out.println(testJob);
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job anotherTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\nID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert" +
                "\nPosition Type: Quality control\nCore Competency: Persistence\n";
        Assert.assertEquals(expected, anotherTestJob.toString());
    }

}