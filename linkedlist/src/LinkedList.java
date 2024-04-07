public class LinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public LinkedList() {
        head = null;
    }

    public void printList() {
        // Prints the contents of each node
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void add(int data) {
        // Adds an element to the linked list
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
        }
    }

    public void removeAfter(Node node) {
        // Removes an element after the given node
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    public LinkedList copy(Node node) {
        // Copies the linked list
        LinkedList new_list = new LinkedList();
        Node current = node;
        while (current != null) {
            new_list.add(current.data);
            current = current.next;
        }
        return new_list;
    }
    public void removeDuplicate(Node node, int key) {
        // Removes duplicates
        Node current = node;
        Node prev = null;
        while (current != null) {
            if (current.data == key) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }
    public int max(Node node) {
        // Finds the max number
        if (node == null) {
            return 0;
        }
        int max = node.data;
        while (node != null) {
            if (node.data > max) {
                max = node.data;
            }
            node = node.next;
        }
        return max;
    }

    public static void main(String[] args) {
        // Test cases
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.printList();

        list.removeAfter(list.head.next);
        list.printList();


        LinkedList copiedList = list.copy(list.head);
        copiedList.printList();

        list.removeDuplicate(list.head, 4);
        list.printList();

        int max = list.max(list.head);
        System.out.println("Max value in the list: " + max);
    }
}