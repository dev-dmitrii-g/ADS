package hashtable;

public class MyTestingClass {
    private String name;
    private int id;

    public MyTestingClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        if (name != null) {
            for (int i = 0; i < name.length(); i++) {
                hash = 37 * hash + name.charAt(i);
            }
        }
        hash = 37 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && (name != null ? name.equals(other.name) : other.name == null);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "name='" + name + '\'' + ", id=" + id + '}';
    }
}
