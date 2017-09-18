import java.util.Scanner;

public class Lachautomat {
  public static int delta (int state, char c){
    switch (state) {
      case  0: 
      switch (c) {
        case  'a': 
        state = 3;
        break;
        case  'h': 
        state = 1;
        break;
        default: 
        System.out.println("Fehler: Ungültiges Eingabezeichen!");
        return -2;
      }
      break;
      case  1: 
      switch (c) {
        case  'a': 
        state = 2;
        break;
        case  'h': 
        state = 3;
        break;
        default: 
        System.out.println("Fehler: Ungültiges Eingabezeichen!");
        return -2;
      }
      break;
      case  2:
      switch (c) {
        case  'a': 
        state = 3;
        break;
        case  'h': 
        state = 1; 
        break;
        default: 
        System.out.println("Fehler: Ungültiges Eingabezeichen!");
        return -2;
      }
      break;
      case 3:
      switch (c) {
        case  'a': 
        state = 3;
        break;
        case  'h': 
        state = 3;
        break;
        default: 
        System.out.println("Fehler: Ungültiges Eingabezeichen!");
        return -2;
      } 
      default: 
      return state;
    }
    return state;
  }
  
  public static void main(String[] args) {
    while (true) {
      System.out.println("Lach! :D");
      
      Scanner sc = new Scanner(System.in);
      String eingabe;
      
      int laenge;
      eingabe = sc.nextLine();
      laenge = eingabe.length();
      
      int zustand = 0;
      for (int i=0; i<laenge; i++ ) { 
        zustand = delta(zustand, eingabe.charAt(i));
      }
      
      if (zustand == 2) {
        System.out.println("akzeptiert");
      } else {
        System.out.println("nicht akzeptiert");
      } 
    }
  }
}