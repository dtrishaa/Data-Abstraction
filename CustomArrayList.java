public class CustomArrayList {
    private Object[] elements;

    public CustomArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        return elements[index];
    }

    // Other methods, such as add(), remove(), etc.
}