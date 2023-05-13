import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph6 {
    static class Edge {
        int src;
        int dist;

        public Edge(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));


        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));


    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){ //O(v+e)
        /*
        check bipartite graph in undirected graph
        if graph doesn't have any cycle means by default graph is bipartite graph.
        -1 -> no color assign
        0 -> yellow color assign
        1 -> blue color assign
         */


        int color[] = new int[graph.length];
        for (int i=0; i<graph.length; i++){
            color[i] = -1; //no color
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<graph.length; i++){
            if (color[i] == -1){ // perform bfs

                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()){

                    int curr = q.remove();
                    for (int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j); //e.destination
                        if (color[e.dist] == -1){
                            int netColor = color[curr] == 0 ? 1 : 0;
                            color[e.dist] = netColor;
                            q.add(e.dist);
                        } else if (color[e.dist] == color[curr]) {
                            return false; //means not bipartite
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v=5;//v-> vertices

        //int arr[] = new arr[v];
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        System.out.println((isBipartite(graph)));

    }
}

/*

false

 */
