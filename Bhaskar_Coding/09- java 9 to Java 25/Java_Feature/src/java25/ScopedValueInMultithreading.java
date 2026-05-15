package java25;

public class ScopedValueInMultithreading {
   public static ThreadLocal Current_User=new ThreadLocal();
    private static final ScopedValue<String> CURRENT_USER_SCOPED = ScopedValue.newInstance();
    static void main() {
        processRequest("bhaskar");
        processRequestByScopedValue();
    }

    public static void processRequestByScopedValue() {
     ScopedValue.where(CURRENT_USER_SCOPED, "Maddy").run(ScopedValueInMultithreading::doWorkByScoped);
    }

    private static void doWorkByScoped() {
        System.out.println(CURRENT_USER_SCOPED.get());
    }

    public static void processRequest(String data){
        Current_User.set(data);
        try{

        doWork();

        }finally {
            Current_User.remove();
        }
    }

    public static void doWork() {
        System.out.println(Current_User.get());
    }
}
