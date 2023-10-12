class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
    	int n = sequence.length;
        int len = n;
    	int left = 0;
    	int sum = 0;
    	
    	for(int right=0; right<n; right++) {    		
    		sum += sequence[right];
        
            while(sum > k) {
    			sum -= sequence[left];
    			left++;
    		}
    		    		
    		if(sum == k) {
    			if(len > right-left) {
    				len = right-left;
    				answer[0] = left;
    				answer[1] = right;
    			}
    		}
    	
    	}
    	
    	return answer;
    }
}