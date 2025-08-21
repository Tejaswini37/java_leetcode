class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q=new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=1;i<q.size();i++) q.add(q.poll());
    }
    
    public int pop() {
       return  q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
       return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//  class MyStack {
//     Queue<Integer> q1 = new LinkedList<>();
//     Queue<Integer> q2 = new LinkedList<>();

//     public void push(int x) {
//         q2.add(x);
//         while(!q1.isEmpty()){
//             q2.add(q1.poll());
//         }
//         // swap q1 and q2
//         Queue<Integer> temp = q1;
//         q1 = q2;
//         q2 = temp;
//     }

//     public int pop() {
//         return q1.poll();
//     }

//     public int top() {
//         return q1.peek();
//     }

//     public boolean empty() {
//         return q1.isEmpty();
//     }
// }
