public class MyArrayList<T> {

        private Object[] arr = new Object[5];
        private int size = 0;
        private Class<T> type;

        public MyArrayList(Class<T> type) {
            this.type = type;
        }

        public void addSize() {
            int newCap = this.getArr().length * 3 / 2 + 1;
            Object[] newArr = new Object[newCap];

            for(int i = 0; i < this.getArr().length; ++i) {
                newArr[i] = this.getArr()[i];
            }

            this.setArr(newArr);
        }

    public void add(T elements) {
        if (this.size == this.arr.length) {
            this.addSize();
        }

        this.arr[this.size++] = elements;
    }

    public void addToIndex(int index, T element) {
        this.indexAddCheck(index);
        if (this.size == this.arr.length) {
            this.addSize();
        }

        this.arr[index] = element;
        ++this.size;
    }

    public Object getElement(int index) {
        this.indexGetCheck(index);
        return this.getArr()[index];
    }

    public boolean remove(int index) {
        this.indexGetCheck(index);
        Object var10000 = this.arr[index];
        var10000 = this.arr[index];

        for(int i = index; i < this.size - 1; ++i) {
            this.arr[i] = this.arr[i + 1];
        }

        this.arr[this.size - 1] = null;
        --this.size;
        return true;
    }

    public void listClear() {
        this.arr = new Object[5];
        this.size = 0;
    }



    private boolean indexAddCheck(int index) {
        if (index >= 0 && index <= this.size) {
            return false;
        } else {
            throw new IndexOutOfBoundsException("Такого индекса в списке нет");
        }
    }

    private boolean indexGetCheck(int index) {
        if (index >= 0 && index < this.size) {
            return false;
        } else {
            throw new IndexOutOfBoundsException("Такого индекса в списке нет");
        }
    }



    public Object[] getArr() {
        return this.arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
