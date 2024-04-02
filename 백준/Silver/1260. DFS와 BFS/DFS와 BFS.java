import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // read 1 line
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String[] counts = sc.nextLine().split(" ");
        int n = Integer.parseInt(counts[0]); // number of vertices
        int m = Integer.parseInt(counts[1]); // number of edges
        int v = Integer.parseInt(counts[2]); // starting vertex
        // make adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        // parse the graph
        for (int i = 0; i < m; i++) {
            String[] edge = sc.nextLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        // sort the adjacency list
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList.get(i));
        }
        // run dfs and bfs
        boolean[] visited = new boolean[n+1];
        dfs(v, adjList, visited);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v, adjList, visited);
    }
    static void dfs(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < adjList.get(v).size(); i++) {
            int next = adjList.get(v).get(i);
            if (!visited[next]) {
                dfs(next, adjList, visited);
            }
        }
    }
    static void bfs(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");
            for (int i = 0; i < adjList.get(current).size(); i++) {
                int next = adjList.get(current).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
