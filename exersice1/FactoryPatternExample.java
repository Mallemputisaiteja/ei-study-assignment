interface User {
    void showRole();
}

class Admin implements User {
    public void showRole() {
        System.out.println("I am an Admin.");
    }
}

class Guest implements User {
    public void showRole() {
        System.out.println("I am a Guest.");
    }
}

class UserFactory {
    public static User createUser(String role) {
        if (role.equalsIgnoreCase("admin")) {
            return new Admin();
        } else if (role.equalsIgnoreCase("guest")) {
            return new Guest();
        }
        return null;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        User admin = UserFactory.createUser("admin");
        admin.showRole();

        User guest = UserFactory.createUser("guest");
        guest.showRole();
    }
}
