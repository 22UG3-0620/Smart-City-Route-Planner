import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        AVLTree tree = new AVLTree();

        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (AVL Tree)");
            System.out.println("7. BFS Traversal");
            System.out.println("8. DFS Traversal");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String loc = sc.nextLine();
                    graph.addLocation(loc);
                    tree.insert(loc);
                    System.out.println(loc + " added.");
                    break;

                case 2:
                    System.out.print("Enter location to remove: ");
                    String rem = sc.nextLine();
                    graph.removeLocation(rem);
                    System.out.println(rem + " removed.");
                    break;

                case 3:
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    graph.addRoad(from, to);
                    System.out.println("Road added between " + from + " and " + to);
                    break;

                case 4:
                    System.out.print("Enter first location: ");
                    from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    to = sc.nextLine();
                    graph.removeRoad(from, to);
                    System.out.println("Road removed between " + from + " and " + to);
                    break;

                case 5:
                    System.out.println("\nAll Connections:");
                    graph.displayConnections();
                    break;

                case 6:
                    System.out.println("\nLocations (Inorder AVL Tree):");
                    tree.inorder();
                    break;

                case 7:
                    System.out.print("Enter start location for BFS: ");
                    graph.bfsTraversal(sc.nextLine());
                    break;

                case 8:
                    System.out.print("Enter start location for DFS: ");
                    graph.dfsTraversal(sc.nextLine());
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}