package com.lg.Tree;

/*
二分搜索树
 */
public class MyBst<E extends  Comparable<E>> {

    //定义Node节点
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
           this.e=e;
           left=null;
           right=null;
        }

    }
    //

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
       root= add2(root, e);
    }

    //添加数据
    private void add(Node node, E e) {
        if(e.equals(node.e)){
            return;
        }
        if(e.compareTo(node.left.e)<0&&node.left==null){
            node.left=new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.right.e)>0&&node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }
        if(e.compareTo(node.left.e)<0)
            add(node.left, e);
        if(e.compareTo(node.right.e)>0)
            add(node.right,e);

    }


    //添加方法的优化
    private Node add2(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0)
            node.left=add2(node.left,e);
        if(e.compareTo(node.e)>0)
            node.right=add2(node.right,e);
        return node;
    }

    //判断是否存在指定元素
    public boolean contains(Node node,E e){

        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0)
            return true;
       else if(e.compareTo(node.e)<0)
            return contains(node.left,e);
        else
            return contains(node.right,e);

    }

    //前置遍历
    public void preOrder(){
        preOrder(root);
    }

    //前置遍历
    private void preOrder(Node node) {
        if(node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    //中序遍历
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    //后置遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    // 寻找树的最小元素
    public E minimum(){
        if(isEmpty())
            throw new IllegalArgumentException("Tree is Empty");
        return minimum(root).e;
    }

    // 寻找二分搜索树的最小元素.....
    private Node minimum(Node node) {
        if(node.left==null)
            return node;
        return minimum(node.left);

    }

    //寻找树中的最大元素
    public E maximum(){
        if(isEmpty())
            throw new IllegalArgumentException("Tree is Empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right==null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E rem=minimum();
        removeMin(root);
        return rem;
    }

    //写递归先把出口写好
    private Node removeMin(Node node) {
        if(node.left==null) {
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;

    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E rem=maximum();
        removeMax(root);
        return rem;
    }

    private Node removeMax(Node node) {
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right=removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root=remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node==null)
            return null;
        if(e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        }
        if(e.compareTo(node.e)>0) {
            node.right = remove(node.right, e);
            return node;
        }else{
            if(node.left==null&&node.right==null) {
                size--;
                return null;
            }
            if(node.left==null&&node.right!=null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.left!=null&&node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            Node minNode=new Node(minimum(node.right).e);
            minNode.right=removeMin(node.right);
            minNode.left=node.left;
            node=null;
            return  minNode;
        }

    }


}
