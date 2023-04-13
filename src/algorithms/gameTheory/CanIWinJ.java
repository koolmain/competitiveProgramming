package algorithms.gameTheory;

import javax.xml.stream.events.StartDocument;

class CanIWinJ {
	int[] m;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger) * maxChoosableInteger / 2;
        if(desiredTotal <= maxChoosableInteger)
        	return true;
        if(sum < desiredTotal)
        	return false;
        if(sum == desiredTotal)
        	return maxChoosableInteger % 2 == 1;
        m = new int[1<<20];
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }
    
    private boolean dfs(int M, int T, int k)
    {
        System.out.println("DFS called with M:"+M+" T:"+T+" k:"+Integer.toBinaryString(k));
    	if(T <= 0 || m[k] != 0)
    		return T > 0 && m[k] > 0;
    		
    	for(int i = 0; i < M; i++)
    	{
    		if ((k&(1<<i)) == 0 && !dfs(M, T-i-1, k|(1<<i)))
    		{
    			m[k] = 1;
                System.out.println("TRUE selected");
    			return true;
    		}
    	}
    	m[k] = -1;
        System.out.println("FALSE selected");
    	return false;
    }

    public static void main(String[] args){
        CanIWinJ caniwin = new CanIWinJ(); 
        if(caniwin.canIWin(5, 10)){
            System.out.println("I CAN WIN ");
        }else {
            System.out.println("I WILL LOOOSE");
        }
    }
}

