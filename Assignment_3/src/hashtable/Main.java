package hashtable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random(42);

        for (int i = 0; i < 10000; i++) {
            String name = generateRandomString(random, 5 + random.nextInt(6));
            int id = random.nextInt(1000000);
            MyTestingClass key = new MyTestingClass(name, id);
            Student value = new Student("First" + i, "Last" + i);
            table.put(key, value);
        }

        System.out.println("Total elements added: " + table.size());
        System.out.println("Distribution of elements across 11 buckets:");
        table.showDistribution();
        
        MyTestingClass someKey = new MyTestingClass("Alice", 123);
        Student someStudent = new Student("Alice", "Smith");
        table.put(someKey, someStudent);
        System.out.println("\nRetrieving Alice: " + table.get(someKey));
        System.out.println("Contains Alice Smith: " + table.contains(someStudent));
        System.out.println("Removing Alice: " + table.remove(someKey));
        System.out.println("Alice removed, get Alice: " + table.get(someKey));
    }

    private static String generateRandomString(Random random, int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
