package algorithms.gameTheory;

//https://leetcode.com/problems/can-i-win/solutions/230432/c-12-ms-98-solution-with-detailed-explanation/

/*
This question took me a while because this is the first game-type question I have seen so far. I wasted a lot of time trying to figure out the "optimal" policy for moves, but of course it doesn't exist. The part of the prompt stating that "assuming opponent moves optimally" was very misleading.

Later, I realized that the only way to find the "optimal" strategy is to brute-force every single possible game state. If I can find a set of moves that, regardless of what the opponent does, will lead to winning, then I am guaranteed a win. This can be done using a DFS search.

The game state is essentially the set of number of unique numbers between 1 and maxChoose that has already been chosen. This can be encoded using 21 bits. Each time a number is chosen, we can set that bit. To make things easier, we will simply use an int to encode the state, since int has 32 bits, which is more than enough.

To do the dfs, we start from a state, and then proceed to check for a free number (a bit in the state which is a 0). Then, we set that bit to a 1, and then proceed to search further in that new state. We do this for all free bits in the state.

To set a bit i, we can do state | (1 << i). To check a bit, we can do state & (1 << i).

The dfs logic is also a bit tricky, because we have two players. Initially I thought I need to simulate the game with each player taking turns, but later figured out that is not necessary, because any given state must belong to a single player, because each player is forced to pick a number. Thus there is no ambiguity.

Furthermore, because the prompt requires guaranteed win, we define true for a state when the player of this state is guaranteed a path to win, and false when the player is not. false doesn't mean that the player cannot win, but rather he 'might' not win.

Because the players are alternating, it means that if a dfs from the next state returns true, it means that the next player is guaranteed to win, should he pick the move to go to that state. If that happens, it means that this current state is a false state. This is because if the opponent plays optimally, then once we arrive at this state, he will make the move to pick that true state. This also means that if every single dfs from this state returns false, then it means no matter what move the next player chooses, he 'might' not win, implying that there is a way for us to win. This makes the current state true.

We also need to be careful about our interpretation of the dfs results. Because we start the search with an empty state, it means that the search will return false if any of the next states, which are first moves, and thus player 1 states, returns true. If all next states return false, then it will return true. Thus, the dfs is actually returning whether player 2 can win ( ! ). To get the result for player 1, we must negate the dfs result. This works because this game is a zero sum game, so if player 1 wins then player 2 must lose, and vice versa.

Now that the dfs logic is sorted out, we find out that the search time is TLE. As a result, we must use memoization to store already traversed states to save time. This can be done by saving two bitfields.

The first bitfield, visited, stores whether a state has been visited before. The second, cache, stores the results for each state. This means for each new state, we first check if that state has already been visited. If it has, then we base our next steps on the cache of that new state, and proceed. If the state has not been visited, then the cache of the new state is currently invalid, so we must do a dfs, and proceed based on results from the dfs. Once we figure out if a state is true or false, we can simply save that to cache, and mark it as true in visited.

The space requirement is quite substantial, at 2^22 bits. This is essentially O(2^N) space, where N is maxChoose. The run time is also O(2^N), since we need to visit all the states.

 */


 //https://leetcode.com/problems/can-i-win/solutions/95320/clean-c-beat-98-4-dfs-with-early-termination-check-detailed-explanation/

 
/*
 * For short notation, let M = maxChoosableInteger and T = desiredTotal.

Key Observation: the state of the game is completely determined by currently available numbers to pick in the common pool.

State of Game: initially, we have all M numbers [1, M] available in the pool. Each number may or may not be picked at a state of the game later on, so we have maximum 2^M different states. Note that M <= 20, so int range is enough to cover it. For memorization, we define int k as the key for a game state, where

the i-th bit of k, i.e., k&(1<<i) represents the availability of number i+1 (1: picked; 0: not picked).
At state k, the current player could pick any unpicked number from the pool, so state k can only go to one of the valid next states k':

if i-th bit of k is 0, set it to be 1, i.e., next state k' = k|(1<<i).
Recursion: apparently

the current player can win at state k iff opponent can't win at some valid next state k'.
Memorization: to speed up the recursion, we can use a vector<int> m of size 2^M to memorize calculated results m[k] for state key k:

0 : not calculated yet;
1 : current player can win;
-1: current player can't win.
Initial State Check:
There are several checks to be done at initial state k = 0 for early termination so we won't waste our time for DFS process:

if T < 2, obviously, the first player wins by simply picking 1.
if the sum of entire pool S = M*(M+1)/2 is less than T, of course, nobody can reach T.
if the sum S == T, the order to pick numbers from the pool is irrelevant. Whoever picks the last will reach T. So the first player can win iff M is odd.
 */
public class CanIWin {
    
    bool canIWin(int M, int T) 
    {
      int sum = M*(M+1)/2; // sum of entire choosable pool
  
      // I just pick 1 to win
      if (T < 2) return true;
      
      // Total is too large, nobody can win
      else if (sum < T) return false;
      
      // Total happens to match sum, whoever picks at odd times wins
      else if (sum == T) return M%2;
      
      // Non-trivial case: do DFS
      // Initial total: T
      // Initial game state: k = 0 (all numbers are not picked)
      else return dfs(M, T, 0);
    }
  
    // DFS to check if I can win
    // k: current game state
    // T: remaining total to reach
    bool dfs(int M, int T, int k) 
    {
      // memorized
      if (mem[k] != 0) return mem[k] > 0;
      
      // total is already reached by opponent, so I lose
      if (T <= 0) return false;
  
      // try all currently available numbers
      for (int i = 0; i < M; ++i)
        // if (i+1) is available to pick and my opponent can't win after I picked, I win!
        if (!(k&(1<<i)) && !dfs(M, T-i-1, k|(1<<i))) {
          mem[k] = 1;
          return true;
        } 
      
      // Otherwise, I will lose
      mem[k] = -1;
      return false;      
    }
  
    // m[key]: memorized game result when pool state = key
    // 0: un-computed; 1: I win; -1: I lose
    int mem[1<<20] = {}; 
}
