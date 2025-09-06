class Solution {
    public int calculate(String s) {
        int res=0,num=0,sign=1;
        Stack<Integer> st=new Stack<>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='+'){
                res+=sign*num;
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                res+=sign*num;
                num=0;
                sign=-1;
            }
            else if(ch=='('){
                //save current res and sign
                st.push(res);
                st.push(sign);
                //reset
                res=0;
                sign=1;
            }
            else if(ch==')'){
                res+=sign*num;
                num=0;
                //pop sign and prev result
                res*=st.pop();
                res+=st.pop();
            }
        }
        return res+(sign*num);
    }
}

// Approach (Stack-based, O(n))

// Variables:

// res → running result for current expression.

// num → current number being built.

// sign → current sign (+1 or -1).

;// Scan string s character by character:

// If digit → build the number (num).

// If + or - → add sign * num to result, reset num=0, update sign.

// If ( → push current res and sign to stack, reset res=0, sign=+1.

// If ) → first add the pending number, then pop sign and previous res from stack → combine.

// Ignore spaces.

// At the end, add last num * sign to result.

// \U0001f539 Example Walkthrough

// Input:

// s = "1 + (2 - (3 + 4))"


// Steps:

// 1 → num=1

// + → res=1, sign=+1

// ( → push [1, +1], reset res=0

// 2 → num=2

// - → res=2, sign=-1

// ( → push [2, -1], reset res=0

// 3 → num=3

// + → res=3, sign=+1

// 4 → num=4

// ) → res=3+4=7, pop → res=2 + (-1 * 7) = -5

// ) → res=-5, pop → res=1 + (+1 * -5) = -4

// ✅ Final result = -4