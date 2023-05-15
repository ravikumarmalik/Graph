import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class graph11 {
    static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int w){
            this.src=src;
            this.dest=dest;
            this.weight=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class pairs implements  Comparable<pairs>{
        int n;
        int path;

        public pairs(int n, int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(pairs p2){
            return this.path - p2.path;//path based sorting for my pairs
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length]; //dist[i] ->src to i
        for (int i=0; i<graph.length; i++){
            if (i != src){
                dist[i] = Integer.MAX_VALUE; //+infinity
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pairs> pq = new PriorityQueue<>();
        pq.add(new pairs(src,0));


        //loop
        while (!pq.isEmpty()){
            pairs curr = pq.remove();
            if (!vis[curr.n]){
                vis[curr.n] = true;

                //neighbour
                for (int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u]+wt < dist[v]){ //update distance of src to v
                        dist[v] = dist[u]+wt;
                        pq.add(new pairs(v,dist[v]));
                    }
                }
            }
        }
        //print all source to vertices the shortest dist
        for (int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v=6;
        int src=0;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        dijkstra(graph,src);

    }
}


/*

0 2 3 8 6 9

 */
