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
        this.current = new Node(homepage);
    }
    
    public void visit(String url) {
        this.current.next = new Node(url, this.current, null);
        this.current = current.next;
    }
    
    public String back(int steps) {
        for(int i=0; i<steps && (this.current != null && this.current.prev != null); i++) {
            this.current = this.current.prev;
        }
        return this.current == null ? null : this.current.val;
    }
    
    public String forward(int steps) {
        for(int i=0; i<steps && (this.current != null && this.current.next != null); i++) {
            this.current = this.current.next;
        }
        return this.current == null ? null : this.current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */