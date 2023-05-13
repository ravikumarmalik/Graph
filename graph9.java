import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph9 {
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

    public static void calIndegree(ArrayList<Edge> graph[], int inDegree[]){
        for (int i=0; i<graph.length; i++){
            int v=i;
            for (int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);


                inDegree[e.dist]++;
            }
        }
    }
    public static void topoLogicalSort(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        calIndegree(graph, inDegree);

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<inDegree.length; i++){
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        //bfs
        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            for (int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDegree[e.dist]--;
                if (inDegree[e.dist]==0){
                    q.add(e.dist);
                }

            }
        }
        System.out.println();

    }


    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topoLogicalSort(graph);


    }
}

/*

4 5 0 2 3 1 

 */
