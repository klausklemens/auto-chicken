import java.util.Scanner;

public class Emoji {
  public static int delta (int state, char c){
    switch (state) {
      case  0: 
        switch (c) {  
          case  ':': state = 1; break;
          default: state = 0;
        }
        break;
      case  1: 
        switch (c) {  
          case  '-': state = 2; break;  
          case  ':': state = 1; break;
          default: state = 0;
        }
        break;
      case  2: 
        switch (c) {
          case  '(': state = 4; break;
          case  ')': state = 3; break;
          default: state = 0;
        }
        break;
      case  3: 
        switch (c) {
          default: state = 3;
        }
        break;
      case  4:
        switch (c) {
          default: state = 4;
        }
        break;
      default: state = -1;
    }
    return state;
  }
  
  public static void main(String[] args) {
    while (true) {
      System.out.print("> ");
      
      Scanner sc = new Scanner(System.in);
      String eingabe;
      
      int laenge;
      eingabe = sc.nextLine();
      laenge = eingabe.length();
      
      int zustand = 0;
      for (int i=0; i<laenge; i++ ) { 
        zustand = delta(zustand, eingabe.charAt(i));
      }
      
      switch (zustand) {
        case  3: 
              System.out.println(">> "+(char) 1);
              break;
        case  4: 
              System.out.println(">> "+ (char) 7 +(char) 3);
              break;
        default: 
              System.out.println(">> Wat?");
      }
    }
  }
}