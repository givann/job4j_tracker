package ru.job4j.bank;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> optionalUser = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findAny();
        return optionalUser;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            Optional<Account> accountN = users.get(user.get()).stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst();
            return accountN;
        }
        return Optional.empty();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                 String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDst = findByRequisite(destPassport, destRequisite);
        if (accountSrc == null || amount > accountSrc.get().getBalance() || accountDst == null) {
            return rsl;
        } else {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDst.get().setBalance(accountDst.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}