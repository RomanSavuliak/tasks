import java.util.Scanner;

public class SnakeGame {
    public static String[][] world;
    public static boolean b;
    public static int snakeX;
    public static int snakeY;
    public static int foodX;
    public static int foodY;
    public static int count;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        world = new String[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = " ";
            }
        }
        count = 5;
        snakeX = rand(0, 4);
        snakeY = rand(0, 9);
        while (count != 0) {
            b = true;
            while (snakeX == foodX && snakeY == foodY){
                randFood();
            }


            world[snakeX][snakeY] = "|";
            world[foodX][foodY] = "o";

            while (b) {
                System.out.println("------------------");
                System.out.println("Point to Eat: " + count);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(world[i][j]);
                    }
                    System.out.println();
                }
                System.out.print("Enter command: ");
                move(sc.nextLine());
            }
        }
    }


    public static int rand(int min, int max){

        return (min + (int)(Math.random() * ((max - min) + 1)));

    }

    public static void randFood(){
        foodX = rand(0, 4);
        foodY = rand(0, 9);

    }

    public static void move(String command){
        String direction;
        int distance;
        if (command.length() > 1){
            direction = command.substring(command.length() -1, command.length());
            distance = Integer.parseInt(command.substring(0, command.length()-1));
            System.out.println(direction);
            System.out.println(distance);
        }
        else {
            direction = command;
            distance = 1;
        }
        switch (direction){
            case "w":
                if (snakeX - distance >= 0){
                    world[snakeX][snakeY] = " ";
                    world[snakeX - distance][snakeY] = "|";
                    snakeX = snakeX - distance;
                    if (snakeX == foodX && snakeY == foodY){
                        world[foodX][foodY] = " ";
                        count--;
                        b = false;

                    }
                }
                break;
            case "s":
                if (snakeX + distance <= 4){
                    world[snakeX][snakeY] = " ";
                    world[snakeX + distance][snakeY] = "|";
                    snakeX = snakeX + distance;
                    if (snakeX == foodX && snakeY == foodY){
                        world[foodX][foodY] = " ";
                        count--;
                        b = false;
                    }
                }
                break;
            case "a":
                if (snakeY - distance >= 0){
                    world[snakeX][snakeY] = " ";
                    world[snakeX][snakeY - distance] = "|";
                    snakeY = snakeY - distance;
                    if (snakeX == foodX && snakeY == foodY){
                        world[foodX][foodY] = " ";
                        count--;
                        b = false;
                    }
                }
                break;
            case "d":
                if (snakeY + distance <= 9){
                    world[snakeX][snakeY] = " ";
                    world[snakeX][snakeY + distance] = "|";
                    snakeY = snakeY + distance;
                    if (snakeX == foodX && snakeY == foodY){
                        world[foodX][foodY] = " ";
                        count--;
                        b = false;
                    }
                }
                break;
        }

    }
}
