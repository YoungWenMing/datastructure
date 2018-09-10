package binarysearchtree;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node{

        private K key;
        private V value;
        private Node  left, right;
        private int N;

        public Node(K key, V value, Node left, Node right, int N){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.N = N;
        }
    }

    public BST(K key, V value){
        root = new Node(key, value, null, null, 1);
    }

    public V get(K key){
        Node goal = getHelper(key, root);
        if(goal == null){
            System.out.println("no such key in the tree! ");
            return null;
        }
        else
            return goal.value;
    }

    private Node getHelper(K key, Node node){
        if(node == null || key.compareTo(node.key) == 0)
            return node;
        else if(key.compareTo(node.key) > 0)
            return getHelper(key, node.right);
        else
            return getHelper(key, node.left);
    }

    public void put(K key, V value){
        root = putHelper(key, value, root);
    }

    private Node putHelper(K key, V value, Node node){
        if(node == null)
            node = new Node(key, value, null, null, 1);
        else if(node.key.compareTo(key) == 0){
            node.value = value;
        }else if(node.key.compareTo(key) > 0){
            node.left = putHelper(key, value, node.left);
        }else
            node.right = putHelper(key, value, node.right);
        node.N = countSize(node);
        return node;
    }

    private int countSize(Node node){
        if(node == null)
            return 0;
        else
            return size(node.right) + size(node.left) + 1;
    }

    private int size(Node node){
        if(node == null)    return  0;
        return node.N;
    }

    public int size(){

        return root.N;
    }
}
