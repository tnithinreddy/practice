class Dog extends Animal{

   // public Main m;
   private Main m;
   public static int objectCount = 10;
   public Dog(String name){
   		super(name);
   		// this("horse");
   		m = new Main();
   		System.out.println("Just inside Dog constructor");
   		System.out.println("Animal with name " + this.getName()+" is created");
   		System.out.println("dog constructor called");
   }
   public void move(){
   	  // System.out.println("count from Main = "+ m.getCount());
      
      System.out.println("Dogs can walk and run");

   }
   public void bark(){
   		swim(); // protected members are accesible in the same package and sub classes which extend the class
   		System.out.println("Im dog and only i can bark");
   }

   public void eatAndBark(){
   		// eat(); // compile time error,cannot be accessed, as private members are accesible on in the class block
   		bark();
   }

}