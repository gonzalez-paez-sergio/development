package hashes;

public class MyHashMap<K, V> {

	private Object[] table;
	static final int defaultSize = 16;
	static final double loadFactor = .75;

	public MyHashMap() {
		this.table = new Object[defaultSize];
	}

	@SuppressWarnings("unchecked")
	private void put(Entry<K, V> item) {

		int index = getIndex(item.getKey());

		Entry<K, V> e = (Entry<K, V>) this.table[index];

		if (null == e) {
			// e = item;
			this.table[index] = item;
		} else {

			while (e != null && e.getNext() != null) {
				e = e.getNext();
			}

			e.setNext(item);
		}
	}

	@SuppressWarnings("unchecked")
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < this.table.length; i++) {

			Entry<K, V> e = (Entry<K, V>) this.table[i];

			System.out.println("iterating over element " + i + ", e:" + e);

			if (null != e) {
				stringBuilder.append((e.toString()));
				stringBuilder.append("\n");
			}
		}

		return stringBuilder.toString();
	}

	public void put(K key, V value) {
		put(new Entry<K, V>(key, value));
	}

	public V get(K key) {

		int index = getIndex(key);

		@SuppressWarnings("unchecked")
		Entry<K, V> e = (Entry<K, V>) this.table[index];
		V result = null;

		while (null != e) {
			if (e.getKey() == key) {
				result = e.getValue();
			}
		}
		return result;
	}

	private int getIndex(K key) {
		int index = getHashCode(key);
		System.out.println(index);
		index %= table.length;
		System.out.println(index);
		return index;
	}

	private int getHashCode(K key) {
		int result = 17;
		result = result * 31 + key.hashCode();
		
		
		return result;
	}

	// static int hash(String s) {
	// int len = 30;
	// int sum = 0;
	// for (int i = 0; i < s.length(); i++) {
	// sum += ((int) s.charAt(i)) * (1 << i);
	// }
	// return sum % len;
	// }

}

class TestMyHashMap {

	public static void main(String[] string) {

		MyHashMap<String, String> m = new MyHashMap<String, String>();
		System.out.println("putting element");
		m.put("hola1", "mundo");
		m.put("2hola2", "mundo");
		m.put("2hola2", "mundo1");
		m.put("hola3", "mundo");
		System.out.println("after putting element");
		System.out.println(m.toString());

	}
}