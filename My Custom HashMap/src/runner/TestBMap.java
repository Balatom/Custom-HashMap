package runner;
import mymap.BMap;
public class TestBMap<K,V> {
	static int size = 10;
	int index;
	private  BMap<K,V>[] map = new BMap[size];
	public int hashCode(K key)
	{
		return ((String) key).charAt(0)*(16)+25;
	}
	public int getIndex(K key)
	{
		return hashCode(key)%size;
	}
	public void printMap()
	{
		System.out.println("Beta Map");
		for(BMap<K,V> i : map)
		{
			System.out.println(i);
		}
	}
	public void pushEntry(K key,V value)
	{
		BMap<K,V> newMap = new BMap<>(key,value);
		int index = getIndex(key);
		if(map[index] == null)
		{
			map[index] = newMap;
		}
		else
		{
			BMap<K,V> node = map[index];
			while(node != null)
			{
				if(node.getKey().equals(key))
				{
					node.setValue(value);
					break;
				}
				if(node.getNext() == null)
				{
					node.setNext(newMap);
				}
				node = node.getNext();
			}			
		}		
	}
	public Object getValue(K key)
	{
		int index = getIndex(key);
		Object value = null;
		BMap<K,V> tmap = map[index];
		System.out.println("index at push : "+index);
		while(tmap != null)
		{
			if(tmap.getKey().equals(key))
			{
				value = tmap.getValue();
			}
			tmap = tmap.getNext();
		}
		return value;
	}
	public static void main(String[] args) {

		TestBMap<String,String> test = new TestBMap<>();
		test.pushEntry("one","World");
		test.pushEntry("Two","Eyes");
		test.pushEntry("one","Zoho");
		test.pushEntry("Three","Tress");
		test.pushEntry("Teen", "Students");
		test.pushEntry("oneZoho", "ZohoDev");
		System.out.println(test.getValue("one"));
		System.out.println(test.getValue("Two"));
		System.out.println(test.getValue("Three"));
		System.out.println(test.getValue("oneZoho"));
		System.out.println(test.getValue("Teen"));
	}

}
