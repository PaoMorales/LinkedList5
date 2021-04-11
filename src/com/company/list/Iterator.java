package com.company.list;

public class Iterator {
    private Node currentnode;

    public Iterator(com.company.list.Node currentnode) {
        this.currentnode = currentnode;
    }

    public Iterator(Iterator iterator){
        currentnode = iterator.currentnode;
    }

    public boolean hasNext(){
        return currentnode != null;
    }

    public int next(){
        int data = currentnode.getData();
        currentnode = currentnode.getNext();
        return  data;
    }

    Node getCurrentnode(){
        return currentnode;
    }
}
