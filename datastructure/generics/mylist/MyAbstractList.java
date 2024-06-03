package yukwork.datastructure.generics.mylist;

public abstract class MyAbstractList<T> implements MyList<T> {

    public boolean isEmpty() {
        return size() == 0;
    }

    public void checkBound(int index, int limit) {
        if (index < 0 || index >= limit)
            throw new IndexOutOfBoundsException("Invalid index: " + index + " for length: " + size());
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) list.append(get(i));
            else list.append(get(i)).append(", ");
        }
        return list.append("]").toString();
    }

}
