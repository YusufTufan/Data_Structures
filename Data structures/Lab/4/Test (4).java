public class Test {
    public static int sum(int n){
        if(n==0)
            return 0;
        else
            return n+sum(n-1);
    }
    public static int faktoriyel(int n){
        if(n==0)
            return 1;
        else
            return n*faktoriyel(n-1);
    }
    public boolean search(int val, Stack s){
        return true;
    }

    public static boolean search(Stack s, int val) throws Exception {
        Stack tempStack=new Stack(s.size());
        int temp=0;
        boolean flag=false;
        while(!s.isEmpty()){
            temp=s.pop();
            tempStack.push(temp);
            if(temp==val){
                flag=true;
                break;
            }
        }
        while(!tempStack.isEmpty()){
            s.push(tempStack.pop());
        }

        return flag;


    }
    public static  int findMin(Stack s) throws Exception{
        Stack tempStack=new Stack(s.size());
        int min=s.pop();
        tempStack.push(min);
        while(!s.isEmpty()){
            int tempValue=s.pop();
            if(tempValue<min)
                min=tempValue;
            tempStack.push(tempValue);
        }
        while(!tempStack.isEmpty()){
            s.push(tempStack.pop());
        }
        return min;
    }
    public static void remove(Stack s, int val) throws Exception {
        Stack tempStack=new Stack(s.size());
        if(!search(s,val))
            return;
        int temp=0;
        while (!s.isEmpty()){
            temp=s.pop();
            if(temp==val) {
                break;
            }
            tempStack.push(temp);
        }
        while(!tempStack.isEmpty()){
            s.push(tempStack.pop());
        }

    }

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
        Node<Integer> n=new Node<>(5);
        System.out.println(n);






        LinkedList<Integer> myList=new LinkedList<>();
        myList.addToEnd(6);
        myList.addToEnd(8);
        myList.addToEnd(2);
        myList.addToFront(4);
        myList.display();
        System.out.println(myList.search(14));


//        CircularQueue<Integer> myQueue=new CircularQueue<>(Integer.class, 5);
//        myQueue.enQueue(6);
//        myQueue.enQueue(7);
//        myQueue.deQueue();
//        myQueue.enQueue(9);
//        myQueue.enQueue(1);
//        myQueue.display();

//        GenericStack<String> stk=new GenericStack<>(String.class, 5);
//        stk.push("a");
//        stk.push("b");
//        stk.display();
//        GenericStack<Integer> stkInt=new GenericStack<>(Integer.class, 5);
//        stkInt.push(5);
//        stkInt.push(6);
//        stkInt.display();
//        System.out.println(stk.search("a"));
//        Car c=new Car(2.0, "toyota");
//        Car c2=new Car(1.6, "seat");
//        Car c3=new Car(1.6, "seat");
//
//        GenericStack<Car> stkCar=new GenericStack<>(Car.class,5);
//        stkCar.push(c);
//        stkCar.push(c2);
//        //stkCar.push(new Car(2.0, "toyota"));
//        stkCar.display();
//        System.out.println(stkCar.search(c3));
//        Stack stk=new Stack(5);
//        try {
//            stk.push(5);
//            stk.push(7);
//            stk.push(3);
//            stk.pop();
//            stk.push(8);
//            stk.display();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        MyArray m1=new MyArray();
//        //m1.display();
//        int [] n={6,3,1,0};
//        MyArray m2=new MyArray(n);
//        System.out.println(m2.search(1));
//        m2.bubbleSort();
//        m2.display();
    }
}