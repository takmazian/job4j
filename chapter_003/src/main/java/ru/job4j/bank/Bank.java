package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    private User findUserByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    private Account findAccountByRequisites(List<Account> accounts, String requisities) {
        Account result = null;
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisities)) {
                result = account;
            }
        }
        return result;
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            users.get(user).add(account);
        }
    }


    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            users.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return users.get(findUserByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        List<Account> accounts1 = users.get(findUserByPassport(srcPassport));
        List<Account> accounts2 = users.get(findUserByPassport(destPassport));
        Account account1 = findAccountByRequisites(accounts1, srcRequisite);
        Account account2 = findAccountByRequisites(accounts2, dstRequisite);
        if (account1 != null && account2 != null && account1.getValue() - amount >= 0) {
            account2.setValue(account2.getValue() + amount);
            result = true;
        }
        return result;
    }
}
