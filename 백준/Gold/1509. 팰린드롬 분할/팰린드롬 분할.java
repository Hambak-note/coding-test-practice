import java.io.*;

public class Main {

	static boolean[][] palindrome;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int len = str.length();
		palindrome = new boolean[len + 1][len + 1];
		dp = new int[len + 1];

		for (int i = 1; i <= len; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		checkPalindrome(str, len); // 팰린드롬을 먼저 찾는다.

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if (palindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}

		bw.write(dp[len] + "\n");
		bw.flush();

	}

	public static void checkPalindrome(String str, int len) {

		for (int start = 1; start <= len; start++) {
			for (int end = start; end <= len; end++) {
				boolean flag = true;

				int s = start - 1;
				int e = end - 1;
				while (s <= e) {
					if (str.charAt(s++) != str.charAt(e--)) {
						flag = false;
						break;
					}
				}
				if (flag)
					palindrome[start][end] = true;
			}
		}
	}

}
