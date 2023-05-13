import java.util.ArrayList;
import java.util.Stack;

public class graph8 {
    static class Edge {
        int src;
        int dist;

        public Edge(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { //true cycle
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static void topologicalSorting(ArrayList<Edge> graph[]){

        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<graph.length; i++){
            if (!vis[i]){
                topologicalSortingUtil(graph, i, vis,s);//dfs
            }
        }
        while (!s.isEmpty()){
            System.out.print("->"+s.pop());
        }
    }

    public static void topologicalSortingUtil(ArrayList<Edge> graph[],int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dist]){
                topologicalSortingUtil(graph, e.dist, vis, s); //modified
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
       topologicalSorting(graph);

    }
}

/*

->5->4->2->3->1->0

 */