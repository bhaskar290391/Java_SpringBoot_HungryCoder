package functionalProgramming;

import java.util.Optional;

class OptionalClassExample{

    public Optional<String> findUsernameById(int userId) {

        if(userId==0){
            return  Optional.empty();
        }else{
             return  Optional.of("Bhaskar");
        }
    }
}
public class OptionalClassDemo {
  public  static void main(String[] args) {
      OptionalClassExample optional= new OptionalClassExample();
      Optional<String> data= optional.findUsernameById(0);

      data.ifPresentOrElse(username -> System.out.println("The username ==>"+ username),()-> System.out.println("Username not found"));
    }
}
