import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph2 {

     static class Edge{
         int src;
         int dest;
         int weight;

         public Edge(int src, int dest, int weight){
             this.src=src;
             this.dest=dest;
             this.weight=weight;
         }
     }

     static void createGraph(ArrayList<Edge> graph[]){
         for (int i=0; i<graph.length; i++){
             graph[i]=new ArrayList<>();
         }
         graph[0].add(new Edge(0,1,1));
         graph[0].add(new Edge(0,2,1));

         graph[1].add(new Edge(1,0,1));
         graph[1].add(new Edge(1,3,1));

         graph[2].add(new Edge(2,0,1));
         graph[2].add(new Edge(2,4,1));

         graph[3].add(new Edge(3,1,1));
         graph[3].add(new Edge(3,4,1));
         graph[3].add(new Edge(3,5,1));

         graph[4].add(new Edge(4,2,1));
         graph[4].add(new Edge(4,3,1));
         graph[4].add(new Edge(4,5,1));

         graph[5].add(new Edge(5,3,1));
         graph[5].add(new Edge(5,4,1));
         graph[5].add(new Edge(5,6,1));

         graph[6].add(new Edge(6,5,1));

     }

     public static void bfs(ArrayList<Edge>[] graph){ //o(v+e)
         Queue<Integer> q = new LinkedList<>();
         boolean vist[] = new boolean[graph.length];

         q.add(0); //source 0;
         while (!q.isEmpty()){
             int curr = q.remove();

             if (!vist[curr]){ //then visit curr
                 System.out.print("->"+curr);
                 vist[curr] = true;
                 for (int i=0; i<graph[curr].size(); i++){
                     Edge e = graph[curr].get(i);
                     q.add(e.dest);
                 }

             }
         }
     }

    public static void main(String[] args) {

        int v=7;//v-> vertices

        //int arr[] = new arr[v];
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        bfs(graph);

        }
    }

    /*

    ->0->1->2->3->4->5->6

     */

