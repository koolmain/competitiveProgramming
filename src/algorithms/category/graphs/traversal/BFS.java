package algorithms.category.graphs.traversal;

import java.util.Map;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    LinkedList<Integer> adj[]; 
    int graph [][]; 
    private int V; 

    BFS(int v){
        V = v; 
        graph = new int[v][v]; 
        adj = new LinkedList[v]; 
        for(int i=0; i< V; i++ ){
            adj[i] = new LinkedList<>(); 
        }
        System.out.println("ajdj is"+adj);

    }
    void addEdge(int u, int v){
        adj[u].add(v);
        graph[u][v] = 1; 
    }

    public static void main(String args[]){
        BFS b = new BFS(8); 
        b.addEdge(0,1 );
        b.addEdge(1 , 2 );
        b.addEdge(2,0 );
        b.addEdge(2,3 );
        b.addEdge(3,4 );
        b.addEdge(4,5 );
        b.addEdge(4, 7);
        b.addEdge(5,6 );
        b.addEdge(6,4 );
        b.addEdge(6,7 );
        
    }
    
}
