package com.company.list;

import static  com.company.list.Position.AFTER;
import static  com.company.list.Position.BEFORE;


public class LinkedList<G> implements List<G> {

    private static class Node<T> {
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private  Node<G> head;
    private Node<G> tail;
    private int size;

    public class Iterator implements IteratorG <G>{
        private Node<G> currentNode;

        public Iterator(){
            this.currentNode = head;
        }

        public Iterator(Iterator iterator){
            currentNode = iterator.currentNode;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }

        Node <G> getCurrentNode(){
            return currentNode;
        }
    }

    public class ReverseIterator implements IteratorG<G>{
        private Node<G> currentNode;

        public ReverseIterator(){
            this.currentNode = tail;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.previous;
            return data;
        }
    }

    public  LinkedList(){
        listsCount ++;
    }

    private static int listsCount = 0;

    private static int getListCount(){
        return  listsCount;
    }

    @Override
    public  void add(G data){
        Node<G> node = new Node<>(data);
        node.previous = tail;

        if(tail != null){
            tail.next = node;
        }

        if(head == null){
            head = node;
        }

        tail = node;
        size++;
    }

    @Override
    public G get (int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index){
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.data;
    }

    @Override
    public void delete(int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size){
            return;
        }
        size--;

        if (size == 0){
            head = null;
            tail = null;
            return;
        }

        if (index == size){
            tail = tail.previous;
            tail.next = null;
        }

        if (index == 0){
            head = head.next;
            head.previous = null;
        }

        if (index > 0 && index < size){
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    @Override
    public void insert(G data, Position position, IteratorG<G> it){
        Node<G> newNode = new Node(data);
        Node<G> currentnode = ((Iterator)it).getCurrentNode();

        if (position == AFTER){
            newNode.next =currentnode.next;
            newNode.previous = currentnode;
            currentnode.next = newNode;
            if (newNode.next != null){
                newNode.previous.next = newNode;
            }
            else{
                tail = newNode;
            }
        }
        else if (position == BEFORE){
            newNode.previous = currentnode.previous;
            newNode.next = currentnode;
            currentnode.previous =newNode;
            if (newNode.previous != null){
                newNode.previous.next = newNode;
            }
            else{
                head = newNode;
            }
        }
        else{
            System.out.println(" No existe posicion ");
        }
        size++;

    }

    @Override
    public IteratorG<G> getReverseIterator() {
        return null;
    }

    public  Iterator getIterator(){
        return new Iterator();
    }



    public ReverseIterator getReverseItarator(){
        return new ReverseIterator();
    }

    @Override
    public int getSize(){
        return  size;
    }
}


