import java.util.Scanner;

public class GenericStack <T extends Comparable>{
    private T [] values;
    private int top;
    public GenericStack(Class<T> dataType, int size){
        this.values= (T[])java.lang.reflect.Array.newInstance(dataType, size);
        this.top=-1;
    }
    public void push(T val){
        if(!isFull()){
            this.top++;
            this.values[this.top]=val;
        }else{
            System.out.println("stack dolu");
        }

    }
    public T pop() throws Exception {
        if(!isEmpty()){
            this.top--;
            return this.values[this.top+1];
        }else{
            throw  new Exception("stack bos");
//            System.out.println("stack boş");
//            return -1;//güzel bir çözüm değil
        }

    }
    public boolean isEmpty(){
        return this.top==-1;
//        if(this.top==-1)
//            return true;
//        else
//            return false;
    }
    public boolean isFull(){
        return this.top==this.values.length-1;
    }
    public void display(){
//        for (int i = this.top; i >-1 ; i--) {
//            System.out.println(this.values[i]);
//        }
        int temp=this.top;
        while(temp!=-1){
            System.out.println(this.values[temp]);
            temp--;
        }

    }
    public boolean search (T val){
        for (int i = 0; i <=this.top ; i++) {
            if (val.compareTo(this.values[i])==0)
                return true;
        }
        return false;
    }
    public void clear(){
        this.top=-1;
    }

    public static int postfixHesaplama(String hesaplanan) throws Exception{                     // Postfix ifadeyi hesaplayan fonksiyon
        
        GenericStack<Integer> stack = new GenericStack<>(Integer.class, 100000);  // 100,000 kapasiteye sahip bir GenericStack nesnesi oluşturur.
        
        String [] tutucular = hesaplanan.split("_");                                      // Gelen postfix ifadeyi "_" ile ayırarak bir diziye böler
        
        for(String tutucu : tutucular){                                                          // Her bir elemanı kontrol eden döngü
            
            if( isNumeric(tutucu)){                                                             // Eğer eleman sayı ise stack'e ekler
                stack.push(Integer.parseInt(tutucu));

            }else{                                                                              // İşlem operatörü olduğunda stack'ten iki değer çeker
                int value1 = stack.pop();
                int value2 = stack.pop();
                int result = 0;
                
                if(tutucu.equals("+")){                                                // Operatörün türüne göre işlem yapar
                    result = value1+value2;
                }else if(tutucu.equals("-")){
            
                    result = value2-value1;
                }else if(tutucu.equals("*")){
                    result = value1*value2;
                }else if(tutucu.equals("/")){
                    if(value2 ==0) throw new ArithmeticException("0 a Bölünemez");            // Sıfıra bölünmeyi kontrol eder
                    result = value1/value2;
                }else {
                    throw new IllegalArgumentException("Geçersiz durum: " + tutucu);
                }
                stack.push(result);                                                            // Hesaplanan sonucu stack'e ekler
            }
        }
        return stack.pop();                                                                    // stack'ten son elemanı döndürür
    }
   
    public static boolean isNumeric(String s){                                                 // Değer integera dönüşüyor mu kontrol fonksiyonu
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {                                                  // main fonksiyonu
        try {
            
            Scanner scan = new Scanner(System.in);   
            System.out.println("Postfix ifadeyi giriniz (örnek: 3_4_*_5_+): ");
            String deger = scan.nextLine(); 
            scan.close();
            
            int result = postfixHesaplama(deger);  
            System.out.println("Sonuç: " + result);  
        } catch (Exception e) {
             
            System.out.println("Hata: " + e.getMessage());
        }
    }
}