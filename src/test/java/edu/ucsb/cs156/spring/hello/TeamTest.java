package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }


    @Test
    public void equals_returns_correctly() {
        // Case 1: these are the same object
        Team team2 = team;
        assert(team.equals(team2));

        // Case 2: the other object isn't even an instance of this class
        String team3 = "not a team";
        assert(!team.equals(team3));
        
        // Case 3: Cast the other object to this class, and compare all of the fields
        Team team4 = new Team("test-team");
        assert(team.equals(team4));

        Team team5 = new Team("test-team");
        team5.addMember("bob");
        assert(!team.equals(team5));

        Team team6 = new Team("different-name");
        assert(!team.equals(team6));
        
        Team team7 = new Team("different-name");
        team7.addMember("bob");
        assert(!team.equals(team7));

    }
    @Test
    public void hashCode_returns_correct_hash(){
        int teamhash = team.hashCode();
        int expectedHash = -1226298695;
        assertEquals(expectedHash, teamhash);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
