class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        // don't need to initialize all values to false with for loop since they start false by default in Java

        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (
                    ((i + word.length()) <= s.length()) &&
                    (s.substring(i, i + word.length()).startsWith(word))
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
