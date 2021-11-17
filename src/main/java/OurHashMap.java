import java.util.*;

public class OurHashMap implements Map
{
    private final int SIZE = 16;
    class Entry
    {
        Object key;
        Object value;

        public Entry(Object key, Object value)
        {
            this.key = key;
            this.value = value;
        }
    }
    List<Entry> values[] = new List[SIZE];
    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return false;
    }

    @Override
    public boolean containsValue(Object value)
    {
        return false;
    }

    @Override
    public Object get(Object key)
    {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode % SIZE);
        List<Entry> list = values[index];
        if (list == null)
        {
            return null;
        }
        for(Entry entry : list)
        {
            if(entry.key.equals(key))
            {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value)
    {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode % SIZE);
        Entry entry = new Entry(key, value);
        List list = values[index];
        if(list == null)
        {
            list = new ArrayList<Entry>();
            values[index] = list;
        }
        list.add(entry);
        //todo return the previous value
        return null;
    }

    @Override
    public Object remove(Object key)
    {
        return null;
    }

    @Override
    public void putAll(Map m)
    {

    }

    @Override
    public void clear()
    {

    }

    @Override
    public Set keySet()
    {
        return null;
    }

    @Override
    public Collection values()
    {
        return null;
    }

    @Override
    public Set<Entry> entrySet()
    {
        return null;
    }
}
