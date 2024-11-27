import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <commands file>");
            return;
        }

        String fileName = args[0];
        QuadTree quadTree = new QuadTree();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(" ");
                switch (command[0].toUpperCase()) {
                    case "INSERT":
                        double x = Double.parseDouble(command[1]);
                        double y = Double.parseDouble(command[2]);
                        double width = Double.parseDouble(command[3]);
                        double height = Double.parseDouble(command[4]);
                        quadTree.insert(new Rectangle(x, y, width, height));
                        break;
                    case "DUMP":
                        quadTree.dump();
                        break;
                    default:
                        System.out.println("Unknown command: " + command[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
