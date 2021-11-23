import java.security.KeyStore;
import java.util.*;

public class OurHashMap<K, V> implements Map<K, V>
{
    private final int SIZE = 16;

    class Entry<K, V>
    {
        K key;
        V value;

        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }
    List<Entry> values[] = new List[SIZE];
    @Override
    public int size()
    {
        int size= 0;
        for(List<Entry> list : values)
        {
            if(list != null)
            {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        for (List<Entry> list : values)
        {
            if(list != null && list.size() > 0)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value)
    {
        for(List<Entry> list : values)
        {
            if(list != null)
            {
                for(Entry entry : list)
                {
                    if(entry.value.equals(value))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key)
    {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list == null)
        {
            return null;
        }
        for (Entry entry : list)
        {
            if (entry.key.equals(key))
            {
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value)
    {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null)
        {
            list = new ArrayList<Entry>();
            values[index] = list;
        }

        for (Entry<K,V> entry : (List<Entry<K,V>>) list)
        {
            if (entry.key.equals(key))
            {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key,value);
        list.add(entry);

        return null;
        //todo return the previous value
    }

    @Override
    public V remove(Object key)
    {

        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list != null)
        {
            list.removeIf(entry -> entry.key == key);
        }
        return null;
    }

    @Override
    public void putAll(Map m)
    {
        m.forEach((key, value) -> {
            this.put((K)key,(V)value);
        });
    }

    @Override
    public void clear()
    {
        for(List<Entry> list : values)
        {
            if(list != null)
            {
                list.clear();
            }
        }
    }

    @Override
    public Set keySet()
    {
        Set<K> keySet = new HashSet<>();
        for(List<Entry> list : values)
        {
            if(list != null)
            {
                for(Entry entry : list)
                {
                    keySet.add((K) entry.key);
                }
            }
        }
        return keySet;
    }

    @Override
    public Collection values()
    {
        Collection<V> valueSet = new HashSet<>();
        for(List<Entry> list : values)
        {
            if(list != null)
            {
                for(Entry entry : list)
                {
                    valueSet.add((V) entry.value);
                }
            }
        }
        return valueSet;
    }

    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet()
    {
        return null;
    }
}
