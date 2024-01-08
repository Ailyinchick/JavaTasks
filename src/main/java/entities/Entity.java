package entities;

import interfaces.MyComparable;

public class Entity implements MyComparable<Entity> {
    
    private String name;
    private int age;
    
    public Entity(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Entity t) {
        if (t == null) {
            return -1;
        }
        if (this == t) {
            return 0;
        }
        if (this.getAge() > t.getAge()) {
            return -1;
        }
        if (this.getAge() < t.getAge()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Entity [name=" + name + ", age=" + age + "]";
    }
    
}
