package com.company.list;

public class LinkedList {

    public  static final int BEFORE = 0;
    public static  final int AFTER = 0;

    private Node head;
    private Node tail;
    private int size;

    public void add(int data){
        Node node = new Node(data);
        node.setPrevious(tail);

        if(tail != null){
            tail.setNext(node);
        }

        if(head == null){
            head = node;
        }

        tail = node;
        size++;
    }
    public int getSize(){
        return size;
    }

    public int get (int index){
        Node currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index){
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }

    public void delete(int index){
        Node currentNode = head;
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
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        if (index > 0 && index < size){
            while (currentIndex < index){
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
    }

    public  Iterator getIterator(){
        return new Iterator(head);
    }

    public void insert(int data, int position, Iterator ite){
        Node newNode = new Node(data);
        Node currentnode = ite.getCurrentnode();

        if (position == AFTER){
            newNode.setNext(currentnode.getNext());
            newNode.setPrevious(currentnode);
            currentnode.setNext(newNode);
            if (newNode.getNext() != null){
                newNode.getNext().setPrevious(newNode);
            }
            else{
                tail = newNode;
            }
        }
        else if (position == BEFORE){
            newNode.setPrevious(currentnode.getPrevious());
            newNode.setNext(currentnode);
            currentnode.setPrevious(newNode);
            if (newNode.getPrevious() != null){
                newNode.getPrevious().setPrevious(newNode);
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

    public ReverseIterator getReverseItarator(){
        return new ReverseIterator(tail);
    }
}


