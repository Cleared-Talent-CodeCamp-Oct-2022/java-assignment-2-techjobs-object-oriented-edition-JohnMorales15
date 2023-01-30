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
}
