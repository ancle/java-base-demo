package generic.test;

public class Notepad<K, V> {
	private K key;
	private V value;
	
	public Notepad(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public <V>  V getString(K key, V value) {
		return (V) ("key : " + key.toString() + ", value : " + value.toString());
	}

}
