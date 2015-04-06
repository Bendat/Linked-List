package LinkedList.tests;

import LinkedList.LinkedList.LinkedList;

import java.util.Iterator;

/**
 * Testing class for LinkedList.java
 */
public class Test1 {
    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>();
        System.out.println("<------------------ isEmpty test ------------------>");
        System.out.println("Should return true: " + ls.isEmpty());
        System.out.println("Adding Integer of value 5");
        ls.add(5);
        System.out.println("Should return false: " + ls.isEmpty());
        System.out.println("<------------------ Add and Contains test ------------------>");
        ls = new LinkedList<>();
        testAddContains(ls);
        System.out.println("<------------------ Remove and Contains test ------------------>");
        ls = new LinkedList<>();
        testRemoveContains(ls);
        System.out.println("<------------------ Add double count test ------------------>");
        ls = new LinkedList<>();
        testAddDoubleCount(ls);
        System.out.println("\n<------------------ RemoveAll test ------------------>");
        ls = new LinkedList<>();
        testRemoveAll(ls);
        System.out.println("\n<------------------ Iterator test ------------------>");
        ls = new LinkedList<>();
        testIterator(ls);
        System.out.println("\n<------------------ AddAll test ------------------>");
        ls = new LinkedList<>();
        testAddAll(ls);
        System.out.println("\n<------------------ containsAll test ------------------>");
        ls = new LinkedList<>();
        testContainsAll(ls);
        System.out.println("\n<------------------ retainsAll test ------------------>");
        ls = new LinkedList<>();
        testRetainAll(ls);
        System.out.println("\n<------------------ retainsAllEmpty test ------------------>");
        ls = new LinkedList<>();
        testRetainAllEmpty(ls);

    }

    /**
     * Tests the LinkedLists add and contain methods.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testAddContains(LinkedList<Integer> ls) {
        Integer w = 2;
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        System.out.println("Adding Integer Object 'w' of value 2 to the set");
        ls.add(w);
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println(
                "Checking if the set contains w. Should return true: "
                        + ls.contains(w)
                        + "\nChecking if the set contains x. Should return true: "
                        + ls.contains(x)
                        + "\nChecking if set contains y. Should return true: "
                        + ls.contains(y)
                        + "\nChecking is set contains Integer z (value of 22)."
                        + "Should return false: "
                        + ls.contains(z)
        );
    }

    /**
     * Tests the LinkedLists remove and contain methods.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testRemoveContains(LinkedList<Integer> ls) {
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        System.out.println("Removing Integer y");
        ls.remove(y);

        System.out.println(
                "Checking if the set contains x. Should return true: "
                        + ls.contains(x)
                        + "\nChecking if set contains y. Should return false: "
                        + ls.contains(y)
                        + "\nChecking if set contains z. Should return true: "
                        + ls.contains(z)
                        + "\nChecking if set contains a. Should return true: "
                        + ls.contains(a) + "\n"
                        + ls.size()
        );
    }

    /**
     * Tests that add does not double count.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testAddDoubleCount(LinkedList<Integer> ls) {
        Integer x = 5;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("The size of the set is: " + ls.size() + " Expected: 1");
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.print("The size of the set is: " + ls.size() + " Expected: 1");
    }

    /**
     * Tests the elements()(and iterator()) methods.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testIterator(LinkedList<Integer> ls) {
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        System.out.println("Printing contents from iterator. Expected are 5, 8, 22, 30");
        Iterator abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }

    }

    /**
     * Tests the removeAll() method.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testRemoveAll(LinkedList<Integer> ls) {
        LinkedList<Integer> difference = new LinkedList<>();
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        Integer m = 5;
        Integer n = 8;
        System.out.println("Adding Integer Object 'm' of value 5 to a differentiating set");
        difference.add(m);
        System.out.println("Adding Integer Object 'n' of value 8 to a differentiating set");
        difference.add(n);
        System.out.println("Printing contents from iterator. Expected are 5, 8, 22, 30");
        Iterator abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
        System.out.println("\nIntersecting lists and removing all common data. Expecting output: 22, 30");
        ls.removeAll(difference);
        abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
    }

    /**
     * Tests the addAll() method.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testAddAll(LinkedList<Integer> ls) {
        LinkedList<Integer> union = new LinkedList<>();
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        Integer m = 12;
        Integer n = 45;
        System.out.println("Adding Integer Object 'm' of value 12 to a union set");
        union.add(m);
        System.out.println("Adding Integer Object 'n' of value 45 to a union set");
        union.add(n);
        System.out.println("Printing contents from iterator. Expected are 5, 8, 22, 30");
        Iterator abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
        System.out.println("\njoining lists. Expecting output: 5, 8, 22, 30, 12, 45");
        ls.addAll(union);
        abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
    }

    /**
     * Tests the containsAll() method.
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testContainsAll(LinkedList<Integer> ls) {
        LinkedList<Integer> cls = new LinkedList<>();
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'x' of value 5 to comparison set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to comparison set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to comparison set");
        ls.add(z);
        System.out.println("Checking if both sets contain same objects. Expected result is true");
        System.out.println(ls.containsAll(cls));
        System.out.println("Adding Integer Object 'd' of value 3 to comparison set");
        cls.add(3);
        System.out.println("Checking if both sets contain same objects. Expected result is false");
        System.out.println(ls.containsAll(cls));
    }

    /**
     * Tests the retainAll() method intersecting with a non-empty set..
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testRetainAll(LinkedList<Integer> ls) {
        LinkedList<Integer> intersection = new LinkedList<>();
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        Integer m = 5;
        Integer n = 8;
        System.out.println("Adding Integer Object 'm' of value 5 to a intersecting set");
        intersection.add(m);
        System.out.println("Adding Integer Object 'n' of value 8 to a intersecting set");
        intersection.add(n);
        System.out.println("Printing contents from iterator. Expected are 5, 8, 22, 30");
        Iterator abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
        System.out.println("\nIntersecting lists and removing all non-same data. Expecting output: 5, 8");
        ls.retainAll(intersection);
        abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
    }

    /**
     * Tests the retainAll() method intersecting with an empty set..
     *
     * @param ls - a LinkedList Object to test with.
     */
    public static void testRetainAllEmpty(LinkedList<Integer> ls) {
        LinkedList<Integer> intersection = new LinkedList<>();
        Integer x = 5;
        Integer y = 8;
        Integer z = 22;
        Integer a = 30;
        System.out.println("Adding Integer Object 'x' of value 5 to the set");
        ls.add(x);
        System.out.println("Adding Integer Object 'y' of value 8 to the set");
        ls.add(y);
        System.out.println("Adding Integer Object 'z' of value 22 to the set");
        ls.add(z);
        System.out.println("Adding Integer Object 'a' of value 30 to the set");
        ls.add(a);
        System.out.println("Printing contents from iterator. Expected are 5, 8, 22, 30");
        Iterator abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
        System.out.println("\nIntersecting lists and removing all non-same data. Expecting output: 5, 8, 22, 30");
        ls.retainAll(intersection);
        abl = ls.iterator();
        while (abl.hasNext()) {
            System.out.print(abl.next() + " ");
        }
    }
}

