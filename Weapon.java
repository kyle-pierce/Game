public class Weapon extends Item {
   private int damage;
   private String slot;
   
   public Weapon(String name, int damage, String slot) {
      super(name);
      this.damage = damage;
      this.slot = slot;
   }
   
   public String getSlot() {
      return slot;
   }
}
