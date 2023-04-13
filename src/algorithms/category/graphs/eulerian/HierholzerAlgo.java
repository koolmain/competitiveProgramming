package algorithms.category.graphs.eulerian;

// https://www.geeksforgeeks.org/hierholzers-algorithm-directed-graph/

import java.util.*;
public class HierholzerAlgo {
  public static void PrintCircuit(List<List<Integer> > adj)
  {
 
    // adj represents the adjacency list of
    // the directed graph
    // edge_count represents the number of edges
    // emerging from a vertex
    Map<Integer, Integer> edge_count = new HashMap<Integer, Integer>();
    for (int i = 0; i < adj.size(); i++)
    {
 
      // find the count of edges to keep track
      // of unused edges
      edge_count.put(i, adj.get(i).size());
    }
    if (adj.size() == 0) {
      return; // empty graph
    }
 
    // Maintain a stack to keep vertices
    Stack<Integer> curr_path = new Stack<Integer>();
 
    // vector to store final circuit
    List<Integer> circuit = new ArrayList<Integer>();
 
    // start from any vertex
    curr_path.push(0);
    int curr_v = 0; // Current vertex
    while (curr_path.size() != 0) {
 
      // If there's remaining edge
      if (edge_count.get(curr_v) != 0) {
 
        // Push the vertex
        curr_path.push(curr_v);
 
        // Find the next vertex using an edge
        int next_v = adj.get(curr_v).get(
          adj.get(curr_v).size() - 1);
 
        // and remove that edge
        edge_count.put(curr_v,
                       edge_count.get(curr_v) - 1);
        adj.get(curr_v).remove(
          adj.get(curr_v).size() - 1);
 
        // Move to next vertex
        curr_v = next_v;
      }
 
      // back-track to find remaining circuit
      else {
        circuit.add(curr_v);
 
        // Back-tracking
        curr_v = curr_path.pop();
      }
    }
 
    // we've got the circuit, now print it in reverse
    for (int i = circuit.size() - 1; i >= 0; i--) {
      System.out.print(circuit.get(i));
      if (i != 0) {
        System.out.print(" -> ");
      }
    }
  }
 
  // Driver program to check the above function
  public static void main(String[] args)
  {
    List<List<Integer> > adj1
      = new ArrayList<List<Integer> >();
    List<List<Integer> > adj2
      = new ArrayList<List<Integer> >();
 
    // Input Graph 1
    adj1.add(new ArrayList<Integer>());
    adj1.add(new ArrayList<Integer>());
    adj1.add(new ArrayList<Integer>());
 
    // Build the edges
    adj1.get(0).add(1);
    adj1.get(1).add(2);
    adj1.get(2).add(0);
    PrintCircuit(adj1);
    System.out.println();
 
    // Input Graph 2
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.add(new ArrayList<Integer>());
    adj2.get(0).add(1);
    adj2.get(0).add(6);
    adj2.get(1).add(2);
    adj2.get(2).add(0);
    adj2.get(2).add(3);
    adj2.get(3).add(4);
    adj2.get(4).add(2);
    adj2.get(4).add(5);
    adj2.get(5).add(0);
    adj2.get(6).add(4);
    PrintCircuit(adj2);
  }
}