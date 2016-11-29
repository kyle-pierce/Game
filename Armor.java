public class Armor extends Item {
   private int armorRating;
   private String slot;
   
   public Armor(String name, int armorRating, String slot) {
      super(name);
      this.armorRating = armorRating;
      this.slot = slot;
   }
   
   public String getSlot() {
      return slot;
   }
   
   public void display() {
      System.out.println("name: " + super.name);
      System.out.println("armor: " + armorRating);
      System.out.println("slot: " + slot);
      System.out.println();
   }
}  
