import java.util.Scanner;
public class tictactoe{
    void draw(int [][] player){
        System.out.println();
        System.out.println();
        int count=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(player[i][j]==0){
                    System.out.print("  ");
                }
                if(player[i][j]==1){
                    System.out.print("  "+"X"+"  ");
                }
                if(player[i][j]==2){
                    System.out.print("  "+"O"+"  ");
                }
                if(player[i][j]==0){
                    System.out.print("   ");
                }
                if(j<2){
                    System.out.print("|");
                }
            }
            System.out.println("");
            if(i<2){
                for(int j=0;j<10;j++){
                    System.out.print("__");
                }
                System.out.println("");
            }
        }
        System.out.println();
        System.out.println();
        
    }

    boolean isXwin(int xwin[]){
        if(xwin[0]==1 && xwin[1]==1 && xwin[2]==1 || xwin[3]==1 && xwin[4]==1 && xwin[5]==1 || xwin[6]==1 && xwin[7]==1 && xwin[8]==1){
            return true;
        }

        return false;
    }

    boolean isOwin(int owin[]){
        if(owin[0]==1 && owin[1]==1 && owin[2]==1 || owin[3]==1 && owin[4]==1 && owin[5]==1 || owin[6]==1 && owin[7]==1 && owin[8]==1){
            return true;
        }

        return false;
    }

    void print(int xwin[]){
        for(int i=0;i<9;i++){
            System.out.print(xwin[i]+" ");
        }
        System.out.println();
    }


    public static void main(String [] args){
        tictactoe tic=new tictactoe();
        int [][] player={{0,0,0},{0,0,0},{0,0,0}};
        int xwin[]={0,0,0,0,0,0,0,0,0};
        int owin[]={0,0,0,0,0,0,0,0,0};
        int x=-1,y=-1;
        boolean will=true,isXterm=true;
        tic.draw(player);
        Scanner sc=new Scanner(System.in);
        int count=0;
        
        
        
        while(will){
            System.out.println("Enter the position of your move in term of x,y   ");
            x=sc.nextInt();
            y=sc.nextInt();
            if(isXterm==true){
                player[x-1][y-1]=1;
                xwin[count++]=1;
                isXterm=false;
            }
            else{
                player[x-1][y-1]=2;
                isXterm=true;
                owin[count++]=1;
            }
            tic.draw(player);
            if(tic.isXwin(xwin)){
                System.out.println("X win ");
                will=false;
            }
            if(tic.isOwin(owin)){
                System.out.println("O win ");
                will=false;    
            }
            tic.print(xwin);
        }

    }
}