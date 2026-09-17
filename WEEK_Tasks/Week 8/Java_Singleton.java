import java.util.*;

class Singleton {
    private static Singleton instance;
    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();

        Singleton singleton = Singleton.getSingleInstance();
        singleton.str = message;

        System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
    }
}

/*
Input:
hello world

Output:
Hello I am a singleton! Let me say hello world to you
*/
