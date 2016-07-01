class Animal{

   private String name;
   public Animal(){
   	name = "unknown";
   }
   public Animal(String n){
   		name = n;
   		System.out.println("Animal constructor called;");
   }
   public void move(){
      System.out.println("Animals can move");
   }

   private void eat(){
   		System.out.println("Animal is eating");
   }

   protected void swim(){
   		System.out.println("Animal is swimming");
   }
   public void printName(){
   		System.out.println("Animal name = " + name);
   }
   public String getName(){
   		return name;
   }
}