public class MyTestingClass {
    private int key;
    private String val;

    public MyTestingClass(int key, String val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash * key;

        if (val != null) {
            for (int i = 0; i < val.length(); i++) {
                hash = 31 * hash + val.charAt(i);
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MyTestingClass other = (MyTestingClass) object;
        return key == other.key && (val != null && val.equals(other.val));
    }
}
