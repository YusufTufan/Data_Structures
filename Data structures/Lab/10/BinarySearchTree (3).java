public class BinarySearchTree<T extends Comparable> {

    private TNode<T> root;

    public void insert(T val) throws Exception {
        TNode<T> newNode = new TNode<>(val);
        if (root == null) {
            root = newNode;
        } else {
            TNode<T> iterator = root;
            while (iterator != null) {
                if (val.compareTo(iterator.value) == -1) {
                    if (iterator.left == null) {
                        iterator.left = newNode;
                        return;
                    }
                    iterator = iterator.left;
                } else if (val.compareTo(iterator.value) == 1) {
                    if (iterator.right == null) {
                        iterator.right = newNode;
                        return;
                    }
                    iterator = iterator.right;
                } else
                    throw new Exception("aynı değerden iki tane olamaz");
            }
        }
    }

    public void inorder() {

        inorder(root);
        System.out.println();
    }

    public void inorder(TNode<T> tempRoot) {
        if (tempRoot != null) {
            inorder(tempRoot.left);
            System.out.print(tempRoot.value + " ");
            inorder(tempRoot.right);

        }
    }

    public boolean search(T val) {
        TNode<T> iterator = root;
        while (iterator != null) {
            if (val.compareTo(iterator.value) == -1)
                iterator = iterator.left;
            else if (val.compareTo(iterator.value) == 1)
                iterator = iterator.right;
            else
                return true;
        }
        return false;
    }

    public boolean recursiveSearch(T val) {
        return recursiveSearch(root, val);
    }

    public boolean recursiveSearch(TNode<T> tempRoot, T val) {
        if (tempRoot == null)
            return false;
        else if (val.compareTo(tempRoot.value) == -1) {
            return recursiveSearch(tempRoot.left, val);
        } else if (val.compareTo(tempRoot.value) == 1) {
            return recursiveSearch(tempRoot.right, val);
        } else
            return true;

    }

    public TNode<T> findNode(T val) {
        TNode<T> iterator = root;
        while (iterator != null) {
            if (val.compareTo(iterator.value) == -1)
                iterator = iterator.left;
            else if (val.compareTo(iterator.value) == 1)
                iterator = iterator.right;
            else
                return iterator;
        }
        return null;
    }

    public boolean isLeaf(T val) {
        TNode<T> current = findNode(val);
        if (current != null && current.left == null && current.right == null)
            return true;
        return false;
    }

    public TNode<T> findParent(T val) throws Exception {
        if (!search(val))
            throw new Exception("değer ağaçta yok");
        else {
            TNode<T> iterator = root, parent = null;
            while (iterator.value.compareTo(val) != 0) {
                parent = iterator;
                if (val.compareTo(iterator.value) == -1)
                    iterator = iterator.left;
                else
                    iterator = iterator.right;
            }
            return parent;
        }
    }

    public TNode<T> inorderSuccessor(T val) {
        if (!search(val))
            return null;
        TNode<T> iterator = findNode(val).right;
        while (iterator.left != null)
            iterator = iterator.left;
        return iterator;

    }

    public void delete(T val) throws Exception {
        if (search(val)) {
            if (val.compareTo(root.value) == 0 && root.left == null &&
                    root.right == null) {
                root = null;
                return;
            }
            if (val.compareTo(root.value) == 0 && root.right == null) {
                root = root.left;
                return;
            }
            if (val.compareTo(root.value) == 0 && root.left == null) {
                root = root.right;
                return;
            }
            TNode<T> current = findNode(val);
            TNode<T> parent = findParent(val);
            if (isLeaf(val)) {//yaprak ise
                if (parent.right != null && parent.right.value.compareTo(val) == 0)
                    parent.right = null;
                else
                    parent.left = null;
                return;
            }
            if (current.left != null && current.right != null) {//çift çocuklu
                TNode<T> successor = inorderSuccessor(val);
                T successorValue = successor.value;
                delete(successorValue);
                current.value = successorValue;
                return;
            }
            //buraya geldiyse tek çocukludur
            if (val.compareTo(parent.right.value) == 0) {
                if (current.left != null)
                    parent.right = current.left;
                else
                    parent.right = current.right;
            } else {
                if (current.left != null)
                    parent.left = current.left;
                else
                    parent.left = current.right;
            }
        }
    }

    public int height() {
        return height(root);

    }

    private int height(TNode<T> root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    public int balance(){
        return balance(root);
    }
    public int balance(TNode<T> root) {

        return height(root.right) - height(root.left);
    }


    public void AVLInsert(T val) throws Exception {
        insert(val);
        TNode<T> inserted = findNode(val);
        TNode<T> parent = findParent(val);
        TNode<T> grandparent = null;
        while (true) {

            if (parent != null)
                grandparent = findParent(parent.value);
            else
                return;
            if (grandparent != null) {

                if (balance(grandparent) > 1) {

                    if (grandparent.right == parent && inserted == parent.right) {
                        // single rotation rotate left
                        TNode<T> parentOfGrandparent = findParent(grandparent.value);
                        if (parentOfGrandparent != null && parentOfGrandparent.left == grandparent) {
                            parentOfGrandparent.left = parent;
                        } else if (parentOfGrandparent != null)
                            parentOfGrandparent.right = parent;
                        TNode<T> temp = parent.left;
                        parent.left = grandparent;
                        grandparent.right = temp;
                        if (root == grandparent)
                            root = parent;
                        return;

                    } else if (grandparent.right == parent && inserted == parent.left) {
                        //double rotation right and left.
                        //rotate right
                        grandparent.right = parent.left;
                        TNode<T> temp = inserted.right;
                        inserted.right = parent;
                        parent.left = temp;
                        //rotate left
                        if (root == grandparent)
                            root = inserted;
                        temp = inserted.left;
                        inserted.left = grandparent;
                        grandparent.right = temp;
                        return;
                    }
                } else if (balance(grandparent) < -1) {
                    if (grandparent.left == parent && inserted == parent.left) {
                        //sigle rotation rotate right
                        TNode<T> parentOfGrandparent = findParent(grandparent.value);
                        if (parentOfGrandparent != null && parentOfGrandparent.left == grandparent) {
                            parentOfGrandparent.left = parent;
                        } else if (parentOfGrandparent != null)
                            parentOfGrandparent.right = parent;
                        TNode<T> temp = parent.right;
                        parent.right = grandparent;
                        grandparent.left = temp;
                        if (root == grandparent)
                            root = parent;
                        return;
                    } else if (grandparent.left == parent && inserted == parent.right) {
                        //double rotation right and left.
                        //rotate right
                        grandparent.left = parent.right;
                        TNode<T> temp = inserted.left;
                        inserted.left = parent;
                        parent.right = temp;
                        //rotate left
                        if (root == grandparent)
                            root = inserted;
                        temp = inserted.right;
                        inserted.right = grandparent;
                        grandparent.left = temp;
                        return;
                    }
                }
            }

            inserted = parent;
            parent = grandparent;

        }
    }
}











