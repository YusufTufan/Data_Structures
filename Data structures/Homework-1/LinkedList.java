class LinkedList<T extends Comparable> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void addToEnd(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null)
            head = newNode;
        else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }
    public int size() {
        int count = 0;
        Node<T> iterator = head;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }
    public Node<T> getHead() {
        return head;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> iterator = head;
        while (iterator != null) {
            sb.append(iterator.value.toString()).append(" --> ");
            iterator = iterator.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public void display() {
        for (Node<T> i = head; i != null; i = i.next) {
            for (Node<T> j = i.next; j != null; j = j.next) {
                Student student1 = (Student) i.value;
                Student student2 = (Student) j.value;
    
                if (student1.getId() > student2.getId()) {
                    
                    T temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator.value );
            System.out.println();
            iterator = iterator.next;
        }

    }

    public void displayByAverage() {
        for (Node<T> i = head; i != null; i = i.next) {
            Student student1 = (Student) i.value;
            for (Node<T> j = i.next; j != null; j = j.next) {
                Student student2 = (Student) j.value;

                if (student1.calculateAverage() > student2.calculateAverage()) {

                    T temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }

        Node<T> iterator = head;
        while (iterator != null) {
            Student student = (Student) iterator.value;
            System.out.println(student.getOgrenciAdi() + " - Ortalama: " + student.calculateAverage());
            iterator = iterator.next;
        }
    }

    public void deleteStudentById(int Id) {
        Node<T> iterator = head;
        Node<T> prev = null;

        while (iterator != null) {
            if (((Student) iterator.value).getId() == Id) {
                if (prev == null) {
                    head = iterator.next;
                } else {
                    prev.next = iterator.next;
                }
                System.out.println("Öğrenci silindi: " + iterator.value);
                return;
            }
            prev = iterator;
            iterator = iterator.next;
        }
        System.out.println("Öğrenci bulunamadı.");
    }
        public boolean hasNext() {
            return current != null;
        }
        public T next() {
            if (!hasNext()) {
                throw new Exception();
            }
            T data = current.value;
            current = current.next;
            return data;
        }
}
