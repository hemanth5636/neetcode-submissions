class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] ps = path.split("/");
        
        for (String p : ps) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!p.equals("") && !p.equals(".")) {
                stack.push(p);
            }
        }

        return "/" + String.join("/", stack);
    }
}