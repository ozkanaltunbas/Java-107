import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    int rowNumber; //kullanıcıdan satır aldım
    int colNumber; //kullanıcıdan sütun aldım
    int[][] map;   // mayınların tutulduğu harita
    int[][] board; // kullanıcının göreceği harita.
    int size;
    boolean game = true;

    Random rand = new Random(); // mayın için random sayılar aldım.
    Scanner scan = new Scanner(System.in);
    Minesweeper(int rowNumber, int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber*colNumber;
    }
    public void run(){
        int row,col,checkWin=0;
        prepareGame();
        print(map);
        System.out.println("====GAME STARTED!=====");
        while (game){
            print(board);
            System.out.print("Enter a row : ");
            row=scan.nextInt();
            System.out.print("Enter a column : ");
            col= scan.nextInt();
            if(row<0 ||row>rowNumber){
                System.out.println("Unvalid number ! ");
                continue;
            }
            if(col<0 ||col>colNumber){
                System.out.println("Unvalid number ! ");
                continue;
            }


            if(map[row][col]!=-1){
                check(row,col);
                checkWin++;
                if(checkWin==size-(size/4)){
                    System.out.println("Congratulations  you won ! ");
                    break;
                }
            }else{
                System.out.println("Game over ! ");
                break;
            }
            System.out.println(checkWin);

        }

    }
    public void check(int r,int c){
        if(map[r][c]==0){ // board o notka da oynama yok ise kod çalışsın.
            if((c<colNumber-1)&&(map[r][c+1]==-1)){ // max değerler --> mapin uç noktaları kontrolü
                board[r][c]++;
            }
            if((r<rowNumber-1)&&(map[r+1][c]==-1)){ //max değerler
                board[r][c]++;
            }
            if((r>0)&&(map[r-1][c]==-1)){
                board[r][c]++;
            }
            if((c>0)&&(map[r][c-1]==-1)){
                board[r][c]++;
            }
            if(board[r][c]==0){
                board[r][c]=-2;
            }

        }



    }
    public void prepareGame(){ //burda mayınları yerleştirdik.
        int randRow,randCol,count=0;   //rastgale oluşturulan colon ve satırlar.
        while(count!=(size/4)){          //count amacı döngü boyunca random sayı üretmesini sağlamak
            randRow=rand.nextInt(rowNumber);
            randCol=rand.nextInt(colNumber);
            if(map[randRow][randCol]!=-1){  // bomba olacak yerlerde -1 yoksa -1 yaz (bomba oalcak yerlerede -1 yazacak)
                map[randRow][randCol]=-1;
                count++;
            }


        }

    }


    public void print(int[][] arr){
        for(int i =0;i< arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j]>=0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}



