import java.util.*;

public class Solution {
    public static Iterator func(ArrayList mylist) {
        Iterator iterator = mylist.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();

            if (element.equals("###")) {
                break;
            }
        }

        return iterator;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList mylist = new ArrayList();

        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");

        while (sc.hasNext()) {
            mylist.add(sc.next());
        }

        Iterator iterator = func(mylist);

        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println((String) element);
        }
    }
}

/*
Input:
2
42 10
Hello Java

Output:
Hello
Java
*/
