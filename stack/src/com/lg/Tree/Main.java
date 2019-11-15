package com.lg.Tree;

import com.lg.Tree.MyBst;

public class Main {
    public static void main(String[] args) {
        int[] ints={25,47,2,68,62,39,56,18};
        MyBst<Integer> bst=new MyBst<>();
        for(int i:ints){
            bst.add(i);
        }
        System.out.println("----前序遍历----");
        System.out.println("size:"+bst.getSize());
        System.out.println("--删除数据--");
        bst.remove(47);
        bst.preOrder();
        System.out.println("size:"+bst.getSize());
    }
}
