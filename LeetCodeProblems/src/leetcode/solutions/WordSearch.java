package leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WordSearch implements ISolution {

	
	/** NOT Ideal solution since we need 2 stack two store solutions (int[][] and the string solution)
    public boolean exist(char[][] board, String word) {
    	
    	//Initialize, create stack and find starting point
    	
    	Deque<int[][]> stack = new ArrayDeque<int[][]>();
    	char[] words = word.toCharArray();
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if (board[i][j] == words[0]){
    				int[][] node = {{i,j}};
    				stack.push(node);
    			}
    			visited[i][j] = false;
    		}
    	}
    	
    	return DFS(board, visited, stack, words, "");
        
    }
    
    public boolean DFS(char[][] board, boolean[][] visited, Deque<int[][]> stack, char[] words, String solution){
    	if (stack.isEmpty())
    		return false;
    	
    	int[][] current = stack.pop();
    	StringBuilder sol = new StringBuilder(solution);
    	
    	int i = current[0][0];
    	int j = current[0][1];

    	int curIndex = solution.length();
    	visited[i][j] = true;
    	
    	if (sol.toString().equals(String.valueOf(words)))
    		return true;
    	
    	boolean hasNextSolution = false;
    	if (board[i][j] == words[curIndex]){
        	//find neighboring solutions
        	sol.append(board[i][j]);
        	if (i > 0){
        		if (board[i-1][j] == words[curIndex + 1] && !visited[i-1][j]){
        			hasNextSolution = true;
        			int[][] upNode = {{i-1, j}};
        			stack.push(upNode);
        		}
        	}
        	if (i < board.length-1){
        		if (board[i+1][j] == words[curIndex + 1] && !visited[i+1][j]){
        			hasNextSolution = true;
        			int[][] downNode = {{i+1, j}};
        			stack.push(downNode);
        		}
        		
        	}
        	if (j > 0){
        		if (board[i][j-1] == words[curIndex + 1] && !visited[i][j-1]){
        			hasNextSolution = true;
        			int[][] leftNode = {{i, j-1}};
        			stack.push(leftNode);
        		}
        		
        	}
        	if (j < board[0].length -1){
        		if (board[i][j+1] == words[curIndex + 1] && !visited[i][j+1]){
        			hasNextSolution = true;
        			int[][] rightNode = {{i, j+1}};
        			stack.push(rightNode);
        		}
        	}
    	}

    	
    	if (!hasNextSolution){
    		sol.deleteCharAt(sol.length()-1);
    		visited[i][j] = false;
    	}
    	
    	return DFS(board, visited, stack, words, sol.toString());
    	
    	
    }
    **/
	
	/**
	 * 
	 * - recursion no DFS
	 * - return true when whole word is found
	 * - return false otherwise
	 * - do the same for all the neighbours (up, down, left and right) nodes
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist (char[][] board, String word){
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++){
			for (int j=0; j<board[i].length; j++){
				if (board[i][j] == word.charAt(0) && exist(board, visited, i, j, word, 0))
					return true;
			}
		}
		return false;
		
	}
	
	public boolean exist(char[][]board, boolean[][] visited, int i, int j, String word, int currentIndex){
		
		//return false if hit boundaries
		if (i < 0 || j < 0 || i == board.length || j == board[0].length || currentIndex == word.length())
			return false;
		//stop condition return false
		if (!visited[i][j] && board[i][j] != word.charAt(currentIndex))
			return false;
		
		if (!visited[i][j] && board[i][j] == word.charAt(currentIndex)){
			
			String solution = word.substring(0, currentIndex+1);
			//stop condition return true
			if (word.length()-1 == currentIndex)
				return true;
			visited[i][j] = true;
			boolean exist = exist(board, visited, i+1, j, word, currentIndex + 1) || exist(board, visited, i-1, j, word, currentIndex + 1) ||
							exist(board, visited, i, j+1, word, currentIndex + 1) || exist(board, visited, i, j-1, word, currentIndex + 1);
			visited[i][j] = false;
			if (exist)
				return true;
		}
		return false;
		
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		char[][] board = {{'b','b','a','a','b','a'}, {'b','b','a','b','a','a'}, {'b','b','b','b','b','b'}, 
						  {'a','a','a','b','a','a'}, {'a','b','a','a','b','b'}};
		char[][] board2 = {{'f','y','c','e','n','r','d'}, {'k','l','n','f','i','n','u'}, {'a','a','a','r','a','h','r'}, 
				  {'n','d','k','l','p','n','e'}, {'a','l','a','n','s','a','p'}, {'o','o','g','o','t','p','n'},
				  {'h','p','o','l','a','n','o'}};
		System.out.println(exist(board2, "poland"));
		
	}

	
	
}
