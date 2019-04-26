import java.util.LinkedList;

public class MaxFlow {

    static int numVertices;

    static boolean bfs(int graph[][], int src, int sink, int path[]){
        boolean visited[] = new boolean[numVertices];
        for(int i=0; i<numVertices; i++)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        path[src]=-1;

        while (queue.size()!=0){
            int u = queue.poll();

            for (int v=0; v<numVertices; v++){
                if (!visited[v] && graph[u][v] > 0){
                    queue.add(v);
                    path[v] = u;
                    visited[v] = true;
                }
            }
        }

        return (visited[sink]);
    }

    public static int fordFulkerson(int[][] graph, int src, int sink){

        int maxFlow = 0;

        numVertices = graph.length;
        int path[] = new int[numVertices];

        while(bfs(graph, src, sink, path)){

            int temp_flow = Integer.MAX_VALUE;
            for(int vertex=sink; vertex != src; vertex=path[vertex])
                temp_flow = Math.min(temp_flow, graph[path[vertex]][vertex]);

            for(int vertex=sink; vertex != src; vertex=path[vertex]){
                graph[path[vertex]][vertex] -= temp_flow;
                graph[vertex][path[vertex]] += temp_flow;
            }

            maxFlow += temp_flow;

        }

        return maxFlow;
    }

    public static void main(String[] args) {

        int graph[][] =new int[][] { {0, 16, 0, 5, 0, 0},
                {0, 0, 12, 4, 0, 0},
                {0, 0, 0, 9, 7, 5},
                {0, 0, 0, 0, 20, 0},
                {0, 0, 0, 0, 0, 20},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println("The maximum possible flow is " + fordFulkerson(graph, 0, 5));

    }

}
