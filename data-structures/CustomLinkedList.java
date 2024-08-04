
public class CustomLinkedList {
    LLNode head;

    public void append(int data) {

        if (head == null) {
            head = new LLNode(data);
            return;
        }

        LLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new LLNode(data);
    }

    public void prepend(int data) {
        if (head == null) {
            head = new LLNode(data);
            return;
        }

        LLNode newHead = new LLNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        LLNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public void print() {
        LLNode current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    /*
     * 1 -> 2 -> 3 -> 4 -> null
     * 4 -> 3 -> 2 -> 1 -> null
     * 
     * prev <- curr -> curr.next -> curr.next.next
     * null <- 1 -> 2 -> 3
     * 3 -> 2 -> 1 -> null 3 4 -> null
     * c cn cnn
     */
    public void reverse() {
        LLNode c = head;
        LLNode cn = c.next;
        LLNode cnn = c.next.next;

        while (cn != null) {
            if (c == head) {
                c.next = null;
            }

            cn.next = c;

            if (cnn == null) {
                head = cn;
            }

            c = cn;
            cn = cnn;
            if (cnn != null) {
                cnn = cnn.next;
            }
        }

        print();
    }

    public int getMid() {
        LLNode c = head;
        if (c.next == null || c.next.next == null) {
            return -1;
        }
        LLNode fastc = c;

        int x = 1;
        while (fastc != null) {

            System.out.println("c=" + c.data + " fastc=" + fastc.data);

            if (fastc.next == null || fastc.next.next == null) {
                return c.data;
            } else if (fastc.next.next != null) {
                fastc = fastc.next.next;
                c = c.next;

            }

            // x += 1;

            // if (x == 5) break;
        }

        return c.data;
    }

    public static void main(String args[]) {

        CustomLinkedList l = new CustomLinkedList();
        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(22);
        l.append(13);
        l.append(40);
        l.append(8);
        l.append(100);
        l.print();
        l.reverse();
        l.print();

        /*
         * l.prepend(7);
         * l.prepend(10);
         * l.print();
         * 
         * l.delete(7);
         * l.print();
         */

        // reverse
        // l.reverse();

        // get mid
        // int output = l.getMid();

        System.out.println("mid=" + output);
    }
}
