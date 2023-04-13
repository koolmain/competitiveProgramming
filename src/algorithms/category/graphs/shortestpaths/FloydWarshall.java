package algorithms.category.graphs.shortestpaths;

//https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/FloydWarshallSolver.java
public class FloydWarshall {

    private int n; 
    private boolean solved; 
    private double[][] dp; 
    private Integer[][] next; 

    private static final int REACHES_NEGATIVE_CYCLE = -1; 

    public FloydWarshall(double[][] matrix){
        n = matrix.length; 
        dp = new double[n][n]; 
        next = new Integer[n][n]; 

        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(matrix[i][j] != Double.POSITIVE_INFINITY) 
                    next[i][j] = j; 
            }
        }
    }


    void floydWarshall(){
        
    }

}
