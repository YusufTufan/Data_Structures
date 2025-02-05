import java.io.*;
public class homework2 {
     public static void main(String[] args) {  
         LinkedList<Integer> list = new LinkedList<>();
         
        //Dosyadan okuma ve linkedList'e ekleme

        try {
            BufferedReader forSource = new BufferedReader(new FileReader("C:\\Users\\yusuf\\Desktop\\24-25 güz\\VERİ YAPILARI\\HOMEWORK\\Homework2\\Source.txt"));
            String [] sourceValues = forSource.readLine().split(",");
            for (String value : sourceValues) {
                int sayi = Integer.parseInt(value);
                if (!list.search(sayi)) {
                    list.addToEnd(sayi);
                }
            }
            forSource.close();
        } catch (IOException e) {
            System.out.println("Dosya okunamadı.");
        }

        System.out.println(">> Oluşan linkedlist :");
        list.display();
        System.out.println("------------------------------------------------------------------------------------");

        int klasikToplamErisim = 0, klasikAramaSayisi = 0;

        //Klasik arama

        try {
            BufferedReader forSearch = new BufferedReader(new FileReader("C:\\Users\\yusuf\\Desktop\\24-25 güz\\VERİ YAPILARI\\HOMEWORK\\Homework2\\Search.txt"));
            String[] searchValues = forSearch.readLine().split(",");
            for (String value : searchValues) {
                int sayi = Integer.parseInt(value);
                klasikToplamErisim += list.countSearch(sayi);
                klasikAramaSayisi++;
            }
            forSearch.close();
        } catch (IOException e) {
            System.out.println("Dosya okunamadı.");
        }

        double KlasikOrtalamaBellekErisim = (double) klasikToplamErisim / klasikAramaSayisi;

        System.out.println(">> Klasik arama toplam bellek erişim : " + klasikToplamErisim);
        System.out.println(">> Klasik arama ortalama bellek erişim : " + KlasikOrtalamaBellekErisim);
        System.out.println("------------------------------------------------------------------------------------");

        //Yer değiştirme ile arama

        int yerDegistirmeToplamErisim = 0, yerDegistirmeAramaSayisi = 0;

        try {
            BufferedReader forSearch = new BufferedReader(new FileReader("C:\\Users\\yusuf\\Desktop\\24-25 güz\\VERİ YAPILARI\\HOMEWORK\\Homework2\\Search.txt"));
            String[] searchValues = forSearch.readLine().split(",");
            for (String value : searchValues) {
                int sayi = Integer.parseInt(value);
                yerDegistirmeToplamErisim += list.findAndAddtoFront(sayi);
                yerDegistirmeAramaSayisi++;
            }
            forSearch.close();
        } catch (IOException e) {
            System.out.println("Dosya okunamadı.");
        }

        double YerDegistirmeOrtalamaBellekErisim = (double) yerDegistirmeToplamErisim / yerDegistirmeAramaSayisi;

        System.out.println(">> Yer değiştirme ile arama toplam bellek erişimi : " + yerDegistirmeToplamErisim);
        System.out.println(">> Yer değiştirme ile arama ortalama bellek erişimi : " + YerDegistirmeOrtalamaBellekErisim);
        System.out.println("------------------------------------------------------------------------------------");

        if (KlasikOrtalamaBellekErisim > YerDegistirmeOrtalamaBellekErisim) {
            System.out.println(">> Yer değiştirme Algoritmasi daha iyi");
        } else {
            System.out.println(">> Klasik arama Algoritmasi daha iyi");
        }
    }
   }