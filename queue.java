// class queue {
//     int front, rear, size;
//     int[] arr;

//     queue(int capacity) {
//         arr = new int[capacity];
//         front = 0;
//         rear = -1;
//         size = 0;
//     }

//     void enqueue(int x) {
//         if (size == arr.length) {
//             System.out.println("Queue Overflow");
//             return;
//         }
//         rear = (rear + 1) % arr.length;
//         arr[rear] = x;
//         size++;
//     }

//     int dequeue() {
//         if (size == 0) {
//             System.out.println("Queue Underflow");
//             return -1;
//         }
//         int val = arr[front];
//         front = (front + 1) % arr.length;
//         size--;
//         return val;
//     }

//     int peek() {
//         if (size == 0) return -1;
//         return arr[front];
//     }

//     boolean isEmpty() {
//         return size == 0;
//     }
// }


// void dequeue(){
//     if(this->front == null){
//         System.out.println("queue is empty");
//         return;
//     }
//     Qnode* temp = this->front;
//     this->front = this->front->next
// }


// ethics : 
// att : 4
// ca : 19
// mid : 17
// end : est- 40
// total : 80
// est grade : a

// combinatorial:
// att : 5
// ca : 37
// end : est- 30
// total : 72
// est grade : b+ - b

// mvc prog : 
// att : 5
// ca : 39
// end : est- 35
// total : 80
// est grade : a - b+

// pes -ii :
// att : 15
// ca : 22
// end : est- 30
// total : 67
// est grade : b - c

// psy : 
// att : 5
// ca : 19
// mid : 18
// end : est- 40
// total : 82
// est grade : a


// est grade 

// max 99
// o - 90-99
// a+ =90-81
// a = 81-72
// b+ =72-63
// b =63-54
// c =54-45
// d =45-40



import java.util.*;
public class queue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Character> que = new LinkedList<>();
        int a = sc.nextInt();
        String binaryStr = Integer.toBinaryString(a);
        for(char ch : binaryStr.toCharArray()){
            que.add(ch);
            que.add(' ');
        }
        while(!que.isEmpty()){
            System.out.print(que.poll());
        }

    }

}