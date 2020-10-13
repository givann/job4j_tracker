package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (!user.getUsername().equals(login)) {
                throw new UserNotFoundException("User not found");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        User userP = new User("To", true);
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            if (validate(userP)) {
//                System.out.println("This user has an access");
//            }
//        } catch (UserInvalidException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.getMessage();
//        }
    }
}

