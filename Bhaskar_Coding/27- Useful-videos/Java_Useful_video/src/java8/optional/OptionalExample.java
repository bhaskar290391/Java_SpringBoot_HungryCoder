package java8.optional;

import java.util.Optional;

class OptionalUserData{

    public Optional<String> getUserById(int id){
        if(id==0){
            return Optional.empty();
        }else{
            return  Optional.ofNullable("Bhaskar");
        }
    }
}
public class OptionalExample {
    static void main() {
        OptionalUserData data=new OptionalUserData();
        Optional<String> user= data.getUserById(123);

        user.ifPresentOrElse(u-> System.out.println("The user is "+u),
                ()-> System.out.println("No matched"));
    }
}
