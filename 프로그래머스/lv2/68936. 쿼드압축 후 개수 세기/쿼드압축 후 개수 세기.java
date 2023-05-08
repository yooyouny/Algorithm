class Solution {
    int zeroCnt, oneCnt = 0;
    public void compress(int iStart, int iEnd, int jStart, int jEnd, int[][] arr){

        boolean isSame = true;
        int num = arr[iStart][jStart];

        for (int i = iStart; i < iEnd; i++) {
            for (int j = jStart; j < jEnd; j++) {
                if (num != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if(num == 0)
                zeroCnt++;
            else
                oneCnt++;
            return;
        }
  
        int midI = (iStart + iEnd) / 2;
        int midJ = (jStart + jEnd) / 2;

        compress(iStart, midI, jStart, midJ, arr);
        compress(iStart, midI, midJ, jEnd, arr);
        compress(midI, iEnd, jStart, midJ, arr);
        compress(midI, iEnd, midJ, jEnd, arr);
    }

    public int[] solution(int[][] arr) {
        int n = arr.length;
        int[] answer = new int[2];
        
        compress(0, n, 0, n, arr);
        
        return new int[]{zeroCnt, oneCnt};
    }
}
