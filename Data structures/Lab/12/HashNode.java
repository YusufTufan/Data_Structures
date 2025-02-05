public class HashNode <T extends Comparable>{
    int key;
    T value;
    HashNode<T> next;
    public HashNode(int key, T val){
        this.key=key;
        this.value=val;
        this.next=null;
    }
    public String toString(){
        return this.key + ":" + this.value;
    }
}
