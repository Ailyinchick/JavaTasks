package entities;

import java.util.List;
import java.util.ArrayList;

public class Data {
    
    private static List<String> names;
    private static int pointer;
    
    static {
        if (names == null) {
            names = new ArrayList<String>(10);
        } else {
            names.clear();
        }
        names.add("Mike");
        names.add("Kyle");
        names.add("Hovard");
        names.add("Evgeniy");
        names.add("Sheldon");
        names.add("Leonard");
        names.add("Kate");
        names.add("Leon");
        names.add("Eric");
        names.add("Paul");
        pointer = 0;
    }
    
    public static String getNextName() {
        if (pointer == names.size()) {
            pointer = 0;
        }
        return names.get(pointer++);
    }

}
