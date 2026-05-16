package java23;

import java.util.concurrent.StructuredTaskScope;

//Structured Concurrency (JEP 428
public class StructuredConcurrencyDemo {
    static void main() {
        try(var scope= StructuredTaskScope.open()){

            var task1=scope.fork(()-> "Task 1");
            var task2=scope.fork(()-> "Task 2");
            scope.join();
            System.out.println(task2.get()+" ==> "+ task1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
