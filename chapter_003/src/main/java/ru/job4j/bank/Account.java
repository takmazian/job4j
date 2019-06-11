package ru.job4j.bank;

import java.util.Objects;

public class Account {
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double value = 100;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0
                && requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public String getRequisites() {
        return requisites;
    }

    private String requisites;


}
