package collections;
class Generic<T>{
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
public class GenericVSLegacy {
    static void main() {
        Generic<Integer> intData=new Generic<>();
        intData.setObject(25);
        int data= intData.getObject();
        System.out.println(data);

        Generic<String> stringData=new Generic<>();
        stringData.setObject("bhaskar");
        String  bhas = stringData.getObject();
        System.out.println(bhas);
    }


}
