class Node {
    String val;
    Node next;
    Node prev;
    public Node(String val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public Node(String val) {
        this(val, null, null);
    }
}
class MyLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    public MyLinkedList() {
        
    }
    
    public String get(int index) {
        Node cur = this.getNode(index);
        return cur == null ? null : cur.val;
    }
    
    public void addAtHead(String val) {
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
    
    public void addAtTail(String val) {
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
    
    public void addAtIndex(int index, String val) {
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

    public void deleteAllAfter(Node node) {
        int reduceSize = 0;
        Node cur = node;
        while(cur != null) {
            Node next = cur.next;
            cur.next = null;
            cur = next;
            reduceSize++;
        }
        this.tail = node;
        this.size-=reduceSize;
    }

    private Node getNode(int index) {
        Node cur = this.head;
        for(int i=0; i <index && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

class BrowserHistory {

    MyLinkedList history;
    Node current = null;
    public BrowserHistory(String homepage) {
        history = new MyLinkedList();
        this.visit(homepage);
    }
    
    public void visit(String url) {
        if (history.size >0 && this.current != history.tail) {
            this.history.deleteAllAfter(this.current);
        }
        this.history.addAtTail(url);
        this.current = history.tail;
    }
    
    public String back(int steps) {
        Node cur = current;
        for(int i=0; i<steps && cur != history.head; i++) {
            cur = cur.prev;
        }
        this.current = cur;
        return cur.val;
    }
    
    public String forward(int steps) {
        Node cur = current;
        for(int i=0; i<steps && cur != history.tail; i++) {
            cur = cur.next;
        }
        this.current = cur;
        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */