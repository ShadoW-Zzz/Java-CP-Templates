import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[1] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int u = node[0];
            int distance = node[1];
            for (int it : adj.get(u)) {
                if (1 + distance < dist[it]) {
                    dist[it] = 1 + distance;
                    q.add(new int[]{it, dist[it]});
                }
            }
        }

        if (dist[n] == (int) (1e9)) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(dist[n]); // Print the shortest distance to node n
        }
        sc.close();
    }
}