package algorithms.category.graphs.minspanningtree;

import java.util.List;

public class KruskalsMST {

    static class Edge {
        int src, dest, weight; 
        
        public Edge(int src,int  dest, int weight){
            this.src = src; 
            this.dest = dest; 
            this.weight = weight; 
        }
    }

    static class Subset {
        int parent, rank ; 

        public Subset(int parent, int rank){
            this.parent = parent; 
            this.rank = rank; 
        }
    }

    private static void kruskals(int V, List<Edge> edges){
        
    }

    private static void union(Subset[] subsets, int x, int y){
        int rootX = findRoot(subsets, x); 
        int rootY = findRoot(subsets, y); 

        if(subsets[rootY].rank < subsets[rootX].rank){
            subsets[rootY].parent = rootX; 
        } else if (subsets[rootX].rank < subsets[rootY].rank){
            subsets[rootX].parent = rootY ; 
        } else {
            subsets[rootY].parent = rootX; 
            subsets[rootX].rank++; 
        }
    }

    private static int findRoot(Subset[] subsets, int i ){
        if(subsets[i].parent == i)
            return subsets[i].parent; 

        subsets[i].parent = findRoot(subsets, subsets[i].parent); 
        return subsets[i].parent; 
    }
    
}
