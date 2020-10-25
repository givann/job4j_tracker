package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = null;
        if (findByPassport(passport) != null) {
            user = findByPassport(passport);
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);

        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = null;
        if (findByPassport(passport) != null) {
            user = findByPassport(passport);
        }
        List<Account> accounts = users.get(user);
        int index = accounts.indexOf(new Account(requisite, -1));
        if (index == -1) {
            return null;
        }
        return accounts.get(index);

    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDst = findByRequisite(destPassport, destRequisite);
        if (amount > accountSrc.getBalance() || accountSrc == null || accountDst == null) {
            return rsl;
        } else {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDst.setBalance(accountDst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}