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
    public void emptyTest(){
        assertEquals(1, 1);
    }

    @Test
    public void testSettingJobId(){
        Job one = new Job();
        Job two = new Job();

        assertNotEquals(one.getId(), two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(test.getName() instanceof String);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test instanceof Job);
        assertEquals(test.getPositionType().toString(), "Quality control");
        assertEquals(test.getName(), "Product tester");
        assertEquals(test.getLocation().toString(), "Desert");
        assertEquals(test.getEmployer().toString(), "ACME");
        assertEquals(test.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job coder = new Job("Web Dev", new Employer("NFL"), new Location("Remote"),
                new PositionType("Developer"), new CoreCompetency("Java"));
        Job coder1 = new Job("Web Dev", new Employer("NFL"), new Location("Remote"),
                new PositionType("Developer"), new CoreCompetency("Java"));

        assertNotEquals(coder.getId(), coder1.getId());
        assertFalse(coder.getId() == 5);
    }

    @Test
    public void testJobToString(){

        Job engineer = new Job("Engineer", new Employer("Google"), new Location("Remote"),
                new PositionType("Engineer"), new CoreCompetency("Software"));

        assertEquals(engineer.toString(),
                "ID: " + engineer.getId() +
                "\nName: " + engineer.getName() +
                "\nEmployer: " + engineer.getEmployer() +
                "\nLocation: " + engineer.getLocation() +
                "\nPosition Type: " + engineer.getPositionType() +
                "\nCore Competency: " + engineer.getCoreCompetency());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job athlete = new Job("Slot Receiver", new Employer("NFL"), new Location("Denver"),
                new PositionType("Receiver"), new CoreCompetency("Catching"));
        assertEquals('\n', athlete.toString().charAt(0));
        assertEquals('\n', athlete.toString().charAt(athlete.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job athlete = new Job("Slot Receiver", new Employer("NFL"), new Location("Denver"),
                new PositionType("Receiver"), new CoreCompetency(""));

        assertEquals(athlete.toString(),
                "\nID: " + athlete.getId() +
                "\nName: " + athlete.getName() +
                "\nEmployer: " + athlete.getEmployer() +
                "\nLocation: " + athlete.getLocation() +
                "\nPosition Type: " + athlete.getPositionType() +
                "\nCore Competency: Data not available");
    }

    @Test
    public void testToStringHandlesEmptyField (){
        Job athlete = new Job("", new Employer("NFL"), new Location("Denver"),
                new PositionType("Receiver"), new CoreCompetency(""));

        assertEquals(athlete.toString(),
                "ID: " + athlete.getId() +
                        "\nName: Data not available" +
                        "\nEmployer: " + athlete.getEmployer() +
                        "\nLocation: " + athlete.getLocation() +
                        "\nPosition Type: " + athlete.getPositionType() +
                        "\nCore Competency: Data not available");
    }

}
