public class Ltest {
    public static void main(String[] args) {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for(int i=0;i<100;i++){
            lld.addLast(i);
        }
        System.out.println(lld.getRecursive(2));

//        for(int i=0;i<10;i++){
//            System.out.print(lld.getRecursive(i)+" ");
//            if(i % 20 == 0){
//                System.out.println();
//            }
//        }
        for(int i=0;i<100;i++){
            System.out.print(lld.get(i)+" ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }
}
