package yukwork.datastructure.nongenerics.myset;

public abstract class MyAbstractSet implements MySet {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Object[] elements = toArray();
        for (Object element : elements) {
            remove(element);
        }
    }

    @Override
    public MySet union(MySet another) {
        MySet resultSet = createSet();
        Object[] elements = toArray();
        for (Object element : elements) {
            resultSet.add(element);
        }
        MyIterator iterator = another.iterator();
        while (iterator.hasNext()) {
            resultSet.add(iterator.next());
        }
        return resultSet;
    }

    @Override
    public MySet intersection(MySet another) {
        MySet resultSet = createSet();
        Object[] elements = toArray();
        for (Object element : elements) {
            if (another.contains(element)) {
                resultSet.add(element);
            }
        }
        return resultSet;
    }

    @Override
    public MySet difference(MySet another) {
        MySet resultSet = createSet();
        Object[] elements = toArray();
        for (Object element : elements) {
            if (!another.contains(element)) {
                resultSet.add(element);
            }
        }
        return resultSet;
    }

    protected abstract MySet createSet();

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        MyIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            list.append(iterator.next()).append(", ");
        }
        if (list.length() > 1) {
            list.setLength(list.length() - 2);
        }
        return list.append("]").toString();
    }
}
