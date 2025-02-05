class Student implements Comparable<Student> {
    private int Id;
    private String ogrenciAdi;
    private LinkedList<Course> dersler;

    public Student(int Id, String ogrenciAdi) {
        this.Id = Id;
        this.ogrenciAdi = ogrenciAdi;
        this.dersler = new LinkedList<>();
    }
    public void addCourse(Course ders) {
        dersler.addToEnd(ders);
    }
    public int getId() {
        return Id;
    }
    public String getOgrenciAdi() {
        return ogrenciAdi;
    }
    public LinkedList<Course> getDersler() {
        return dersler;
    }
    public double calculateAverage() {
        int total = 0;
        int count = 0;
        Node<Course> temp = dersler.getHead();
        while (temp != null) {
            total += temp.value.getNot();
            count++;
            temp = temp.next;
        }
        if (count == 0) {
            return 0;
        } else {
            return (double) total / count;
        }
    }
    public String toString() {
        return "Öğrenci numarası: " + Id + ", isim: " + ogrenciAdi + ", dersin adı: " + dersler;
    }
    public int compareTo(Student other) {
        return Integer.compare(this.Id, other.Id);
    }
}
