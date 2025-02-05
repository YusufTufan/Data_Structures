import java.io.*;
class FileReaderExample {
    public static LinkedList<Student> readStudentsFromFile(String fileName) {
        LinkedList<Student> studentList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Okunan satır: " + line);
                String[] parts = line.split("\\s+");
                int Id = Integer.parseInt(parts[0]);
                String ogrenciAdi = parts[1] + " " + parts[2];

                Student student = new Student(Id, ogrenciAdi);

                for (int i = 3; i < parts.length; i ++) {
                    String dersAdi = parts[i];
                    if (i + 1 < parts.length && isNumeric(parts[i + 1])){
                    double not = Double.parseDouble(parts[i + 1]);
                    student.addCourse(new Course(dersAdi, not));
                    i++;
                    }
                }

                studentList.addToEnd(student);
            }
        } catch (IOException e) {
            System.err.println("Dosya okunamadı: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Geçersiz veri formatı: " + e.getMessage());
        }
        return studentList;
    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
