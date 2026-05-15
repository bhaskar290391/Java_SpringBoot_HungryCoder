package java25;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class User{
    public User(){

    }
}
class  Order{
    public Order(){

    }
}

class  UserDetails{
    User user;
    List<Order> order;

    public UserDetails(User user, List<Order> order) {
        this.user = user;
        this.order = order;
    }
}

public class StructureConcurrencyDemo {

    //Before java 25
    public UserDetails fetchUserDetails(String userId){

        ExecutorService service = Executors.newCachedThreadPool();
        Future<User> user=service.submit(()->fetchUser(userId));
        Future<List<Order>> orders=service.submit(()->fetchUserOrders(userId));

        try{
            User users=user.get();
            List<Order> data=orders.get();
            return  new UserDetails(users,data);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    //After java 25
    public  UserDetails fetchUserDetailsByStructuredConcurrency(String userId){
        try(var scope= StructuredTaskScope.open()){

            var users=scope.fork(()-> fetchUser(userId));
            var orders=scope.fork(()-> fetchUserOrders(userId));
            scope.join();
            return  new UserDetails(users.get(),orders.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Order> fetchUserOrders(String userId) {
        return Collections.emptyList();
    }

    private User fetchUser(String userId)
    {
        return  new User();
    }
}
