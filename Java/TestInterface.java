interface Printable{
void print();
//void fun();
}
interface Doable{
	int print();
}
interface Showable extends Printable, Doable {
//  print();
void xyz();
}

class Testinterface implements Printable,Showable{

public void print(){System.out.println("Hello");}
public void print(int i){System.out.println("Hello");}
public void xyz(){System.out.println("Hello");}

// public int print(){System.out.println("Hello");}

public static void main(String args[]){
Testinterface obj = new Testinterface();
obj.print();
 }
}
