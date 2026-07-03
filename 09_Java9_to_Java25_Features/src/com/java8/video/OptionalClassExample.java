package com.java8.video;

import java.util.Optional;

class UserDetails{
    public Optional<String> findUserNameById(String id){
        if(id ==null){
            return  Optional.empty();
        }else{
            return  Optional.ofNullable("Bhaskar");
        }
    }
}
public class OptionalClassExample {
    static void main() {
        UserDetails data= new UserDetails();
       // Optional<String> userName=data.findUserNameById("123");
        Optional<String> userName=data.findUserNameById(null);

        userName.ifPresentOrElse(
                uname-> System.out.println("The username "+uname),
                ()-> System.out.println("UserName not found")
        );

        userName.map(u -> u.toUpperCase()).ifPresent(System.out::println);

    }
}
