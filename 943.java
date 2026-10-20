class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int k = Math.min(words[i].length(), words[j].length());

                while (k > 0 &&
                       !words[i].endsWith(words[j].substring(0, k))) {
                    k--;
                }

                overlap[i][j] = k;
            }
        }

        int total = 1 << n;
        int[][] dp = new int[total][n];
        int[][] parent = new int[total][n];

        for (int i = 0; i < total; i++) {
            java.util.Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            java.util.Arrays.fill(parent[i], -1);
        }

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i].length();
        }

        for (int mask = 1; mask < total; mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0) continue;

                for (int next = 0; next < n; next++) {
                    if ((mask & (1 << next)) != 0) continue;

                    int newMask = mask | (1 << next);
                    int cost = dp[mask][last]
                            + words[next].length()
                            - overlap[last][next];

                    if (cost < dp[newMask][next]) {
                        dp[newMask][next] = cost;
                        parent[newMask][next] = last;
                    }
                }
            }
        }

        int mask = total - 1;
        int last = 0;

        for (int i = 1; i < n; i++) {
            if (dp[mask][i] < dp[mask][last]) {
                last = i;
            }
        }

        java.util.List<Integer> order = new java.util.ArrayList<>();

        while (last != -1) {
            order.add(last);
            int prev = parent[mask][last];
            mask ^= (1 << last);
            last = prev;
        }

        java.util.Collections.reverse(order);

        StringBuilder result =
                new StringBuilder(words[order.get(0)]);

        for (int i = 1; i < order.size(); i++) {
            int prev = order.get(i - 1);
            int curr = order.get(i);

            result.append(
                words[curr].substring(overlap[prev][curr])
            );
        }

        return result.toString();
    }
}