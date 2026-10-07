class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];

        for (int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        int max = 0;
        int current = 0;
        int year = 1950;

        for (int i = 0; i < 101; i++) {
            current += population[i];

            if (current > max) {
                max = current;
                year = 1950 + i;
            }
        }

        return year;
    }
}