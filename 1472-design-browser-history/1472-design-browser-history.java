class BrowserHistory {
    Stack<String> back;
    Stack<String> front;
    String cur;
    public BrowserHistory(String homepage) {
        back=new Stack<>();
        front=new Stack<>();
        cur=homepage;
    }
    
    public void visit(String url) {
        back.push(cur);
        cur=url;
        front.clear(); // imp
    }
    
    public String back(int steps) {
        while(steps>0 && !back.isEmpty()){
            front.push(cur);
            cur=back.pop();
            steps--;
        }
        return cur;
    }
    
    public String forward(int steps) {
        while(steps>0 && !front.isEmpty()){
            back.push(cur);
            cur=front.pop();
            steps--;
        }
        return cur;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */