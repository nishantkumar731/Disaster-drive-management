import java.util.*;

class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

class UserManager {
    private List<User> users = new ArrayList<>();

    // Create
    public void addUser(User user) {
        users.add(user);
    }

    // Read
    public User getUser(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update
    public void updateUser(int id, String newName, String newEmail) {
        User user = getUser(id);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
        }
    }

    // Delete
    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    // Display all
    public void listUsers() {
        users.forEach(System.out::println);
    }
}

public class DataManagementExample {
    public static void main(String[] args) {
        UserManager manager = new UserManager();

        // Add users
        manager.addUser(new User(1, "Alice", "alice@example.com"));
        manager.addUser(new User(2, "Bob", "bob@example.com"));

        System.out.println("All users:");
        manager.listUsers();

        // Update a user
        manager.updateUser(2, "Bob Marley", "bob.marley@example.com");

        // Delete a user
        manager.deleteUser(1);

        System.out.println("\nAfter updates:");
        manager.listUsers();
    }
}
