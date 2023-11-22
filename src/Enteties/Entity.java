package Enteties;

public class Entity extends ComparableEntity<Entity> {
	
//  Fields
	private int age;
	private String name;
	
	
	
//	Constructors
	public Entity(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

//	Getters and setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//  Methods
	@Override
	public boolean isGreater(Entity t1) {
		return this.getAge() > t1.getAge();
	}
	
	@Override
	public String toString() {
		return name + ": " + age;
	}

}
