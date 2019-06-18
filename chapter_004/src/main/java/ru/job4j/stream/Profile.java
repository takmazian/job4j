package ru.job4j.stream;

public class Profile {
    private Address address;

    Address getAddress(){
        return address;
    }

    public Profile(Address address){
        this.address = address;
    }
}
