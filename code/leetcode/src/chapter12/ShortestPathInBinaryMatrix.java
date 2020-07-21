package chapter12;

import java.util.*;

class ShortestPathInBinaryMatrix {
    // A*搜索
    //图解: https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python
    private static class Node implements Comparable<Node> {
        // coordinate
        private int x;
        private int y;
        
        // g(node) is the cost of the path from the start node to node
        private int g;
        // f(node) = g(node) + h(node)
        private int f;
        
        private Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.f = g + h;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }
    }
    
    // eight directions sorted in clockwise order
    private static int[][] DIRECTIONS = new int[][]{{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
    
    public int shortestPathBinaryMatrix1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int endX = m - 1, endY = n - 1;
        
        if (grid[endX][endY] == 1) return -1; // early exit
        
        // Initialize the open list -> which node we expand next?
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        // Initialize the closed list -> which nodes we've already visited? What is the minimum g from start node to this?
        int[] closed = new int[m * n];
        Arrays.fill(closed, Integer.MAX_VALUE);
        
        // put the starting node on the open list
        pq.add(new Node(0, 0, 1, Math.max(m, n)));
        
        // while the open list is not empty
        while (!pq.isEmpty()) {
            
            // retrive the node with the least f on the open list, call it "node"
            Node node = pq.remove();
            
            int x = node.x;
            int y = node.y;
            
            // skip disallowed area
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) continue;
            
            // if node is the goal, stop search
            if (x == endX && y == endY) return node.g;
            
            // if a node with the same position is in the closed list
            // which has a lower or equals g than this, skip this expansion
            if (closed[x * m + y] <= node.g) continue;
            
            // push node on the closed list
            closed[x * m + y] = node.g;
            
            // generate 8 successors to node
            for (int[] dir : DIRECTIONS) {
                // for each successor
                // successor.g = node.g + distance between successor and node (equals to 1)
                // successor.h = estimate distance from successor to goal
                int g = node.g + 1;
                
                // h(node) is a heuristic function that 
                // estimates the cost of the cheapest path from node to the goal
                
                // Here we use **Diagonal Distance** as heuristic function, 
                // because we can and only can move in eight directions
                int h = Math.max(Math.abs(endX - x), Math.abs(endY - y));
                
                // push the successor on the open list
                pq.add(new Node(x + dir[0], y + dir[1], g, h));
            }
        }
        
        return -1;
    }

    //BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0, 1});
        grid[0][0]=2;
        int[][] dirs={{1,0},{1,-1},{1,1},{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}};
        int N=grid.length;
        while(!q.isEmpty()) {
            int[] cur=q.poll();
            if(cur[0]==N*N-1) return cur[1];
            for(int i=0;i<8;i++) {
                int nx=cur[0]/N+dirs[i][0], ny=cur[0]%N+dirs[i][1];
                if(nx<0||nx>=N||ny<0||ny>=N||grid[nx][ny]!=0) continue;
                q.offer(new int[]{nx*N+ny, cur[1]+1});
                grid[nx][ny]=2;
            }
        }
        return -1;
    }
    
}