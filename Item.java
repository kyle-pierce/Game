public class Item implements Comparable<Item>{
   public String name;
   private String slot;

   public Item(String name) {
      this.name = name;
      slot = "";
   }
   
   public String toString() {
      return name;
   }
   
   public int compareTo(Item other) {
      return (name.compareTo(other.name));
   }
   
   public String getSlot() {
      return slot;
   }
   
   public void display() {
      System.out.println("name: " + name);
      System.out.println();
   }
}
