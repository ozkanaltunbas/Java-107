import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row,column;
        System.out.println("Welcome to Mine Swepeer game ! ");
        System.out.println("Please Enter a Row and Column size ! ");
        System.out.print("Enter a Row size : ");
        row = scan.nextInt();
        System.out.print("Enter a column size : ");
        column = scan.nextInt();
        Minesweeper mayin = new Minesweeper(row,column);
        mayin.run();

    }
}