import java.util.Arrays;

public class MyMinHeap<T extends Comparable<T>> {
    private Object[] heap;
    private int size;

    public MyMinHeap() {
        heap = new Object[10];
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = parentOf(index);
            if (((T) heap[index]).compareTo((T) heap[parentIndex]) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        while (index * 2 + 1 < size) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (((T) heap[index]).compareTo((T) heap[smallerChildIndex]) <= 0) break;

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void swap(int index1, int index2) {
        T temp = (T) heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(T item) {
        if (size == heap.length) resize();
        heap[size] = item;
        heapifyUp(size);
        size++;
    }

    public T extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        T min = (T) heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        heapifyDown(0);
        return min;
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return (T) heap[0];
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = heap.length * 2;
        heap = Arrays.copyOf(heap, newCapacity);
    }
}
