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
