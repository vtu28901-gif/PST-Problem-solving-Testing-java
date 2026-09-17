import java.util.*;

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        }

        if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String order = sc.nextLine();

        FoodFactory factory = new FoodFactory();
        Food food = factory.getFood(order);

        System.out.println("The factory returned class " + food.getClass().getSimpleName());
        System.out.println(food.getType());
    }
}

/*
Input:
cake

Output:
The factory returned class Cake
Someone ordered a Dessert!
*/
