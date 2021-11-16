import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest
{
    @Test
    void get()
    {

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
        map.put("Russin", "Pridie");
        map.put("Japanese", "Ne How");
        map.put("Mandarin", "Conichiui");

        //then
        assertEquals("Hello", map.values[Math.abs("English1".hashCode()) % 1024]);
    }
}