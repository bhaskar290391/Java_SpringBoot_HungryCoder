package java17;
sealed  class Meal permits Breakfast, Dinner, Lunch {

    public String getTimeOfDay() {
        return "Meal demo";
    }

}

final  class Breakfast extends  Meal{
    @Override
    public String getTimeOfDay() {
        return "Morning";
    }
}

final  class Lunch extends  Meal{
    @Override
    public String getTimeOfDay() {
        return "Afternoon";
    }
}

final  class Dinner extends  Meal{
    @Override
    public String getTimeOfDay() {
        return "Night";
    }
}
public class SealeadClassDemo2 {
    static void main() {
        Lunch d=new Lunch();
        System.out.println(d.getTimeOfDay());
    }
}
