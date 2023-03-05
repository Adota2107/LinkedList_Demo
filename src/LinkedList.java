public class LinkedList {
    public static void main(String[] args) throws Exception {
        MyList list = new MyList();
        list.add(3);
        list.add(6);
        list.add(8);  
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(14);
        list.add(17);
        list.add(20);
        list.traverse();
        list.addToHead(2);
        list.traverse();
        System.out.println("Data: " + list.deleteFromHead());
        list.traverse();
        System.out.println("Data: " + list.deleteFromTail());
        list.traverse();
        list.dele(8);
        list.traverse();
        System.out.println("Node: " + list.search(6));
        list.traverse();
        System.out.println("Count: " + list.count());
        list.dele_ith(0);
        list.traverse();
        list.sort();
        System.out.print("Sorted: ");
        list.traverse();
        int[] toArray = list.toArray();
        list.printArray(toArray);
    }

    static class Node{
        int data;
        Node next;

        public Node() {
        }

        public Node(int xData, Node xNext){
            this.data = xData;
            this.next = xNext;
        }
    }

    static class MyList{
        Node head, tail;

        public MyList(){
        }

        public MyList(Node xHead, Node xTail){
            this.head = xHead;
            this.tail = xTail;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public void add(int x){
            Node n = new Node(x, null);
            if (isEmpty()) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        public void traverse(){
            Node n = head;
            while (n.next != null) {
                System.out.print(n.data + ", ");
                n = n.next;
            }
            if (n.next == null) {
                System.out.print(n.data);
            }
            System.out.println();
        }

        public void addToHead(int x){
            Node n = new Node(x, null);
            if (isEmpty()) {
                n = head;
            } else {
                n.next = head;
                head = n;
            }
        }

        public void addToTail(int x){
            Node n = new Node(x, null);
            if (isEmpty()) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        public void addAfter(Node p, int x){
            Node n = new Node(x, null);
            if (isEmpty()) {
                return;
            } else {
                n.next = p.next;
                p.next = n;
            }
        }

        public int deleteFromHead(){
            int info;
            if (isEmpty()) {
                return 0;
            } else {
                info = head.data;
                head = head.next;
                return info;
            }
        }

        public int deleteFromTail(){
            int info;
            if (isEmpty()) {
                return 0;
            } else {
                Node cur = head;
                info = tail.data;
                if (head.next == null) {
                    return 0;
                }
                while (cur.next.next != null) {   
                    cur = cur.next;
                }
                cur.next = null;
                return info;
            }
        }

        //Delete the node that have value of x
        public void dele(int x){
            if (isEmpty()) {
                return;
            }
            Node cur = head;
            Node prev = null;
            while (cur != null && cur.data != x) {
                prev = cur;
                cur = cur.next;
            }
            if (prev == null) {
                head = head.next;
            } else {
                prev.next = cur.next;
            }
        }

        public Node search(int x){
            Node cur = head;
            if (isEmpty()) {
                return null;
            }
            while (cur != null && cur.data != x) {
                cur = cur.next;
            }
            return cur;
        }

        public int count(){
            int count = 0;
            Node cur = head;
            while (cur != null) {
                ++count;
                cur = cur.next;
            }
            return count;
        }

        //Delete node at i-th
        public void dele_ith(int i){
            int index = 0;
            Node cur = head;
            Node prev = null;
            if (isEmpty()) {
                return;
            }
            while (cur != null && index != i) {
                index++;
                prev = cur;
                cur = cur.next;
            }
            if (prev == null) {
                head = head.next;
            }else{
                prev.next = cur.next;
            }
        }

        public void sort(){
            Node cur = head, index = null;
            int temp;
            if (isEmpty()) {
                return;
            }
            while (cur != null) {
                index = cur.next;
                while (index != null) {
                    if (cur.data > index.data) {
                        temp = cur.data;
                        cur.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                cur = cur.next;
            }
        }

        //Delete node p if it exist in list
        public void deleNode(Node p){
            Node cur = head;
            Node prev = null;
            if (isEmpty()) {
                return;
            }
            while (cur != null && cur != p) {
                prev = cur;
                cur = cur.next;
            }
            if (prev == null) {
                head = head.next;
            }else{
                prev.next = cur.next;
            }
        }

        //Create and return array containing data of all nodes in the list
        public int[] toArray(){
            int size = 0;
            Node cur = head;
            while (cur != null) {
                cur = cur.next;
                size++;
            }
            int[] dataInArray = new int[size];
            cur = head;
            for (int i = 0; i < size; i++) {
                dataInArray[i] = cur.data;
                cur = cur.next;
            }
            return dataInArray;
        }

        public void printArray(int[] toArray){
            System.out.print("[");
            for (int i : toArray) {
                System.out.print(i + ", ");
            }
            System.out.println("]");
        }

        
    }
}
