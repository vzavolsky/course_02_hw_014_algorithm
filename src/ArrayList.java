public class ArrayList implements StringList {

    private String[] strings;

    public ArrayList(int size) {
        strings = new String[size];
    }

    private void organizer() {
        String[] array = new String[this.size()];
        int j = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                array[j] = strings[i];
                ++j;
            }
        }
        strings = array;
    }

    @Override
    public String add(String item) {
        checkNullItem(item);
        if (this.size() >= strings.length) {
            throw new ArrayListException("List is full.");
        }
        strings[this.size()] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkNullItem(item);
        if (index >= strings.length) {
            throw new ArrayListException("Index doesn't exist.");
        }
        int newSize = this.size() + 1;
        String[] array = new String[newSize];
        for (int i = 0, j = 0; j < newSize; i++, j++) {
            if (j < index) {
                array[j] = strings[i];
            } else if (j > index) {
                array[j] = strings[i];
            } else {
                array[j] = item;
                i--;
            }
        }
        strings = array;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkNullItem(item);
        if (index >= strings.length) {
            throw new ArrayListException("Index doesn't exist.");
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkNullItem(item);
        boolean exception = true;
        for (int i = 0; i < this.size(); i++) {
            if (strings[i].equals(item)) {
                strings[i] = null;
                exception = false;
            }
        }
        if (exception) {
            throw new ArrayListException(String.format("String \"%s\" wasn't found.", item));
        }
        this.organizer();
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= strings.length) {
            throw new ArrayListException("Index doesn't exist.");
        }
        String item = "";
        item = strings[index];
        strings[index] = null;
        this.organizer();
        return item;
    }

    @Override
    public boolean contains(String item) {
        checkNullItem(item);
        for (int i = 0; i < this.size(); i++) {
            if (strings[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkNullItem(item);
        for (int i = 0; i < this.size(); i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkNullItem(item);
        for (int i = this.size() - 1, j = 0; i >= 0; i--, j++) {
            if (strings[i].equals(item)) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= strings.length) {
            throw new ArrayListException("Index doesn't exist.");
        }
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new ArrayListException("List is empty.");
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int arraySizeCounter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                arraySizeCounter++;
            }
        }
        return arraySizeCounter;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            strings[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] arrayList = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            arrayList[i] = this.get(i);
        }
        return arrayList;
    }

    public String toString() {
        String res = "";
        this.organizer();
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }
        return res;
    }

    public String toString(String divider) {
        String res = "";
        this.organizer();
        for (int i = 0; i < strings.length; i++) {
            res += strings[i] + divider;
        }
        return res.substring(0, res.length() - divider.length());
    }

    public void checkNullItem(String item) {
        if (item == null) {
            throw new ArrayListException("Item can't be Null.");
        }
    }
}
