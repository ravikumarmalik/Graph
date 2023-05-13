import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph5 {
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
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));



    }

//    public static void bfs(ArrayList<Edge>[] graph){
//        boolean vist[] = new boolean[graph.length];
//        for (int i=0; i<graph.length; i++){
//            if (!vist[i]){
//                bfsUtil(graph, vist);
//            }
//        }
//
//    }
//    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vist[]){ //o(v+e)
//        Queue<Integer> q = new LinkedList<>();
//
//        q.add(0); //source 0;
//        while (!q.isEmpty()){
//            int curr = q.remove();
//
//            if (!vist[curr]){ //then visit curr
//                System.out.print("->"+curr);
//                vist[curr] = true;
//                for (int i=0; i<graph[curr].size(); i++){
//                    Edge e = graph[curr].get(i);
//                    q.add(e.dist);
//                }
//
//            }
//        }
//    }


//    public static void dfs(ArrayList<Edge>[] graph) {
//        boolean[] vist = new boolean[graph.length];
//        for (int i=0; i<graph.length; i++){
//            dfsUtil(graph, i, vist);
//        }
//
//    }

//    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){ //o(v+e)
//
//        //visit
//        System.out.print("->"+curr  );
//        vis[curr] = true;
//
//        for (int i=0; i<graph[curr].size(); i++){
//            Edge e = graph[curr].get(i);
//            if (!vis[e.dist]){
//                dfsUtil(graph, e.dist, vis);
//            }
//        }
//    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {

        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {// -1 who have no parents
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr,int par ){
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dist]){
                if (detectCycleUtil(graph,vis,e.dist, curr)){
                    return true;
                }
            }
            //case 1
            else if (vis[e.dist] && e.dist != par){
                return true;
            }

            //case 2

        }
        return false;

    }
    public static void main(String[] args) {

        int v=5;//v-> vertices

        //int arr[] = new arr[v];
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        System.out.println(detectCycle(graph));

    }
}



/*

true

 */

