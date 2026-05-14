package java8.optional;

import java.util.Optional;

class UserDetails{

    public Optional<String> findUserByUserId(int userId){

        if(userId ==0){
           return  Optional.empty();
        }else{
           return  Optional.ofNullable("Bhaskar");
        }
    }
}

public class OptionalExampleDemo {
    static void main() {
        UserDetails data =new UserDetails();
        Optional<String> userData=data.findUserByUserId(1234);

        userData.ifPresentOrElse(name-> System.out.println("The name is "+name),
                ()-> System.out.println("Data is null"));
    }
}
