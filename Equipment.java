import java.util.*;

public class Equipment {
   private Map<String, Item> map = new TreeMap<String, Item>();

   public Equipment() {
      map.put("head", null);
      map.put("chest", null);
      map.put("legs", null);
      map.put("hands", null);
      map.put("feet", null);
      map.put("waist", null);
      map.put("shoulders", null);
      map.put("main-hand", null);
      map.put("off-hand", null);
   }
   
   public Equipment(List<Item> list) {
      for (Item i : list) {
         map.put(i.getSlot(), i);
      }
   }
   
   public void print() {
      System.out.println("Current Player Equipment:");
      System.out.println();
      for (String s : map.keySet()) {
         System.out.print(s + ": ");
         if (map.get(s) != null) {
            System.out.println(map.get(s));
         } else {
            System.out.println();
         }
      }
      System.out.println();
   }
   
   public void add(String s, Inventory inventory) {
      Item i = inventory.checkFor(s);
      if (i != null && i.getSlot().length() > 0) {
         map.put(i.getSlot(), i);
         System.out.println("Successfully equipped " + i.toString());
         inventory.remove(i);
         System.out.println();
      } else if (i != null) {
         System.out.println("You can't equip one of those.");
      } else {
         System.out.println("Not happening.");
      }
   }
   
   public Item checkFor(String itemName) {
      for (String s : map.keySet()) {
         if (map.get(s) != null && map.get(s).toString().toLowerCase().equals(itemName)) {
            return map.get(s);
         }
      }
      return null;
   }
}
