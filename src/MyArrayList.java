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

    public void listSort() {
        if (this.getArr()[0] instanceof Integer) {
            Integer[] intArrWithoutNull = new Integer[this.getArr().length];

            for(int i = 0; i < intArrWithoutNull.length; ++i) {
                if (this.getArr()[i] != null) {
                    intArrWithoutNull[i] = (Integer)this.getArr()[i];
                } else {
                    intArrWithoutNull[i] = 0;
                }
            }

            int n = intArrWithoutNull.length;

            for(int i = 1; i < n; ++i) {
                int key = intArrWithoutNull[i];

                int j;
                for(j = i - 1; j >= 0 && intArrWithoutNull[j] > key; --j) {
                    intArrWithoutNull[j + 1] = intArrWithoutNull[j];
                }

                intArrWithoutNull[j + 1] = key;
            }

            this.setArr(intArrWithoutNull);
        }

        if (this.getArr()[0] instanceof Double) {
            Double[] doubleArrWithoutNull = new Double[this.getArr().length];

            for(int i = 0; i < doubleArrWithoutNull.length; ++i) {
                if (this.getArr()[i] != null) {
                    doubleArrWithoutNull[i] = (Double)this.getArr()[i];
                } else {
                    doubleArrWithoutNull[i] = (double)0.0F;
                }
            }

            int n = doubleArrWithoutNull.length;

            for(int i = 1; i < n; ++i) {
                Double key = doubleArrWithoutNull[i];

                int j;
                for(j = i - 1; j >= 0 && doubleArrWithoutNull[j] > key; --j) {
                    doubleArrWithoutNull[j + 1] = doubleArrWithoutNull[j];
                }

                doubleArrWithoutNull[j + 1] = key;
            }

            this.setArr(doubleArrWithoutNull);
        }

        if (this.getArr()[0] instanceof String) {
            String[] stringArr = new String[this.getArr().length];

            for(int i = 0; i < stringArr.length; ++i) {
                if (this.getArr()[i] == null) {
                    throw new NullPointerException("Нельзя сортировать массив String если в нём есть null");
                }

                stringArr[i] = (String)this.getArr()[i];
            }

            int n = stringArr.length;

            for(int i = 1; i < n; ++i) {
                String key = stringArr[i];

                int j;
                for(j = i - 1; j >= 0 && stringArr[j].compareTo(key) > 0; --j) {
                    stringArr[j + 1] = stringArr[j];
                }

                stringArr[j + 1] = key;
            }

            this.setArr(stringArr);
        }

    }

    public String listToString() {
        StringBuilder listToStringB = new StringBuilder();
        listToStringB.append("[");

        for(int i = 0; i < this.getArr().length; ++i) {
            if (this.getArr()[i] == null) {
                listToStringB.append("null");
            } else {
                listToStringB.append(this.getArr()[i].toString());
            }

            if (i < this.getArr().length - 1) {
                listToStringB.append(", ");
            }
        }

        listToStringB.append("]");
        return listToStringB.toString();
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
