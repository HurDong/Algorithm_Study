import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // 우, 하만 가능
        int[][] dp = new int[n][m];
        for(int[] puddle : puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }
        dp[0][0] = 1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(dp[i][j]==-1){
                    continue;
                }
                // 오른쪽으로 이동
                if(j>0 && dp[i][j-1]!=-1){
                    dp[i][j]+=dp[i][j-1]%1000000007;
                }
                // 아래쪽으로 이동
                if(i>0 && dp[i-1][j]!=-1){
                    dp[i][j] +=dp[i-1][j]%1000000007;
                }
            }
        }
        return dp[n-1][m-1]%1000000007;
    }
}