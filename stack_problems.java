
import java.util.*;

public class stack_problems {

    static boolean is_valid(String inp){
        char[] input = inp.toCharArray();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<input.length;i++){
            char current = input[i];
            if(current=='(' || current=='{' || current=='['){
                st.push(current);
            } else{
                if(st.empty()){
                    return false;
                }
                char popchar;
                switch(current){
                    case ')':
                        popchar = st.peek();
                        st.pop();
                        if(popchar=='{' || popchar=='['){
                            return false;
                        }
                        break;
                    case '}':
                        popchar = st.peek();
                        st.pop();
                        if(popchar=='(' || popchar=='['){
                            return false;
                        }
                        break;
                    case ']':
                        popchar = st.peek();
                        st.pop();
                        if(popchar=='{' || popchar=='('){
                            return false;
                        }
                        break;
                }
            }


        }
        return st.empty();
    }
    public static void main(String[] args) {
          String test1 = "({[]})";
        String test2 = "((())";
        String test3 = "{[()]()}";
        String test4 = "{[(])}";

        System.out.println(test1 + " => " + is_valid(test1)); // true
        System.out.println(test2 + " => " + is_valid(test2)); // false
        System.out.println(test3 + " => " + is_valid(test3)); // true
        System.out.println(test4 + " => " + is_valid(test4)); // false
    }
}



// import java.util.Stack;

// public class stack_problems {

//     static boolean is_valid(String inp) {
//         char[] input = inp.toCharArray();
//         Stack<Character> st = new Stack<>();

//         for (char current : input) {
//             if (current == '(' || current == '{' || current == '[') {
//                 st.push(current);
//             } else {
//                 if (st.isEmpty()) {
//                     return false;
//                 }
//                 char popchar = st.peek(); // look at top element
//                 st.pop(); // remove top

//                 if ((current == ')' && popchar != '(') ||
//                     (current == '}' && popchar != '{') ||
//                     (current == ']' && popchar != '[')) {
//                     return false;
//                 }
//             }
//         }

//         return st.isEmpty(); // if stack is empty, it's valid
//     }

//     public static void main(String[] args) {
//         String test1 = "({[]})";
//         String test2 = "((())";
//         String test3 = "{[()]()}";
//         String test4 = "{[(])}";

//         System.out.println(test1 + " => " + is_valid(test1)); // true
//         System.out.println(test2 + " => " + is_valid(test2)); // false
//         System.out.println(test3 + " => " + is_valid(test3)); // true
//         System.out.println(test4 + " => " + is_valid(test4)); // false
//     }
// }
