import javax.naming.InsufficientResourcesException;

public class LinkedListDeque<T>{
    private IntNode sentFront;
    private IntNode sentBack;
    private int size;
    public class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode p,T i,IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
    public LinkedListDeque(){
        sentFront = new IntNode(null,null,null);
        sentBack = new IntNode(null,null,null);
        sentFront.next=sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }
    public void addFirst(T item){
        if(sentFront.next == sentBack) {
            sentFront.next = new IntNode(sentFront,item,sentBack);
            sentBack.prev = sentFront.next;
            size++;
        } else{
            IntNode temp = sentFront.next;
            sentFront.next = new IntNode(sentFront, item, sentFront.next);
            temp.prev = sentFront.next;
            size++;
        }
    }
    public void addLast(T item){
        if(sentFront.next == sentBack) {
            sentFront.next = new IntNode(sentFront,item,sentBack);
            sentBack.prev = sentFront.next;
            size++;
        }
        else {
            IntNode temp = sentBack.prev;
            sentBack.prev = new IntNode(sentBack.prev, item, sentBack);
            temp.next = sentBack.prev;
            size++;
        }    }
    public boolean isEmpty(){
        if(sentFront.next == sentBack){
            return true;
        }
        else{
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        IntNode p = sentFront.next;
        while(p.next != null){
            System.out.print(p.item+" ");
            p = p.next;
        }
    }
    public T removeFirst(){
        if(sentFront.next == sentBack){
            return null;
        }
        else{
            IntNode temp = sentFront.next;
            sentFront.next = sentFront.next.next;
            sentFront.next.prev = sentFront;
            size--;
            return temp.item;
        }
    }
    public T removeLast(){
        if(sentBack.prev == sentFront){
            return null;
        }
        else {
            IntNode temp = sentBack.prev;
            sentBack.prev = sentBack.prev.prev;
            sentBack.prev.next = sentBack;
            size--;
            return temp.item;
        }
    }
    public T get(int index){
        if(index > size-1){
            return null;
        }
        int i = 0;
        IntNode p = sentFront.next;
        while(i<index){
            i++;
            p = p.next;
        }
        return p.item;
    }
    public T getRecursive(int index) {
        if(index > size-1){
            return null;
        }
        if (index == 0)
            return sentFront.next.item;
        else {
            sentFront.next = sentFront.next.next;
            return getRecursive(index-1);
        }
    }
    }