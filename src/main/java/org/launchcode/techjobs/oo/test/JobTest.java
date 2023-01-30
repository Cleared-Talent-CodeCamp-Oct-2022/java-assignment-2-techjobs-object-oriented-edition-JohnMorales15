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
        Job one = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(one instanceof Job);
        assertEquals(one.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job coder = new Job("Web Dev", new Employer("NFL"), new Location("Remote"),
                new PositionType("Developer"), new CoreCompetency("Java"));
        Job coder1 = new Job("Web Dev", new Employer("NFL"), new Location("Remote"),
                new PositionType("Developer"), new CoreCompetency("Java"));

        assertNotEquals(coder.getId(), coder1.getId());
    }

    @Test
    public void testJobToString(){

        Job engineer = new Job("", new Employer("Google"), new Location("Remote"),
                new PositionType("Engineer"), new CoreCompetency(""));
        Job designer = new Job();

//        assertEquals(designer.toString(), "OOPS! This job does not seem to exist.");
        assertEquals(engineer.toString(), "Data not available");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job athlete = new Job("Slot Receiver", new Employer("NFL"), new Location("Denver"),
                new PositionType("Receiver"), new CoreCompetency("Catching"));

        assertEquals(athlete.toString(), "ID= " + athlete.getId() + "\n" +
                "Name= " + athlete.getName() + "\n" +
                "Employer= " + athlete.getEmployer() + "\n" +
                "Location= " + athlete.getLocation() + "\n" +
                "PositionType= " + athlete.getPositionType() + "\n" +
                "CoreCompetency= " + athlete.getCoreCompetency());
    }


}
