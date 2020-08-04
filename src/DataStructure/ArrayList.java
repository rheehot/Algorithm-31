package DataStructure;

public class ArrayList {

    // 저장된 데이터의 개수를 세기 위한 변수
    private int size = 0;
    // 내부에서 사용할 배열
    private Object[] elementData = new Object[100];

    // 데이터 추가: 지정된 위치에 데이터 추가
    public boolean add(int index, Object element) {
        for(int i = size; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }

        elementData[index] = element;
        size++;

        return true;
    }

    // 첫번째에 데이터 추가
    public boolean addFirst(Object element) {
        return add(0, element);
    }

    // 마지막에 데이터 추가
    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;

        return true;
    }

    // ArrayList를 출력
    public String toString() {
        String str = "{";

        for(int i = 0; i < size; i++) {
            str += elementData[i];

            if (i < size - 1) {
                str += ", ";
            }
        }

        return str + "}";
    }

    // 데이터 삭제: 지정된 위치에 데이터 삭제
    public Object remove(int index) {
        Object removed = elementData[index];

        for(int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }

        size--;
        elementData[size] = null;

        return removed;
    }

    // 첫번째 데이터 삭제
    public Object removeFirst() {
        return remove(0);
    }

    // 마지막 데이터 삭제
    public Object removeLast() {
        return remove(size - 1);
    }

    // 지정된 데이터 반환
    public Object get(int index) {
        return elementData[index];
    }

    // ArrayList에 저장된 데이터의 갯수를 반환
    public int size() {
        return size;
    }

    // 데이터의 인덱스를 반환
    public int indexOf(Object element) {
        for(int i = 0; i < size; i++) {
            if(element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new ListIterator();  // ListIterator 객체를 새로 생성해서 반환
    }

    class ListIterator {
        private int nextIndex = 0;  // 접근할 때 사용할 인덱스 변수

        public boolean hasNext() {
            return nextIndex < size;    // 다음에 가리킬 인덱스가 사이즈의 값을 넘어가면 false 반환
        }

        public Object next() {
            return elementData[nextIndex++];
        }

        public Object previous() {
            return elementData[nextIndex--];
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public void add(Object element) {
            ArrayList.this.add(nextIndex , element);
        }

        public void remove() {
            ArrayList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }
}
