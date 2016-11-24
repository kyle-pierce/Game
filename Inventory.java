import java.util.*;

public class Inventory {
   private Map<Item, Integer> map = new TreeMap<Item, Integer>();

   public Inventory(String playerClass) {
      if (playerClass.equals("warrior")) {
         map.put(new Weapon("iron sword", 5, "main-hand"), 1);
         map.put(new Weapon("hide buckler", 10, "off-hand"), 1);
      } else if (playerClass.equals("ranger")) {
         map.put(new Weapon("hunting bow", 5, "main-hand"), 1);
         map.put(new Item("arrow"), 100);
      } else {
         map.put(new Weapon("gnarled staff", 5, "main-hand"), 1);
         map.put(new Weapon("oak wand", 5, "main-hand"), 1);
      }
      map.put(new Item("gold coin"), 10);
      map.put(new Item("lantern"), 1);
      map.put(new Armor("Gold Chestpiece", 100, "chest"), 1);
   }
   
   public void print() {
      System.out.println("Current Player Inventory:");
      System.out.println();
      for (Item i : map.keySet()) {
         System.out.println(i + ": " + map.get(i));
      }
      System.out.println();
   }
   
   public Item checkFor(String itemName) {
      for (Item i : map.keySet()) {
         if (i.toString().toLowerCase().equals(itemName)) {
            return i;
         }
      }
      return null;
   }
   
   public void remove(Item i) {
      map.remove(i);
   }

}