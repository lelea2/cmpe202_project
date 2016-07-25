package Base;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kdao on 7/22/16.
 * Data hashmap to fake API display
 */
public class DataHashMap {
    private HashMap<Class<?>, ArrayList> dataHashMap = new HashMap<>();

    //Constructor
    public DataHashMap () {}

    @SuppressWarnings("unchecked")
    public <T> void put(Class<T> key, T value) {
        if(!contains(key)) {
            this.dataHashMap.put(key, new ArrayList<T>());
        }
        this.dataHashMap.get(key).add(value.getClass().cast(value));
    }

    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> get(Class <T> clazz) {
        return this.dataHashMap.get(clazz);
    }

    /**
     * Check hashmap array contains object
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean contains(Class<T> key) {
        return this.dataHashMap.containsKey(key);
    }
}
