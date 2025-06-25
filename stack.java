
import java.util.*;

class stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor
    stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push operation
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println(x + " pushed into stack");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Peek operation
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return stack size
    public int size() {
        return top + 1;
    }

    // Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        stack s = new stack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        System.out.println("Top element is: " + s.peek());

        System.out.println("Popped: " + s.pop());
        s.display();

        System.out.println("Is empty? " + s.isEmpty());
        System.out.println("Current size: " + s.size());
    }
}

