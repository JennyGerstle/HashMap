import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest
{
    @Test
    void get()
    {
        //given
        OurHashMap map = new OurHashMap();

        //when

        //then
        assertNull(map.get("english1"));
    }

    @Test
    void put()
    {
        //given
        OurHashMap map = new OurHashMap();

        //when
        map.put("English1", "Hello");
        map.put("English2", "Hi");
        map.put("English3", "Hey");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjor");
        map.put("Russian", "Pridie");
        map.put("Japanese", "Ne How");
        map.put("Mandarin", "Conichiui");

        //then
        assertEquals("Hello", map.get("English1"));
        assertEquals("Hi", map.get("English2"));
        assertEquals("Hey", map.get("English3"));
        assertEquals("Hola", map.get("Spanish"));
        assertEquals("Shalom", map.get("Hebrew"));
        assertEquals("Bonjor", map.get("French"));
        assertEquals("Pridie", map.get("Russian"));
        assertEquals("Ne How", map.get("Japanese"));
        assertEquals("Conichiui", map.get("Mandarin"));
    }
}