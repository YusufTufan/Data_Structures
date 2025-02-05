// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static <T extends Comparable> boolean search(CircularQueue<T> q, T val) throws Exception {
        boolean flag = false;
        for (int i = 0; i < q.count(); i++) {
            T temp = q.deQueue();
            if (val.compareTo(temp) == 0)
                flag = true;
            q.enQueue(temp);
        }
        return flag;

    }

    public static boolean Palindrome(String s) throws Exception{
        GenericStack<Character> stk = new GenericStack<>(Character.class, s.length());
        CircularQueue<Character> queue = new CircularQueue<>(Character.class, s.length() + 1);
        for (int i = 0; i < s.length(); i++) {
            stk.push(s.charAt(i));
            queue.enQueue(s.charAt(i));
        }
        for (int i = 0; i < s.length()/2; i++) {
            if(stk.pop()!=queue.deQueue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        CircularQueue<Integer> cq = new CircularQueue<>(Integer.class, 8);
        cq.enQueue(5);
        cq.enQueue(7);
        cq.enQueue(4);
        cq.enQueue(1);
        cq.enQueue(9);
        try {
            cq.deQueue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
        cq.display();
        System.out.println(cq.count());
        System.out.println(search(cq, 13));
        cq.display();
        System.out.println(Palindrome("abba"));
    }
}