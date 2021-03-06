import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayStack<T> {

	private static final int DEFAULT_CAPACITY = 15;
	private T[] array;
	private int top;
	private int totalNumberOfElements;
	private int capacity;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		if (capacity <= 0) {
			array = (T[]) new Object[DEFAULT_CAPACITY];
			capacity = DEFAULT_CAPACITY;
		} else {
			array = (T[]) new Object[capacity];
			this.capacity = capacity;
		}

		top = -1;
		totalNumberOfElements = 0;
	}

	public boolean isEmpty() {
		return totalNumberOfElements == 0;
	}

	public boolean isFull() {
		return totalNumberOfElements == capacity;
	}

	public T topOfStack() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return array[top];
	}

	public void insert(T data) {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		++top;
		array[top] = data;
		++totalNumberOfElements;
	}

	public T delete() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T temp = topOfStack();
		array[top] = null;
		--top;
		--totalNumberOfElements;
		return temp;
	}

	public void clear() {
		for (int i = 0; i <= top; i++) {
			array[i] = null;
		}
		top = -1;
		totalNumberOfElements = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < array.length - 1; i++) {
			sb.append(array[i] + ", ");
		}
		sb.append(array[array.length - 1] + " ]");
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> integerArrayStack = new ArrayStack<Integer>();

		for (int i = 0; i < 5; i++) {
			integerArrayStack.insert(i);
		}
		System.out.println(integerArrayStack);

		integerArrayStack.delete();
		integerArrayStack.delete();

		System.out.println(integerArrayStack);

		integerArrayStack.clear();
		System.out.println(integerArrayStack);
	}
}
