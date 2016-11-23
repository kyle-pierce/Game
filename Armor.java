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
}  
