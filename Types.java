
public class Types {
	public static void main(String[] args) {
	
		Iperson p1 = new Person("Mike");
		Iperson p2 = new Student("Mary", 3.2);
		
		
		Person p3 = new Person("Beth");
		Person p4 = new Student("nate", 3.4);
		
		//Don't use Student p5 = new Student(); use interphase 
		
		p4 = p3;
		((Student)p4).walk();
	}
		
}



interface Iperson{
	void speak();
	
}

class Person implements Iperson{
	protected String name;
	
	public Person(String n){
		name = n;
	}
	
	public Person(){
		name = "";
	}

	@Override
	public void speak() {
		System.out.println("I am " + name);		
	}
}

class Student extends Person{
	protected double gpa; 
	
	public Student(String n, double gpa){
		super(n);
		this.gpa = gpa;
	}
	
	public Student(){
		super();
		this.gpa = -1;
	}
	
	public void speak() {
		super.speak();
		System.out.println(("I am a student."));
	}

	public void walk(){
		System.out.println("My gpa " + gpa + " walks upward...");
	}
	
}
