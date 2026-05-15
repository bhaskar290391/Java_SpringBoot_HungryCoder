package java25;
//Primitive Pattern Matching (JEP 507)
public class PatternMatchingInSwitch {

    //before 25
    public static String calculateGrade(Number score){

        if(score instanceof  Integer i){
            if(i>=95) return "A";
            if(i>=75) return  "B";
            if(i >=60) return  "C";
        }else if (score instanceof  Double d){
            if(d >= 59.5) return  "C rounded";
        }
        return  "D/F";

    }

    //after java 25
    public static String calculateGradeSwitch(Number score){
        return  switch (score){
            case int i when i>=95 -> "A";
            case int i when i>=75 -> "B";
            case int i when i>=60 -> "C";
            case int d when d>=59.5 -> "C rounded";
            default -> "D/F";
        };
    }
    public static void main() {


        System.out.println(calculateGrade(65));
        System.out.println(calculateGradeSwitch(76));
    }
}
