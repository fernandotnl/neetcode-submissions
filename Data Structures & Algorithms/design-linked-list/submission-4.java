class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public Node(int val) {
        this(val, null, null);
    }
}
class MyLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        Node cur = this.getNode(index);
        return cur == null ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node; 
        }
        this.size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.tail == null) {
            this.head =node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index > size) {
            return;
        }
        if(index == size) {
            addAtTail(val);
        } else {
            Node next = getNode(index);
            if (next == this.head) {
                addAtHead(val);
            } else {
                next.prev.next = node;
                node.prev = next.prev;
                node.next = next;
                next.prev = node;
                this.size++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index == 0) {
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
                this.size = 0;
            } else {
                this.head = this.head.next;
                this.size--;
            }
        }
        else if (index == size - 1) {
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
                this.size = 0;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
                this.size--;
            }
        }
        else if (index >0 && index < size-1) {
             Node prev = getNode(index-1);
             prev.next = prev.next.next;
             prev.next.prev = prev;
             this.size--;
        }
    }

    private Node getNode(int index) {
        Node cur = this.head;
        for(int i=0; i <index && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */