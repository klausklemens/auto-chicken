import java.util.Scanner;
import java.util.regex.Pattern;

public class Lachautomat {
  public static int delta (int state, char c) {
    switch (state) {
      case 0: // Zustand q0
      switch (c) {
        case 'a': state = -1; break;
        case 'h': state = 1; break;
        default: return -1;
      }
      break;
      case 1: // Zustand q1
      switch (c) {
        case 'a': state = 2; break;
        case 'h': state = -1; break;
        default: return -1;
      }
      break;
      case 2: // Zustand q2
      switch (c) {
        case 'a': state = -1; break;
        case 'h': state = 1; break;
        default: return -1;
      }
      break;
      default: return -1;
    }
    return state;
  }
  
  public static void main(String[] args) {
    while (true) { 
      int zustand = 0; // Startzustand
      
      System.out.print("Gib eine Zeichenkette ein: ");
      Scanner sc = new Scanner(System.in);
      String eingabe;
      int laenge;
      eingabe = sc.nextLine();
      laenge = eingabe.length();
      
      Pattern p = Pattern.compile("h(ah)*a");
      if (!p.matcher(eingabe).matches()) {
        System.out.println("Fehler! Ungültiges Zeichen in der Eingabe! Fehler! Fehler! Fehler! Fehler!");
        continue;
      }
      
      for (int i=0; i<laenge; i++) {
        zustand = delta(zustand, eingabe.charAt(i));
      }
      
      if (zustand == 2) {
        System.out.println("Der Automat hat das Eingabewort akzeptiert!");
      } else {
        System.out.println("Der Automat hat das Eingabewort nicht akzeptiert!");
      }
    }
  }
}
