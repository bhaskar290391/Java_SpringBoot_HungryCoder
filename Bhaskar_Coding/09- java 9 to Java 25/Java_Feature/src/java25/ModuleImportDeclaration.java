package java25;

//Module Import Declarations (JEP 511)
//Before java25

//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Stream;
//import java.util.stream.Collectors;
//import java.util.function.Function;
//import java.nio.file.Path;
//import java.nio.file.Files;

//After Java 25
import module java.base;
public class ModuleImportDeclaration {
    List<String > data=null;
    Map<String, String> map;
    Set<String> hello=null;
    Stream<String> stream;

}
