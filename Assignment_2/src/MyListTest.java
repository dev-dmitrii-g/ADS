public class MyListTest {

    public static void runAllTests(MyList<String> list) {
        String name = list.getClass().getSimpleName();
        System.out.println("Testing Implementation: " + name);

        try {
            execute("add, set, size", () -> {
                list.clear();
                list.add("B");
                list.addFirst("A");
                list.addLast("D");
                list.add(2, "C");
                list.set(3, "E");
                if (list.size() != 4 || !list.get(3).equals("E")) throw new RuntimeException();
            });

            execute("get, getFirst, getLast", () -> {
                if (!list.getFirst().equals("A")) throw new RuntimeException();
                if (!list.getLast().equals("E")) throw new RuntimeException();
                if (!list.get(1).equals("B")) throw new RuntimeException();
            });

            execute("indexOf, lastIndexOf, exists", () -> {
                list.add("B");
                if (!list.exists("C")) throw new RuntimeException();
                if (list.indexOf("B") != 1) throw new RuntimeException();
                if (list.lastIndexOf("B") != 4) throw new RuntimeException();
            });

            execute("remove, removeFirst, removeLast", () -> {
                list.clear();
                list.add("1"); list.add("2"); list.add("3");
                list.removeFirst();
                list.removeLast();
                if (list.size() != 1 || !list.get(0).equals("2")) throw new RuntimeException();
            });

            execute("sort, toArray", () -> {
                list.clear();
                list.add("Z"); list.add("A");
                list.sort();
                Object[] arr = list.toArray();
                if (!arr[0].equals("A") || !arr[1].equals("Z")) throw new RuntimeException();
            });

            execute("iterable, clear", () -> {
                int count = 0;
                for (String s : list) count++;
                if (count != 2) throw new RuntimeException();
                list.clear();
                if (list.size() != 0) throw new RuntimeException();
            });

            System.out.println("SUCCESS: " + name + " passed all tests\n");
        } catch (Exception | AssertionError e) {
            System.out.println("FAILURE: Test failed for " + name);
        }
    }

    private static void execute(String desc, Runnable test) {
        System.out.print("  Testing " + desc + "... ");
        try {
            test.run();
            System.out.println("Passed");
        } catch (Exception | AssertionError e) {
            System.out.println("Failed");
            throw e;
        }
    }
}