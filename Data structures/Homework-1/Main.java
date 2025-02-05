import java.util.*;
public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\yusuf\\Desktop\\24-25 güz\\veri_yapilari\\homework\\Homework3\\students.txt"; 
        LinkedList<Student> studentList = FileReaderExample.readStudentsFromFile(fileName);

        Scanner scanner = new Scanner(System.in);
        int tercih;

        do {
            System.out.println("\n****************Öğrenci Yönetim Sistemi*******************");
            System.out.println("1> Numaralarına Göre Listele");
            System.out.println("2> Genel Ortalamalarına Göre Listele");
            System.out.println("3> Öğrenci Sil");
            System.out.println("4> Öğrenci Ekle");
            System.out.println("5> Öğrenci Sayısını Göster");
            System.out.println("6>> Çıkış");
            System.out.print("Seçiminizi yapınız: ");
            tercih = scanner.nextInt();

            switch (tercih) {
                case 1:
                    System.out.println("\nÖğrenciler (Numaralarına göre):");
                    studentList.display();
                    break;

                case 2:
                    System.out.println("\nÖğrenciler (Ortalama notlarına göre):");
                    studentList.displayByAverage();
                    break;

                case 3:
                    System.out.print("Silmek istediğiniz öğrenci numarasını giriniz: ");
                    int silinecek = scanner.nextInt();
                    studentList.deleteStudentById(silinecek);
                    break;

                case 4:
                    System.out.println("\nYeni Öğrenci Ekle:");

                    System.out.print("Öğrenci numarasını giriniz: ");
                    int Id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Öğrenci adını giriniz: ");
                    String ogrenciAdi = scanner.nextLine();

                    Student newStudent = new Student(Id, ogrenciAdi);

                    System.out.print("Ders sayısını giriniz: ");
                    int ders_sayisi = scanner.nextInt();
                    scanner.nextLine(); 

                    for (int i = 0; i < ders_sayisi; i++) {
                        System.out.print("Ders adı: ");
                        String dersAdi = scanner.nextLine();
                        System.out.print("Notu: ");
                        double not = scanner.nextDouble();
                        scanner.nextLine();

                        newStudent.addCourse(new Course(dersAdi, not));
                    }
                    studentList.addToEnd(newStudent);

                    System.out.println("Yeni öğrenci başarıyla eklendi: " + newStudent);
                    break;

                case 5:
                    System.out.println("\nToplam öğrenci sayısı: " + studentList.size());
                    break;

                case 6:
                    System.out.println("Sistemden çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyiniz.");
            }
        } while (tercih != 6);

        scanner.close();
    }
}
