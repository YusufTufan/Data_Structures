public class LinkedList <T extends Comparable>{
    private Node<T> head;

    public LinkedList(){
        this.head=null;
    }
    public void addToFront(T val){
        Node<T> newNode=new Node<>(val);
        newNode.next=head;
        head=newNode;
    }
    public void addToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if(head==null)
            head=newNode;
        else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }
    public boolean search(T val){
        Node<T> iterator=head;
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }
    public int countSearch(T val) {
        Node<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            if (iterator.value.compareTo(val) == 0) {
                return count;
            }
            iterator = iterator.next;
        }
        return count;
    }
    public int findAndAddtoFront(T val) {
        Node<T> iterator = head;
        Node<T> prev = null;
        int count = 0;

        while (iterator != null) {
            count++;
            if (iterator.value.compareTo(val) == 0) {
                if (prev != null) {
                    prev.next = iterator.next;
                    iterator.next = head;
                    head = iterator;
                }
                return count;
            }
            prev = iterator;
            iterator = iterator.next;
        }
        return count;
    }
    public void display(){
        if(head!=null) {
            Node<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }
    public void sortedInsert(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
        }else if(head.value.compareTo(val)==1){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=1 ){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=newNode;
            newNode.next=iterator;

        }
    }
    public void delete(T val){
        if(!search(val)){
            return;
        }else if(head.value.compareTo(val)==0){
            head=head.next;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator.value.compareTo(val)!=0){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=iterator.next;
        }
    }
}