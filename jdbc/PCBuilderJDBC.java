import java.sql.*;
import java.util.Scanner;

public class PCBuilderJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/pc_builder";
    private static final String USER = "root"; // Change if needed
    private static final String PASSWORD = "Vijaysarkar@001"; // Change if needed

    public static void main(String[] args) {
        try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in); 

            System.out.println("PC Builder - JDBC Console Application");

            while (true) {
                System.out.println("\n1. Add Build");
                System.out.println("2. View Builds");
                System.out.println("3. Update Build");
                System.out.println("4. Delete Build");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> addBuild(conn, scanner);
                    case 2 -> viewBuilds(conn);
                    case 3 -> updateBuild(conn, scanner);
                    case 4 -> deleteBuild(conn, scanner);
                    case 5 -> {
                        System.out.println("Exiting..."); 
                        return;
                    }
                    default -> System.out.println("Invalid option! Try again.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addBuild(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Build Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Processor: ");
        String processor = scanner.nextLine();
        System.out.print("Enter Graphics Card: ");
        String graphicsCard = scanner.nextLine();
        System.out.print("Enter Memory (RAM): ");
        String memory = scanner.nextLine();
        System.out.print("Enter Storage: ");
        String storage = scanner.nextLine();
        System.out.print("Enter Power Supply: ");
        String powerSupply = scanner.nextLine();

        String query = "INSERT INTO builds (name, processor, graphics_card, memory, storage, power_supply) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, processor);
            stmt.setString(3, graphicsCard);
            stmt.setString(4, memory);
            stmt.setString(5, storage);
            stmt.setString(6, powerSupply);
            stmt.executeUpdate();
            System.out.println("Build added successfully!");
        }
    }

    private static void viewBuilds(Connection conn) throws SQLException {
        String query = "SELECT * FROM builds";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nPC Builds:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - " +
                        rs.getString("processor") + ", " + rs.getString("graphics_card") +
                        ", " + rs.getString("memory") + " RAM, " + rs.getString("storage") +
                        ", " + rs.getString("power_supply"));
            }
        }
    }

    private static void updateBuild(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Build ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter New Processor: ");
        String processor = scanner.nextLine();
        System.out.print("Enter New Graphics Card: ");
        String graphicsCard = scanner.nextLine();
        System.out.print("Enter New Memory (RAM): ");
        String memory = scanner.nextLine();
        System.out.print("Enter New Storage: ");
        String storage = scanner.nextLine();
        System.out.print("Enter New Power Supply: ");
        String powerSupply = scanner.nextLine();

        String query = "UPDATE builds SET processor=?, graphics_card=?, memory=?, storage=?, power_supply=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, processor);
            stmt.setString(2, graphicsCard);
            stmt.setString(3, memory);
            stmt.setString(4, storage);
            stmt.setString(5, powerSupply);
            stmt.setInt(6, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Build updated successfully!");
            } else {
                System.out.println("Build ID not found.");
            }
        }
    }

    private static void deleteBuild(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Build ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM builds WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Build deleted successfully!");
            } else {
                System.out.println("Build ID not found.");
            }
        }
    }
}
