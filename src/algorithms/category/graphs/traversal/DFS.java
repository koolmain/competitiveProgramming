package algorithms.category.graphs.traversal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    LinkedList<Integer> adj[]; 
    int graph [][]; 
    private int V; 

    DFS(int v){
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

    void dfs(int node, boolean[] visited){
        //visited[node]= true; 
       // System.out.print(node + "->");
        Iterator<Integer> iterator =  adj[node].listIterator(); 
        //Recursive 
            // while(iterator.hasNext()){
            //     int nxt = iterator.next(); 
            //     if(!visited[nxt]){
                
            //     dfs(nxt, visited);
            //     }  
            //}
        //Iterative
        Stack<Integer> stack = new Stack<>();
        stack.push(node); 
        while(!stack.isEmpty()){
            int item = stack.pop(); 
            if(visited[item])
                continue; 
            System.out.print(item +" -> ");
            visited[item] = true; 
            Iterator<Integer> itr = adj[item].listIterator(); 
            while(itr.hasNext()){
                node = itr.next(); 
                if(!visited[node])
                    stack.push(node); 
            }
        }
        }

    public static void main(String args[]){
        DFS g = new DFS(8); 
        // b.addEdge(0,1 );
        // b.addEdge(1 , 2 );
        // b.addEdge(2,0 );
        // b.addEdge(2,3 );
        // b.addEdge(3,4 );
        // b.addEdge(4,5 );
        // b.addEdge(4, 7);
        // b.addEdge(5,6 );
        // b.addEdge(6,4 );
        // b.addEdge(6,7 );
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean visited[] = new boolean[8]; 
        g.dfs(2,visited);
        
    }
}
