import java.util.*;

public class Game {
   private static String[] commands = {"inventory", "stat", "equip"};
   private static Scanner console = new Scanner(System.in);
   private static Player currentPlayer;

   public static void main(String[] args) {
      currentPlayer = new Player();
      determineAction(processInput(console.nextLine()));
   }
   
   public static String processInput(String input) {
      while (true) {
         for (int i = 0; i < commands.length; i++) {
            if (input.contains(commands[i])) {
               return input;
            }
         }
         System.out.println("Sorry, didnt catch that.  Try again.");
         input = console.next();
      }
   }
   
   public static void determineAction(String command) {
      if (command.equals("inventory")) {
         currentPlayer.printInventory();
      } else if (command.equals("stat")) {
         currentPlayer.stats();
      } else if (command.equals("equip")) {
         currentPlayer.printEquipment();
      }
   }
}