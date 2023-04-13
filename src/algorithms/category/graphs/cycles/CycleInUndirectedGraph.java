package algorithms.category.graphs.cycles;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {
        LinkedList adj[];
        int V;
        private Iterator<Integer> itr;  

        CycleInUndirectedGraph(int v){
            this.V = v; 
            adj = new LinkedList[v]; 
            for(int i=0;i< v; i++){
                adj[i] = new LinkedList<>(); 
            }
        }

        void addEdge(int u, int v){
            adj[u].add(v); 
            //adj[v].add(u); 
        }

        public boolean hasCycles(){
            DisjointSet ds = new DisjointSet(); 
            for(int i=0;i<V;i++){
                ds.makeSet(i);
            }

            for(int i=0;i<V;i++){
                itr = adj[i].listIterator(); 
                long parent = ds.findSet(i); 
                while(itr.hasNext()){
                    int otherNode = itr.next(); 
                    long parent2 = ds.findSet(otherNode); 
                    if(parent == parent2){
                        return true; 
                    }

                    ds.union(i, otherNode); 
                }
            }

            return false; 
        }

        public static void main(String args[]){
            CycleInUndirectedGraph c = new CycleInUndirectedGraph(6); 
            c.addEdge(0, 1);
            c.addEdge(1, 2);
            c.addEdge(0, 3);
            c.addEdge(3, 4);
            c.addEdge(4, 5);
           // c.addEdge(5, 1);

            System.out.println("Is there any cycle in the given graph "+ c.hasCycles());
        }
}
