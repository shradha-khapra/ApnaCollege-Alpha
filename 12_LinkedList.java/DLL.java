public class DLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data) {
            size++;
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
                return;
            }

            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        public void print() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data+"<->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public int removeFirst() {
            if(head == null) {
                return Integer.MIN_VALUE;
            }
            size--;
            if(head == tail) {
                int val = head.data;
                head = tail = null;
                return val;
            }
            int val = head.data;
            head = head.next;
            head.prev = null;
            return val;
        }
        
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]) {
        DLL dll = new DLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();

        dll.removeFirst();
        dll.print();
        dll.addFirst(1);
        dll.print();

        dll.reverse();
        dll.print();
    }
}
