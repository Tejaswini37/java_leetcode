class Solution {
    public String simplifyPath(String path) {
        String paths[]=path.split("/");
        Stack<String> st=new Stack<>();
        for(String p: paths){
            //skip empty or cur dir
            if(p.equals("") || p.equals(".")) continue;
            else if(p.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else st.push(p);
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb=new StringBuilder();
        for(String s : st){
            // sb.insert(0,"/"+s);
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}

// "." → current directory (ignore it).
// ".." → move up one directory (pop from stack if possible).
// Multiple slashes "//" → treated as a single /.
// Must return path starting with /.
// No trailing / (unless root).

// approach
// Use a stack to keep track of valid directories.
// Split the path by /.
// Push normal folder names into the stack.
// Pop when seeing "..".
// Ignore empty "" and ".".
// Build final path from stack.