class Course implements Comparable<Course> {
    private String dersAdi;
    private double not;

    public Course(String dersAdi, double not) {
        this.dersAdi = dersAdi;
        this.not = not;
    }
    public double getNot() {
        return not;
    }
    public String getdersAdi() {
        return dersAdi;
    }
    public int compareTo(Course other) {
        return this.dersAdi.compareTo(other.dersAdi);
    }
    public String toString() {
        return dersAdi + " (" + not + ")";
    }
}