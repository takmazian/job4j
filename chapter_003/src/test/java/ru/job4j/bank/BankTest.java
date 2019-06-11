package ru.job4j.bank;

import org.junit.Test;

import static org.junit.Assert.*;


public class BankTest {
    @Test
    public void addAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Vasya", "4512197437"));
        Account account = new Account("1");
        bank.addAccountToUser("4512197437", account);
        assertTrue(bank.getUserAccounts("4512197437").contains(account));
    }

    @Test
    public void removeAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Vasya", "4512197437"));
        Account account = new Account("1");
        bank.addAccountToUser("4512197437", account);
        bank.deleteAccountFromUser("4512197437", account);
        assertEquals(0, bank.getUserAccounts("4512197437").size());
    }

    @Test
    public void checkRemovedUser() {
        Bank bank = new Bank();
        User user = new User("Vasya", "4512197437");
        bank.addUser(user);
        bank.deleteUser(user);
        assertFalse(bank.getUsers().keySet().contains(user));
    }

    @Test
    public void checkTransferFromOneAccToAnother() {
        Bank bank = new Bank();
        bank.addUser(new User("Vasya", "4512197437"));
        bank.addUser(new User("Petya", "4512197438"));
        Account account = new Account("1");
        bank.addAccountToUser("4512197437", new Account("1"));
        bank.addAccountToUser("4512197438", new Account("2"));
        bank.transferMoney("4512197437", "1", "4512197438", "2", 50);
        assertEquals(150.0f, bank.getUserAccounts("4512197438").get(0).getValue(), 0.0);
    }
}
