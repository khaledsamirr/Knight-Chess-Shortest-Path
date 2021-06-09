import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class cell {
    int x, y, distance;

    public cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = 0;
    }

    public cell(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.distance = d;
    }
}

public class board {
    int N;
    int[] KnightPos;
    int[] goal;
    int[][] obstacles;
    int[][] board;
    boolean[][] full;
    ArrayList<cell> path = new ArrayList<cell>();
    ArrayList<cell> solution = new ArrayList<cell>();
    ArrayList<cell> cells = new ArrayList<cell>();

    public board(int n, int[] k, int[] g, int[][] o) {
        this.N = n;
        this.KnightPos = k;
        this.goal = g;
        this.obstacles = o;
    }

    public void initalizeBoard() {
        board = new int[N][N];
        full = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                full[i][j] = false;
        }
        int x, y;
        for (int i = 0; i < obstacles.length; i++) {
            x = obstacles[i][0];
            y = obstacles[i][1];
            full[x][y] = true;
        }
        full[KnightPos[0]][KnightPos[1]] = true;
    }

    public boolean isCell(int x, int y) {
        if (x < 0 || y < 0 || x > this.N || y > this.N) {
            return false;
        }
        return true;
    }

    public void reachGoal() {
        int NumOfMoves = 0;
        int KnightX[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int KnightY[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        cell c;
        path.add(new cell(KnightPos[0], KnightPos[1]));
        while (!path.isEmpty()) {
            c = path.get(0);
            path.remove(0);
            if (c.x == goal[0] && c.y == goal[1]) {
                NumOfMoves = c.distance;
                break;
            }
            int x1, y1;
            for (int i = 0; i < KnightX.length; i++) {
                x1 = c.x + KnightX[i];
                y1 = c.y + KnightY[i];

                if (isCell(x1, y1) && !full[x1][y1]) {
                    full[x1][y1] = true;
                    path.add(new cell(x1, y1, c.distance + 1));
                    solution.add(new cell(x1, y1, c.distance + 1));
                }
            }
        }
        int min;
        int minsum;
        cell find = solution.get(0);
        int sum = 0, sum2 = 0;
        for (int i = 1; i <= NumOfMoves; i++) {
            min = (goal[0] - solution.get(0).x) + (goal[1] - solution.get(0).y);
            minsum = Math.abs(solution.get(0).x - solution.get(0).y);
            for (int j = 1; j < solution.size(); j++) {
                if (solution.get(j).distance == i) {
                    sum = (goal[0] - solution.get(j).x) + (goal[1] - solution.get(j).y);
                    sum2 = Math.abs(solution.get(j).x - solution.get(j).y);
                    if (sum <= min && sum2 <= minsum) {
                        min = sum;
                        minsum = sum2;
                        find = solution.get(j);
                    }
                }

            }
            cells.add(find);
        }
        if (NumOfMoves > 0) {
            System.out.println("Number of moves: " + NumOfMoves);
            System.out.println("____________________________________");
            for (int i = 0; i < cells.size(); i++) {
                System.out.println("Move #" + (i + 1) + ": (" + cells.get(i).x + "," + cells.get(i).y + ").");
            }
        } else {
            System.out.println("can't solve");
        }
    }
}