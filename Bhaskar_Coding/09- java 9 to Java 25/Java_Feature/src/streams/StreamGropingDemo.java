package streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGropingDemo {
    public static void main() {

        //immutable list allow null values
        var data=Stream.of("red","orange",null).toList();
        //data.add("yellow");
        System.out.println("Immutable Object ==> "+data);

        //modfiable collection
        var modifiableList=Stream.of("red","orange",null).collect(Collectors.toList());
        modifiableList.add("yello");
        modifiableList.set(2,"pink");
        System.out.println(modifiableList);


        record Product(String  name, String category, int price){
        }

        Supplier<Stream<Product>> productsSupplier =()-> Stream.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("TV", "Electronics", 1500),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 300),
                new Product("Lamp", "Home Decor", 50)
        );
        
        //group by product category
        Map<String, List<Product>> groupByProductCategory = productsSupplier.get().collect(Collectors.groupingBy(Product::category));
        System.out.println("groupByProductCategory ==>" +groupByProductCategory);


        // Aggregation: Calculating the) total price of products by category
        Map<String, Integer> totalPriceByproductCategory = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
        System.out.println("totalPriceByproductCategory"+ totalPriceByproductCategory);

        // Aggregation: Average by products by category
        Map<String, Double> averageByProductCategory = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));
        System.out.println("averageByProductCategory ==> " +averageByProductCategory);

        // Aggregation: Counting products by category
        Map<String, Long> countByProductCategory = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println("countByProductCategory ==> " +countByProductCategory);


        // Filtering: Products with price greater than 1499
        List<Product> productGreaterThen1499 = productsSupplier.get().filter(product -> product.price > 1499).toList();
        System.out.println("productGreaterThen1499 ==>" + productGreaterThen1499);
        
        //extracting Product category
        List<String> productCategory = productsSupplier.get().map(Product::category).distinct().toList();
        System.out.println("Product category ==> " + productCategory);

        // Partitioning: Separate products into expensive and cheap
        Map<Boolean, List<Product>> partitionByProductPrice = productsSupplier.get().collect(Collectors.partitioningBy(product -> product.price() > 1000));
        System.out.println("partitionByProductPrice ==> "+partitionByProductPrice);

        // Using SummaryStatistics for product prices by category
        Map<String, IntSummaryStatistics> summarizingInt = productsSupplier.get().collect(Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price)));
        System.out.println("summarizingInt==> "+summarizingInt);
    }





}
