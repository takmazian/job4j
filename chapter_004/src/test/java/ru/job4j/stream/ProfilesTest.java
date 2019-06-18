package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProfilesTest {
    @Test
    public void testProfiles(){
        Address address1 = new Address("Moscow","Red square",3, 12);
        Address address2 = new Address("Moscow","Lubyanka street",2, 12);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> profileList = List.of(profile1,profile2);
        assertTrue(Profiles.collect(profileList).containsAll(List.of(address1,address2)));
    }
}
