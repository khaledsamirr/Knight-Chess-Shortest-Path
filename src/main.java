public class main {

    public static void main (String args[]){
        int knightPos[] = { 0, 0 };
        int GoalPos[] = { 6, 6 };
        int[][] obstacles={{1,4} , {2,2}, {6,2}, {4,4},{5,1},{3,7}};
        board b=new board(8,knightPos,GoalPos,obstacles);
        b.initalizeBoard();
        System.out.println(b.full[1][5]);
        b.reachGoal();

    }
}
