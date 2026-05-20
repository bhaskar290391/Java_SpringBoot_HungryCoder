package java8.stream.grouping;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupingExample {
    static void main() {


        //Immutable list
        var immutableData=Stream.of("red","yello",null).toList();
        //immutableData.add("orange");
        System.out.println(immutableData);


        //modifiable object
        var modifiableData=Stream.of("red","yello",null).collect(Collectors.toList());
        modifiableData.add("orange");
        modifiableData.set(2,"pink");
        System.out.println(modifiableData);

        record Product(String name, String category, int price) {}

        // Define a Supplier for the products stream to create a new stream on each use
        Supplier<Stream<Product>> productsSupplier = () -> Stream.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("TV", "Electronics", 1500),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 300),
                new Product("Lamp", "Home Decor", 50));

        //grouping product by category
        Map<String, List<Product>> productByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category));
        System.out.println(productByCategory);
        //Grouping product by catogory an sum of price;

        Map<String, Integer> categoryAndTotalPrice = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
        System.out.println("categoryAndTotalPrice => "+categoryAndTotalPrice);

        //Category and counting
        Map<String, Long> categoryAndTotalCount = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println("categoryAndTotalCount => "+categoryAndTotalCount);

        //Category and Average
        Map<String, Double> categoryAndTotalAverage = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));
        System.out.println("categoryAndTotalAverage => "+categoryAndTotalAverage);

        //extract only Product by Category
        List<String> OnlyCategory = productsSupplier.get().map(Product::category).collect(Collectors.toList());
        System.out.println("Onlycategory ==> "+OnlyCategory);

        //Filterproduct by price
        List<Product> filteredProduct = productsSupplier.get().filter(product -> product.price > 1499).collect(Collectors.toList());
        System.out.println(filteredProduct);

        //Expensive and cheap product
        Map<Boolean, List<Product>> partitionByPrice =
                productsSupplier.get().collect(Collectors.partitioningBy(product -> product.price > 1000));

        System.out.println(partitionByPrice);

        //using summary statistics
        Map<String, IntSummaryStatistics> summarizingData =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price)));
        System.out.println(summarizingData);

    }
}
