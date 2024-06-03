package yukwork.datastructure.generics.myset;

public abstract class MyAbstractSet<T> implements MySet<T> {

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        T[] elements = toArray();
        for (T element : elements) {
            remove(element);
        }
    }

    public MySet<T> union(MySet<T> another) {
        MySet<T> result = createNewSet();
        for (T element : this.toList()) {
            result.add(element);
        }
        for (T element : another.toList()) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public MySet<T> intersection(MySet<T> another) {
        MySet<T> result = createNewSet();
        for (T element : this.toList()) {
            if (another.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public MySet<T> difference(MySet<T> another) {
        MySet<T> result = createNewSet();
        for (T element : this.toList()) {
            if (!another.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    protected abstract MySet<T> createNewSet();

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        MyIterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            list.append(iterator.next()).append(", ");
        }
        if (list.length() > 1) {
            list.setLength(list.length() - 2);
        }
        return list.append("]").toString();
    }

}
