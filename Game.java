import java.util.*;

public class Game {
   private static String[] commands = {"show inventory","show equipment", "equip", "end"};
   private static Scanner console = new Scanner(System.in);
   private static Player currentPlayer;

   public static void main(String[] args) {
      currentPlayer = new Player();
      String input = "";
      while (!input.equals("end")) {
         System.out.print("Awaiting input: ");
         input = console.nextLine().toLowerCase().trim();
         System.out.println();
         determineAction(processInput(input));
      }
   }
   
   public static String processInput(String input) {
      while (true) {
         for (int i = 0; i < commands.length; i++) {
            if (input.contains(commands[i])) {
               return input;
            }
         }
         System.out.println("Sorry, didnt catch that.  Try again.");
         input = console.nextLine().toLowerCase().trim();
      }
   }
   
   public static void determineAction(String command) {
      if (command.equals("show inventory")) {
         currentPlayer.printInventory();
      } else if (command.equals("show equipment")) {
         currentPlayer.printEquipment();
      } else if (command.startsWith("equip")) {
         currentPlayer.equip(command.substring(5).trim());
      }
   }
}
