package interfaces;

public interface MyComparable<T> {
    
    /*
     * Returns:
     * 1 if t is greater
     * -1 if 'this' is greater
     * 0 if 'this' and t are equal
     */
    public int compareTo(T t);
}
