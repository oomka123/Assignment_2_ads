public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == length) addLast(item);
        else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            length++;
        }
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        MyNode<T> current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode<T> toRemove = getNode(index);
        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;

        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;

        length--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        remove(0);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        remove(length - 1);
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = length - 1;
        while (current != null) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void sort() {
        if (length < 2) return;

        for (int i = 0; i < length - 1; i++) {
            MyNode<T> current = head;
            for (int j = 0; j < length - i - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}
