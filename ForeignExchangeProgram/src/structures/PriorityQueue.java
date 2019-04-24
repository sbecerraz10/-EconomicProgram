package structures;

public class PriorityQueue<V extends Comparable<V>> implements IQueue<V>{
	Heap<V> elements;
	
	public PriorityQueue (boolean Type) {
		elements = new Heap<>(Type);
	}

	@Override
	public boolean offer(V obj) {
		elements.add(obj);
		return true;
	}

	@Override
	public V poll() {
		return elements.obtain();
	}

	@Override
	public V peek() {
		return elements.getTop();
	}

	@Override
	public V element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}

