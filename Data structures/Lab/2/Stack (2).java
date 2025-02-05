public class Stack {
    private int[] values;
    private int top;
    public Stack(int size){
        this.values=new int[size];
        this.top=-1;
    }
    public int size()
    {
        return this.values.length;
    }
    public void push(int val){
        if(!isFull())
        {
            this.top++;
            this.values[this.top]=val;
        }
    }
    public int pop() throws Exception {
        if(!isEmpty()){
            this.top--;
            return this.values[this.top+1];
        }else
        {
           throw new Exception("stack bos");
        }
    }

    public boolean isEmpty(){
        return this.top==-1;
    }
    public boolean isFull(){
        return this.top==this.values.length-1;
    }
    public void display(){
        for (int i = this.top; i>-1  ; i--) {
            System.out.println(this.values[i]);
        }
    }

}
