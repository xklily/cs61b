public class ArrayDeque<T>{
    private int Head;
    private int Tail;
    private T[] items;
    private int size;
    public ArrayDeque(){
        items = (T []) new Object[8];
        Head = 0;
        Tail = 0;
        size = 0;
    }
    private boolean cRoU(){
        double Rate = (double)size/items.length;
        if(Rate <= 0.25&&size>4){
            return false;
        }
        else{
            return true;
        }
    }
    private void elchangesize(){
        T[] a = (T []) new Object[size*2];
        if(Head > Tail) {
            System.arraycopy(items, Head, a, 0, items.length -Head + 1);
            System.arraycopy(items, 0, a, items.length -Head + 1, Tail);
        }
        else{
            System.arraycopy(items,Head,a,0,size);
        }
        items = a;
        Head = 0;
        Tail = size;
    }
    private void rdchangesize(){
        T[] a = (T []) new Object[items.length/2];
        if(Head > Tail) {
            System.arraycopy(items, Head, a, 0, items.length -Head + 1);
            System.arraycopy(items, 0, a, items.length -Head + 1, Tail);
        }
        else{
            System.arraycopy(items,Head,a,0,size);
        }
        items = a;
        Head = 0;
        Tail = size;
    }
    public int size(){
        return size;
    }
    public void addFirst(T item){
        if(Head == 0){
            Head = items.length-1;
            items[Head] = item;
        }
        else{
            Head--;
            items[Head] = item;
        }
        size++;
        if(size == items.length-1){
            this.elchangesize();
        }
    }
    public void addLast(T item){
        items[Tail] = item;
        size++;
        if(Tail == items.length){
            Tail = 0;
        }
        else{
            Tail++;
        }
        if(size == items.length-1){
            this.elchangesize();
        }
    }
    public T removeFirst(){
        if(Head == Tail){
            return null;
        }
        T temp = items[Head];
        if(Head == items.length-1){
            Head = 0;
        }
        else{
            Head ++;
        }
        size--;
        if(!this.cRoU()){
            this.rdchangesize();
        }
        return temp;
    }
    public T removeLast(){
        if(Head == Tail){
            return null;
        }
        T temp = items[Tail];
        if(Tail == 0){
            Tail = items.length-1;
        }
        else{
            Tail--;
        }
        size--;
        if(!this.cRoU()){
            this.rdchangesize();
        }
        return temp;
    }
    public T get(int index){
        if(index > size-1){
            return null;
        }
        else if(Head+index > items.length){
            return items[index-(Head-items.length+1)];
        }
        else{
            return items[Head+index];
        }
    }
    public boolean isEmpty(){
        if(Head == Tail) {
            return true;
        }
        else{
            return false;
        }
    }
    public void printDeque() {
        int p = Head;
        if(Head == Tail){
            System.out.println("The arraydeque is empty!");
        }
        while(p != Tail){
            System.out.print(items[p]+" ");
            if(p != items.length-1){
                p++;
            }
            else{
                p = 0;
            }
        }
    }
        }