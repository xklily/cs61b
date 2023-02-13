public class ArrayDeque<T>{
    private int Front;
    private int Back;
    private T[] items;
    private int size;
    public ArrayDeque(){
        items = (T []) new Object[8];
        Front = 0;
        Back = 0;
        size = 0;
    }
    public boolean cRoU(){
        int Rate = size/items.length;
        if(Rate <= 0.25){
            return false;
        }
        else{
            return true;
        }
    }
    public void elchangesize(){
        T[] a = (T []) new Object[size*2];
        System.arraycopy(items,Front,a,0,Front-items.length+1);
        System.arraycopy(items,0,a,Front-items.length+1,Back);
        items = a;
        Front = 0;
        Back = size-1;
    }
    public void rdchangesize(){
        T[] a = (T []) new Object[size/2];
        System.arraycopy(items,Front,a,0,Front-items.length+1);
        System.arraycopy(items,0,a,Front-items.length+1,Back);
        items = a;
        Front = 0;
        Back = size-1;
    }
    public void addFirst(T item){
        if(Front == 0){
            items[items.length-1] = item;
            Front = items.length-1;
            size++;
        }
        else{
            Front--;
            items[Front] = item;
            size++;
        }
        if(size == items.length){
            this.elchangesize();
        }
    }
    public void addLast(T item){
        items[Back] = item;
        Back++;
        size++;
        if(size == items.length){
            this.elchangesize();
        }
    }
    public T removeFirst(){
        T temp = items[Front];
        if(Front == items.length-1){
            Front = 0;
        }
        else{
            Front ++;
        }
        if(!this.cRoU()){
            this.rdchangesize();
        }
        return items[Front];
    }
    public T removeLast(){
        T temp = items[Back];
        if(Back == 0){
            Back = items.length-1;
        }
        else{
            Back--;
        }
        if(!this.cRoU()){
            this.rdchangesize();
        }
        return temp;
    }
    public T get(int index){
        if(index > size-1){
            return null;
        }
        else if(Front+index > items.length){
            return items[index-(Front-items.length+1)];
        }
        else{
            return items[Front+index];
        }
    }
        }