import java.util.Scanner;

public class main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int knightPos[] = {0, 0};
        int GoalPos[] = {0, 0};
        int[][] obstacles;

        int num = 0;

        String[] temp;
        System.out.println("Please Enter position of knight: \n" +
                "Example X Y");
        temp = sc.nextLine().split(" ");

        while (Integer.valueOf(temp[0]) > 7 || Integer.valueOf(temp[1]) > 7
                || Integer.valueOf(temp[0]) < 0 || Integer.valueOf(temp[1]) < 0) {
            System.out.println("Invalid Input in the Position of the Knight");
            System.out.println("Please Enter position of knight: \n" +
                    "Example X Y");
            temp = sc.nextLine().split(" ");
        }

        knightPos[0] = Integer.valueOf(temp[0]);
        knightPos[1] = Integer.valueOf(temp[1]);


        System.out.println("Please Enter position of Goal: \n" +
                "Example X Y");
        temp = sc.nextLine().split(" ");

        while (Integer.valueOf(temp[0]) > 7 || Integer.valueOf(temp[1]) > 7
                || Integer.valueOf(temp[0]) < 0 || Integer.valueOf(temp[1]) < 0) {
            System.out.println("Invalid Input in the Position of the Goal Title");
            System.out.println("Please Enter position of Goal: \n" +
                    "Example X Y");
            temp = sc.nextLine().split(" ");
        }

        GoalPos[0] = Integer.valueOf(temp[0]);
        GoalPos[1] = Integer.valueOf(temp[1]);

        System.out.print("Please Enter how many obstacles: ");
        num = Integer.valueOf(sc.nextLine());

        obstacles = new int[num][2];


        for (int i = 0; i < num; i++) {

            System.out.println("Please Enter where is the obstacle number " + (i + 1) +
                    "\nExample X Y");

            temp = sc.nextLine().split(" ");

            while (Integer.valueOf(temp[0]) > 7 || Integer.valueOf(temp[1]) > 7
                    || Integer.valueOf(temp[0]) < 0 || Integer.valueOf(temp[1]) < 0) {
                System.out.println("Invalid Input in the Position of the Obstacle number " + (i + 1));
                System.out.println("Please Enter where is the obstacle number " + (i + 1) +
                        "\nExample X Y");
                temp = sc.nextLine().split(" ");
            }

            obstacles[i][0] = Integer.valueOf(temp[0]);
            obstacles[i][1] = Integer.valueOf(temp[1]);
        }

        board b = new board(8, knightPos, GoalPos, obstacles);
        b.initalizeBoard();
        System.out.println(b.full[1][5]);
        b.reachGoal();

    }
}
