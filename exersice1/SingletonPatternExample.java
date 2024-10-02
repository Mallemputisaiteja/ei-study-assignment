class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        connection1.connect();
        System.out.println("Are both connections the same? " + (connection1 == connection2));
    }
}
