import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class User implements Observer {
    private String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class NotificationSystem {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        NotificationSystem notificationSystem = new NotificationSystem();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        notificationSystem.subscribe(user1);
        notificationSystem.subscribe(user2);

        notificationSystem.notifyObservers("New update available!");
    }
}
