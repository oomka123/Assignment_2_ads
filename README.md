
This project implements custom versions of core data structures: `ArrayList`, `LinkedList`, `Stack`, `Queue`, and `MinHeap` — **without using `java.util.*` collections (except `Iterator`)**, as part of an assignment on data structure fundamentals.

---

## 📌 Task Overview

- Implement two physical data structures:
  - `MyArrayList<T>` — dynamic array.
  - `MyLinkedList<T>` — doubly linked list.

- Implement three logical data structures:
  - `MyStack<T>` — based on a physical list of your choice.
  - `MyQueue<T>` — based on a physical list of your choice.
  - `MyMinHeap<T extends Comparable<T>>` — min-heap using array-based binary heap.

All physical structures implement the shared interface `MyList<T>`, which includes basic list operations.

---

## ✅ Implemented Classes

### 1. `MyList<T>` (Interface)

A custom interface defining list operations:

- `add`, `remove`, `get`, `set`, `clear`, `size`, etc.
- Conversion to array and iteration support.

### 2. `MyArrayList<T>` (Physical)

- Backed by a resizable `Object[]` array.
- Implements all `MyList<T>` methods.
- Dynamically resizes on insertion.

### 3. `MyLinkedList<T>` (Physical)

- Doubly linked list using internal `MyNode` class.
- Maintains references to both `head` and `tail`.
- Supports all `MyList<T>` methods.
- Loop-safe traversal.

### 4. `MyStack<T>` (Logical)

- Backed by `MyLinkedList<T>`.
- Supports LIFO operations: `push`, `pop`, `peek`.

### 5. `MyQueue<T>` (Logical)

- Backed by `MyLinkedList<T>`.
- Supports FIFO operations: `enqueue`, `dequeue`, `peek`.

### 6. `MyMinHeap<T extends Comparable<T>>` (Logical)

- Backed by `Object[]` array.
- Implements:
  - `insert(T item)`
  - `extractMin()`
  - `peek()` or `getMin()`
  - Private helpers: `heapifyUp`, `heapifyDown`, `swap`, etc.

---

## ⚙️ Requirements

- Use of generics and custom iterator implementation.
- No use of built-in collections (`ArrayList`, `LinkedList`, etc.).
- Custom sorting implemented using either:
  - `T extends Comparable<T>`
  - or `sort(Comparator<T>)` (if implemented)
