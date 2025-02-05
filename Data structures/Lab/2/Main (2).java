// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
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
    public static void main(String[] args) throws Exception {
      Stack s=new Stack(6);
        s.push(5);
        s.push(7);
        s.push(2);
        s.display();
        try {
            System.out.println("min val:"+ findMin(s));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(search(s,5));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        remove(s, 7);
        s.display();
    }
}