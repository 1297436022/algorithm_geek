package chapter8;

import java.util.Arrays;

class AssignCookies {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] grid, int[] size) {
        //贪心
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
