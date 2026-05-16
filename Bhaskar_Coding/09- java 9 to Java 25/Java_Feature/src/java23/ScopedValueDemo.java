package java23;
//Scoped Values for Safer Memory Management (JEP 441)
public class ScopedValueDemo {
    public static ScopedValue<String> current_User= ScopedValue.newInstance();

    public static void main() {

        ScopedValue.where(current_User,"bhaskar").run(()-> System.out.println("Current_user "+current_User.get()));
    }
}
