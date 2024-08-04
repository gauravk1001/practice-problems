public class Stacks {

    StackNode top;

    public void push(int data) {

        StackNode n = new StackNode(data);
        n.prev = top;
        top = n;

    }

    public int peek () {
        if (top != null) {
            return top.data;
        }
        return -1;
    }

    public int pop() {
        int data = top.data;
        top = top.prev;
        return data;
    }

    public void print() {
        if (top == null) {
            return;
        }

        while (top != null) {
            System.out.print(top.data + ", ");
            top = top.prev;
        }
    }

    public static void main(String args[]) {
        Stacks s = new Stacks();
        s.push(3);
        s.push(4);
        s.push(2);
        System.out.println(s.peek());
        s.push(6);
        s.push(1);
        s.print();
    }
}

class StackNode {
    StackNode prev;
    int data;

    public StackNode(int data) {
        this.data = data;
        this.prev = null;
    }
}