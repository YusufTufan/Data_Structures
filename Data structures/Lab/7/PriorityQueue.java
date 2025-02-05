public class PriorityQueue <T extends Comparable> {
    Node<T> head;
    Node<T> tail;

    public void enQueue(T val){
        Node<T> newNode=new Node<>(val);
        if(tail==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }

    }
    public void priorityEnqueue(T val){
        Node<T> newNode=new Node<>(val);
        if(tail==null) {
            head = tail = newNode;
        }else if(head.value.compareTo(val)<=0){
            newNode.next=head;
            head=newNode;
        }else if(tail.value.compareTo(val)>=0) {
            tail.next=newNode;
            tail=newNode;
        }else{
            Node<T> iterator=head, prev=head;
            while(iterator.value.compareTo(val)==1){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=newNode;
            newNode.next=iterator;
        }

    }
    public T deQueue() throws Exception {
        if(isEmpty()){
            throw  new Exception("queue is empty");
        }else{
            T temp=head.value;
            head=head.next;
            if(head==null)
                tail=null;
            return temp;
        }

    }

    public boolean isEmpty(){
        return head==null;

    }
    public void display(){
        Node<T> iterator=head;
        while (iterator.next!=null){
            System.out.print(iterator.value+"-->");
            iterator=iterator.next;
        }
        System.out.println(iterator.value);
    }


}

