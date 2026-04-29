void main() {
    MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
    Random random = new Random();

    for (int i = 0; i < 10000; i++) {
        String name = generateRandomString();
        int id = random.nextInt(10000);
        MyTestingClass key = new MyTestingClass(id, name);
        Student value = new Student("First" + i, i % 100);
        table.put(key, value);
    }

    System.out.println("Total elements added: " + table.getSize());
    System.out.println("Distribution of elements across 11 buckets:");
    table.showDistribution();

}

String generateRandomString() {
    byte[] array = new byte[10];
    new Random().nextBytes(array);
    return new String(array, StandardCharsets.UTF_8);
}
