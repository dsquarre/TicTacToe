import java.io.*;
import java.util.*;
public class TicTacToe 
 {
 int pos,movecount;
 String[] grid= new String[9]; 
 String player,computer;
 
 
 public TicTacToe(){
   for (int i=0;i<9;i++){
     grid[i]=" ";
   }
   computer="X";player="O";
   pos=0;movecount=0;
 }
 
 
 
   public void displayGrid(){
     int h=0;
     for(int i=0;i<3;i++){
       System.out.print(" ");
       for(int j=0;j<3;j++){
     System.out.print(grid[h]);
     h++;if(j<2){System.out.print(" | ");}
     }
     if(i<2){
     System.out.print("\n------------\n");}
     }System.out.println("\n\n");
     }   
     
     
     
    void playermove(String player){
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     try{ while(true){
    System.out.print("Enter position >");
    pos=Integer.parseInt(br.readLine());
    System.out.print("\n");
    if((pos>9)||(pos<1)){System.out.print("enter only 1-9\n");}
    else if(grid[pos-1].equals(" ")){
           grid[pos-1]=player;break;
    }
    else{System.out.print("position already taken\n");}
    }}
    catch (IOException e) {
      System.out.println(e);
    }
    catch (NumberFormatException e) {
      System.out.println("enter only numbers");
    playermove(player);
    }}
    
    
    
    boolean won(String ch){
     for(int i=0;i<7;i+=3){
         if((grid[i].equals(grid[i+1]))&&(grid[i+1].equals(grid[i+2]))){
           if(grid[i].equals(ch))
           {
            return true;
           }
           }}
     for(int i=0;i<3;i++){
         if((grid[i].equals(grid[i+3]))&&(grid[i+3].equals(grid[i+6]))){
           if(grid[i].equals(ch))
           {
            return true;
           }
           }}
     if((grid[0].equals(grid[4]))&&(grid[4].equals(grid[8]))){
           if(grid[4].equals(ch))
           {
            return true;
           }       }
     if((grid[2].equals(grid[4]))&&(grid[4].equals(grid[6]))){
           if(grid[4].equals(ch))
           {
            return true;
           }        }
     return false;
             }

  
  
  
 double largest(double[] a){
   double large=a[0];
    for (byte i=0; i<9;i++){
      if(a[i]>large){
        large=a[i];
      }
        }
    return large;
      }
boolean isFilled(double arr[]){
   for(int i=0;i<9;i++){
     if(arr[i]!= -1){return false;}
   }
   return true;
 } 
  
 
    double evaluate(double[] winval){
    for(int i=0;i<9;i++){    
      if(winval[i]==1){return 0;}
     }

     for(int i=0;i<9;i++){   
        if(winval[i]==0.5){return 0.5;}
   }
     
        return 1;
    }
     
   
     
             
   void  computerMove()  {
          double[] winval=simulate(true);
            double val=largest(winval);
    while (true){
          byte y=(byte)(Math.random()*9);
           if(winval[y]==val){pos=y;break;}
        }
         grid[pos]=computer;
          }     
     
  
  
  
  
           
   double[] simulate(boolean Val){
    String mover="";
     if(Val){mover=computer;}
    else{mover= player;}
    
       double[] value= new double[9];
      for(int i=0;i<9;i++){
      
          if(!grid[i].equals(" ")){ 
          value[i]=-1.00;
         }
        else {
           grid[i]=mover;
          if(won(mover)){
             value[i]=1.00;
          }
           else if(isFilled()){value[i]=0.5;}
          else{
             value[i]=evaluate(simulate(!Val));
          }
           grid[i]=" ";
        }
       }
       return value;
    }    
    
    
       
      boolean isFilled(){
       for(int i=0;i<9;i++){
          if(grid[i].equals(" ")) return false;
       }
        return true;
     }      
     
      void GamePlay(int GameType){
       boolean not_won=true;
   
    System.out.print("Enter what you want to play O or X?>");
 try{
  player=new Scanner(System.in).nextLine().toUpperCase();
}
  catch(Exception E){ System.out.print(E);}
  if((player.equals("O"))
(player.equals("X"))) {}
  else{System.out.print("enter only O or X\n"); GamePlay(GameType);}
  movecount=0;
  if(player.equals("X")){
    computer="O";
   computerMove();
    displayGrid();
    movecount++;}

  while(movecount<9){

  
   playermove(player);
  if(won(player)){
    displayGrid();
    System.out.println("You \t\tWON!!");
    not_won=false;break;}
  movecount++;
  displayGrid();
  if(movecount==9){not_won=true;break;}
  
  if(GameType==1){ 
 computerMove();
 }
 
 else{playermove(computer);}
 
  if(won(computer)){
    displayGrid();
    System.out.println(computer+"\t\tWON!!");
    not_won=false;break;}
  movecount++;
  displayGrid(); 
  
  
    } 
    
    if(not_won){
  System.out.print("\nITS A DRAW!!\n");}
  
  System.out.print("want to play again?(press enter)>");
  if(new Scanner(System.in).nextLine().equals("")){
   TicTacToe.main(new String[0]);
   
    }
  else{ 
  System.out.println("Game Over !!");
  }
     }
     
   public static void main(String args[])
   { 
   TicTacToe obj =new TicTacToe();
    obj.displayGrid();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("\n\n*enter only numbers to fill positions**\n\n\n{O plays first}");
   System.out.println("1 : One player \n2 : Two player\nEnter >");
     int gameType=0;
   do{  try{
 gameType=Integer.parseInt(br.readLine());
  }
  catch (IOException E) {
    System.out.println(E);
  }
  catch (NumberFormatException e) {
   System.out.println("enter only numbers");
    } }while((gameType<1)||(gameType>2));
    obj.GamePlay( gameType);
}}
