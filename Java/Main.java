public class Main{ // if the Main class is private or protected the it gives compilation error
   public int count;
   public  final int  CONST;
   public int getCount(){
      return this.count;
   }
   public Main(){
      System.out.println("main constructor called");
      count = 10;
      CONST = 100;
   }
   // public Main(int i){
   //    this();
   //    System.out.println("called with i = " + i);
   //    count = i;
   //    // CONST = 500;
   // }
   public static void main(String args[]){
      // System.out.println(Dog.objectCount);
      // Animal a = new Animal(); // Animal reference and object
      // Dog b = new Dog("rocky"); // Animal reference but Dog object
      // Dog d = new Animal();
      // a.move();// runs the method in Animal class
      // b.bark();
      // b.move();//Runs the method in Dog class
      // b.eatAndBark();
      // Main m = new Main();
      String []s = new String[1];
      Main.main(s);
      // System.out.println(m.CONST);
      // System.out.println(m.count);
      // m.getCount();
   }
}