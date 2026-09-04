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
        System.out.print("\nget:"+index);
        Node cur = this.getNode(index);
        return cur == null ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        System.out.println("\naddAtHead:"+val);
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
        
        this.print();
    }
    
    public void addAtTail(int val) {
        System.out.println("\naddAtTail:" + val);
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
        this.print();
    }
    
    public void addAtIndex(int index, int val) {
        System.out.println("\naddAtIndex:"+index+";val="+val);
        Node node = new Node(val);
        if (index > size) {
            return;
        }
        System.out.println("\nindex="+index+";size="+size);
        if(index == size) {
            System.out.println("\nindex == size - 1");
            addAtTail(val);
        } else {
            System.out.println("\nindex != size");
            Node next = getNode(index);
            if (next == this.head) {
                System.out.println("\nnext == this.head");
                addAtHead(val);
            } else {
                System.out.println("\nnext != this.head");
                System.out.println("\nNode next:"+ next.val);
                System.out.println("\nNode val:"+ node.val);
                next.prev.next = node;
                node.prev = next.prev;
                node.next = next;
                next.prev = node;
                this.size++;
            }
        }
        System.out.println("\naddAtIndex:");
        this.print();
    }
    
    public void deleteAtIndex(int index) {
        System.out.println("\ndeleteAtIndex:"+index);
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
        this.print();
    }

    private Node getNode(int index) {
        System.out.println("\ngetNode:"+ index);
        Node cur = this.head;
        System.out.print(""+ cur.val+ ",");
        for(int i=0; i <index && cur != null; i++) {
            cur = cur.next;
            if (cur != null) {
                System.out.print(cur.val+ ",");
            }
        }
        if (cur != null) {
            System.out.println("\nFinal node:"+cur.val);
        } else {
            System.out.println("\nFinal node null");
        }
        return cur;
    }

    private void print() {
        Node cur = this.head;
        System.out.println("print:");
        while(cur != null) {
            System.out.print(cur.val+ ",");
            cur = cur.next;
        }
         System.out.println();
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