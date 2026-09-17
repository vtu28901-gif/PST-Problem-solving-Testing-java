import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class Solution {
    public static int count(ArrayList<Object> mylist) {
        int students = 0;
        int rockstars = 0;
        int hackers = 0;

        for (Object obj : mylist) {
            if (obj instanceof Student) {
                students++;
            }

            if (obj instanceof Rockstar) {
                rockstars++;
            }

            if (obj instanceof Hacker) {
                hackers++;
            }
        }

        return students + rockstars + hackers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Object> mylist = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            if (type.equals("Student")) {
                mylist.add(new Student());
            } else if (type.equals("Rockstar")) {
                mylist.add(new Rockstar());
            } else if (type.equals("Hacker")) {
                mylist.add(new Hacker());
            }
        }

        int students = 0;
        int rockstars = 0;
        int hackers = 0;

        for (Object obj : mylist) {
            if (obj instanceof Student) {
                students++;
            } else if (obj instanceof Rockstar) {
                rockstars++;
            } else if (obj instanceof Hacker) {
                hackers++;
            }
        }

        System.out.println(students + " " + rockstars + " " + hackers);
    }
}

/*
Input:
5
Student
Student
Rockstar
Student
Hacker

Output:
3 1 1
*/
