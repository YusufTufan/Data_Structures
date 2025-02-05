public class SeperateChaining<T extends Comparable> {
    HashNode<T>[] indexes;

    public SeperateChaining(int size) {
        indexes = new HashNode[size];
    }

    public int hash(int key) {
        return key % indexes.length;
    }

    public void insert(int key, T value) throws Exception {
        int index = hash(key);
        if (search(key)) {
            throw new Exception("aynı anahtar değerine sahip kayıt mevcut");
        } else {
            HashNode<T> newNode = new HashNode<>(key, value);
            if (indexes[index] == null) {
                indexes[index] = newNode;
            } else {
                HashNode<T> iterator = indexes[index];
                while (iterator.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = newNode;
            }
        }
    }

    public boolean search(int key) {
        HashNode<T> iterator = indexes[hash(key)];
        while (iterator != null) {
            if (iterator.key == key) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }
    public void display() {
        for (int i = 0; i < indexes.length; i++) {
            HashNode<T> iterator = indexes[i];
            System.out.print(i+" ");
            while (iterator != null) {
                System.out.print("-->" + iterator );
                iterator = iterator.next;
            }
            System.out.println();
        }
    }
    public void delete(int key) {
        if(search(key)) {
            HashNode<T> iterator = indexes[hash(key)];
            //evde tamamlayınız

            

        }
    }


}
