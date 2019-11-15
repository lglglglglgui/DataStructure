package com.lg.Map;

public class MyLinkedListMap<K,V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value ,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public Node(K key,V value){
            this(key, value,null);
        }

        public Node(){
            this(null,null,null);
        }
    }

    private Node dummyNode;
    private int size;

    public MyLinkedListMap(){
        dummyNode=new Node();
        size=0;
    }

    @Override
    public void add(K key, V value) {
        Node node=getNode(key);
        if(value==null) {
            dummyNode.next = new Node(key, value, dummyNode.next);
            size++;

        }else
            node.value=value;
    }

    @Override
    public V remove(K key) {
        Node pre=dummyNode;
        while (pre.next!=null){
            if(pre.next.key.equals(key))
                break;
            pre=pre.next;
        }

        if(pre.next!=null){
            Node del=pre.next;
            pre.next=del.next;
            del.next=null;
            size--;
            return del.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {

        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(key);
       return node==null? null:node.value;
    }

    private Node getNode(K key){
        Node cur = dummyNode.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void set(K key, V newValue) {
      Node node=getNode(key);
      if(node==null)
          throw new IllegalArgumentException(key+"doesn't exist");
      node.value=newValue;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
