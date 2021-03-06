package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491_수열_박기윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[3][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}

		dp[1][0] = 1;
		dp[2][0] = 1;
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < N; j++) {
				if (i == 1) {
					if (dp[0][j - 1] <= dp[0][j]) {
						dp[i][j] = dp[i][j - 1] + 1;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (dp[0][j - 1] >= dp[0][j]) {
						dp[i][j] = dp[i][j - 1] + 1;
					} else {
						dp[i][j] = 1;
					}
				}
			}
		}
		Arrays.sort(dp[1]);
		Arrays.sort(dp[2]);
		bw.write(Integer.toString(Math.max(dp[1][N - 1], dp[2][N - 1])));

		br.close();
		bw.flush();
		bw.close();
	}

}
