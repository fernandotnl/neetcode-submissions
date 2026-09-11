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

class BrowserHistory {

    Node current = null;
    public BrowserHistory(String homepage) {
        this.visit(homepage);
    }
    
    public void visit(String url) {
        Node newCurrent = new Node(url, this.current, null);
        if (this.current != null) {
            this.current.next = newCurrent;
        } 
        this.current = newCurrent;
    }
    
    public String back(int steps) {
        Node cur = this.current;
        for(int i=0; i<steps && (cur != null && cur.prev != null); i++) {
            cur = cur.prev;
        }
        this.current = cur;
        return this.current == null ? null : this.current.val;
    }
    
    public String forward(int steps) {
        Node cur = this.current;
        for(int i=0; i<steps && (cur != null && cur.next != null); i++) {
            cur = cur.next;
        }
        this.current = cur;
        return this.current == null ? null : this.current.val;
    }

    void print() {
        Node cur = this.current;
        while(cur != null && cur.prev != null) {
            cur = cur.prev;
        }
        while(cur != null) {
            cur = cur.next;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */