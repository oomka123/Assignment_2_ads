public class Main {
    public static void main(String[] args) {
        System.out.println("--- MyArrayList Test ---");
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println("=== Testing add(T item) ===");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Expected size: 3 → " + list.size());
        System.out.println("Expected get(1): 20 → " + list.get(1));

        System.out.println("\n=== Testing add(index, item) ===");
        list.add(1, 15);
        System.out.println("Expected get(1): 15 → " + list.get(1));
        System.out.println("Expected get(2): 20 → " + list.get(2));

        System.out.println("\n=== Testing addFirst / addLast ===");
        list.addFirst(5);
        list.addLast(35);
        System.out.println("Expected getFirst(): 5 → " + list.getFirst());
        System.out.println("Expected getLast(): 35 → " + list.getLast());

        System.out.println("\n=== Testing set(index, item) ===");
        list.set(2, 17);
        System.out.println("Expected get(2): 17 → " + list.get(2));

        System.out.println("\n=== Testing remove(index) ===");
        list.remove(2);
        System.out.println("Expected size: 5 → " + list.size());
        System.out.println("Expected get(2): 20 → " + list.get(2));

        System.out.println("\n=== Testing removeFirst / removeLast ===");
        list.removeFirst();
        list.removeLast();
        System.out.println("Expected getFirst(): 10 → " + list.getFirst());
        System.out.println("Expected getLast(): 30 → " + list.getLast());

        System.out.println("\n=== Testing indexOf / lastIndexOf / exists ===");
        list.add(10);
        System.out.println("indexOf(10): 0 → " + list.indexOf(10));
        System.out.println("lastIndexOf(10): 3 → " + list.lastIndexOf(10));
        System.out.println("exists(20): true → " + list.exists(20));
        System.out.println("exists(999): false → " + list.exists(999));

        System.out.println("\n=== Testing sort() ===");
        list.clear();
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort();
        System.out.print("Expected sorted: 10 20 30 → ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("\n=== Testing toArray() ===");
        Object[] arr = list.toArray();
        System.out.print("Array contents: ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("\n=== Testing clear() ===");
        list.clear();
        System.out.println("Expected size after clear: 0 → " + list.size());

        System.out.println("\n=== Testing iterator() ===");
        list.add(100);
        list.add(200);
        list.add(300);
        System.out.print("Expected: 100 200 300 → ");
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("--- MyLinkedList Test ---");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        System.out.println("=== Testing add(T item) ===");
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        System.out.println("Expected size: 3 → " + linkedList.size());
        System.out.println("Expected get(1): 20 → " + linkedList.get(1));

        System.out.println("\n=== Testing add(index, item) ===");
        linkedList.add(1, 15);
        System.out.println("Expected get(1): 15 → " + linkedList.get(1));
        System.out.println("Expected get(2): 20 → " + linkedList.get(2));

        System.out.println("\n=== Testing addFirst / addLast ===");
        linkedList.addFirst(5);
        linkedList.addLast(35);
        System.out.println("Expected getFirst(): 5 → " + linkedList.getFirst());
        System.out.println("Expected getLast(): 35 → " + linkedList.getLast());

        System.out.println("\n=== Testing set(index, item) ===");
        linkedList.set(2, 17);
        System.out.println("Expected get(2): 17 → " + linkedList.get(2));

        System.out.println("\n=== Testing remove(index) ===");
        linkedList.remove(2);
        System.out.println("Expected size: 5 → " + linkedList.size());
        System.out.println("Expected get(2): 20 → " + linkedList.get(2));

        System.out.println("\n=== Testing removeFirst / removeLast ===");
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Expected getFirst(): 10 → " + linkedList.getFirst());
        System.out.println("Expected getLast(): 30 → " + linkedList.getLast());

        System.out.println("\n=== Testing indexOf / lastIndexOf / exists ===");
        linkedList.add(10);
        System.out.println("indexOf(10): 0 → " + linkedList.indexOf(10));
        System.out.println("lastIndexOf(10): 3 → " + linkedList.lastIndexOf(10));
        System.out.println("exists(20): true → " + linkedList.exists(20));
        System.out.println("exists(999): false → " + linkedList.exists(999));

        System.out.println("\n=== Testing sort() ===");
        linkedList.clear();
        linkedList.add(30);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.sort();
        System.out.print("Expected sorted: 10 20 30 → ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();

        System.out.println("\n=== Testing toArray() ===");
        Object[] arr2 = linkedList.toArray();
        System.out.print("Array contents: ");
        for (Object obj : arr2) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("\n=== Testing clear() ===");
        linkedList.clear();
        System.out.println("Expected size after clear: 0 → " + linkedList.size());

        System.out.println("\n=== Testing iterator() ===");
        linkedList.add(100);
        linkedList.add(200);
        linkedList.add(300);
        System.out.print("Expected: 100 200 300 → ");
        for (int x : linkedList) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
