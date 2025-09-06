class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(st.isEmpty()) min=val;
        else min=Math.min(val,st.peek().y);
        st.push(new Pair(val,min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


// class Pair {
//     int x, y;
//     Pair(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }
// class MinStack {
//     Stack < Pair > st;
//     public MinStack() {
//         st = new Stack < > ();
//     }

//     public void push(int x) {
//         int min;
//         if (st.isEmpty()) {
//             min = x;
//         } else {
//             min = Math.min(st.peek().y, x);
//         }
//         st.push(new Pair(x, min));
//     }

//     public void pop() {
//         st.pop();
//     }

//     public int top() {
//         return st.peek().x;
//     }

//     public int getMin() {
//         return st.peek().y;
//     }
// }

// class MinStack {
//     Stack < Long > st = new Stack < Long > ();
//     Long mini;

//     /** initialize your data structure here. */
//     public MinStack() {
//         mini = Long.MAX_VALUE;
//     }

//     public void push(int value) {
//         Long val = Long.valueOf(value);
//         if (st.isEmpty()) {
//             mini = val;
//             st.push(val);
//         } else {
//             if (val < mini) {
//                 st.push(2 * val - mini);
//                 mini = val;
//             } else {
//                 st.push(val);
//             }
//         }
//     }

//     public void pop() {
//         if (st.isEmpty()) return;

//         Long val = st.pop();
//         if (val < mini) {
//             mini = 2 * mini - val;
//         }
//     }

//     public int top() {
//         Long val = st.peek();
//         if (val < mini) {
//             return mini.intValue();
//         }
//         return val.intValue();
//     }

//     public int getMin() {
//         return mini.intValue();
//     }
// }