import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String name) {
        adjList.putIfAbsent(name, new ArrayList<>());
    }

    public void removeLocation(String name) {
        adjList.remove(name);
        for (List<String> connections : adjList.values()) {
            connections.remove(name);
        }
    }

    public void addRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from); // Undirected
        } else {
            System.out.println("One or both locations not found.");
        }
    }

    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).remove(to);
            adjList.get(to).remove(from);
        }
    }

    public void displayConnections() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public void bfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found.");
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (String neighbor : adjList.get(node)) {
                    if (!visited.contains(neighbor)) queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found.");
            return;
        }
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        System.out.print("DFS Traversal: ");
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (String neighbor : adjList.get(node)) {
                    if (!visited.contains(neighbor)) stack.push(neighbor);
                }
            }
        }
        System.out.println();
        System.out.println("AAAAAAAAAAAAAAAAA");
    }

    public Set<String> getLocations() {
        return adjList.keySet();

        // New Sample Comment        
    }
}