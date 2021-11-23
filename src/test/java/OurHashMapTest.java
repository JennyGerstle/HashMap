import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest
{
    @Test
    void size()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");
        map.put("Mandarin", "Conichiwa");

        //then
        assertEquals(5, map.size());
    }
    @Test
    void isNotEmpty()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //then
        assertFalse(map.isEmpty());
    }
    @Test
    void isEmpty()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.remove("English1");
        //then
        assertTrue(map.isEmpty());
    }
    @Test
    void containsKey()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //then
        assertTrue(map.containsKey("Spanish"));
        assertFalse(map.containsKey("English2"));
    }
    @Test
    void containsValue()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //then
        assertTrue(map.containsValue("Hola"));
        assertFalse(map.containsValue("Hey"));
    }
    @Test
    void get()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when

        //then
        assertNull(map.get("english1"));
    }

    @Test
    void put()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("English2", "Hi");
        map.put("English3", "Hey");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");
        map.put("Russian", "Privit");
        map.put("Japanese", "Ne How");
        map.put("Mandarin", "Conichiwa");

        //then
        assertEquals("Hello", map.get("English1"));
        assertEquals("Hi", map.get("English2"));
        assertEquals("Hey", map.get("English3"));
        assertEquals("Hola", map.get("Spanish"));
        assertEquals("Shalom", map.get("Hebrew"));
        assertEquals("Bonjour", map.get("French"));
        assertEquals("Privit", map.get("Russian"));
        assertEquals("Ne How", map.get("Japanese"));
        assertEquals("Conichiwa", map.get("Mandarin"));
    }

    @Test
    void putSameKey()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");
        map.put("English1", "Hi");

        //then
        assertEquals("Hi", map.get("English1"));
    }
    @Test
    void remove()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //when
        map.remove("Spanish");
        //then
        assertFalse(map.containsKey("Spanish"));
        assertNull(map.remove("English"));
    }
    @Test
    void putAll()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        Map<String, String> putMap = new HashMap<>();
        putMap.put("English1", "Hello");
        putMap.put("Spanish", "Hola");
        putMap.put("Hebrew", "Shalom");
        putMap.put("French", "Bonjour");

        //when
        map.putAll(putMap);

        //then
        assertNotNull(map);
        assertEquals(map.get("English1"), putMap.get("English1"));
    }
    @Test
    void clear()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //when
        map.clear();
        //then
        assertFalse(map.containsKey("Spanish"));
    }
    @Test
    void keySet()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        Set<String> set = new HashSet<>();
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //when
        set = map.keySet();
        //then
        assertTrue(set.contains("English1"));
        assertFalse(set.contains("hi"));
    }
    @Test
    void valueSet()
    {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        Collection<String> collection = new HashSet<>();
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");

        //when
        collection = map.values();
        //then
        assertTrue(collection.contains("Hello"));
        assertFalse(collection.contains("hi"));
    }

}