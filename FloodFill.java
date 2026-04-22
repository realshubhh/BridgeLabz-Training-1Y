// LeetCode #733 - Flood Fill
// Perform a flood fill on an image starting from pixel (sr, sc).
// Time: O(m*n), Space: O(m*n)

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != original) return;
        image[r][c] = newColor;
        dfs(image, r+1, c, original, newColor);
        dfs(image, r-1, c, original, newColor);
        dfs(image, r, c+1, original, newColor);
        dfs(image, r, c-1, original, newColor);
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();

        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] result1 = sol.floodFill(image1, 1, 1, 2);
        for (int[] row : result1) System.out.println(Arrays.toString(row));
        // [2,2,2], [2,2,0], [2,0,1]

        System.out.println();
        int[][] image2 = {{0,0,0},{0,0,0}};
        int[][] result2 = sol.floodFill(image2, 0, 0, 0);
        for (int[] row : result2) System.out.println(Arrays.toString(row));
        // [[0,0,0],[0,0,0]] - same color, no change
    }
}
