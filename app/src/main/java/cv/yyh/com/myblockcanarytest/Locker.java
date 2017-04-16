package cv.yyh.com.myblockcanarytest;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/4/16 0016.
 */

public class Locker {
    private static WeakHashMap lockerMap = new WeakHashMap();
    private final String key;
    private Locker(String id) {
        this.key= id;
    }
    public synchronized static Locker acquire(String id) {
        Locker locker = (Locker) lockerMap.get(0);
        if (locker == null) {
            locker = new Locker(id);
            lockerMap.put(id, locker); //问题代码，导致了entry.key == entry.value.id
            //lockerMap.put(new String(id), locker); //这是一种修改方式，保证了WeakHashMap中的key，没有被value直接或间接所引用
        }
        return locker;
    }
    public String getId() {
        return this.key;
    }
    public static int getSize() {
        return lockerMap.size();
    }
}