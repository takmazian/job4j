package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProfilesTest {
    @Test
    public void testProfiles() {
        Address address1 = new Address("Moscow", "Red square", 3, 12);
        Address address2 = new Address("St. Petersburg", "Sadovaya street", 2, 12);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address1);
        List<Profile> profileList = List.of(profile1, profile2, profile3);
        assertThat(Profiles.collect(profileList), is(List.of(address1, address2)));
    }
}
