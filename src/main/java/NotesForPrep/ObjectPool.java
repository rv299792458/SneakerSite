package NotesForPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PoolManager {
    private List<Object> inUse;
    private List<Object> free;
    private static int MAX_SIZE = 6;
    private static int INITIAL_SIZE = 3;
    private static PoolManager poolManagerInstance=null;


    private PoolManager() {
        inUse = new ArrayList<>();
        free = new ArrayList<>();
        // create Object
    }

    public PoolManager getPoolManagerInstance(){
        if(Objects.isNull(poolManagerInstance))
            return poolManagerInstance = new PoolManager();
        else
            return poolManagerInstance;
    }

    public synchronized Object getConnection()
    {
        if(!free.isEmpty())
        {
            Object obj = free.remove(0);
            inUse.add(obj);
            return obj;
        }
        else if(inUse.size()>=MAX_SIZE)
        {
            System.out.println("CANNOT CREATE A NEW OBJ");
            return null;
        }
        else
        {
           Object obj = new Object();
            inUse.add(obj);
            return obj;
        }
    }

    public synchronized void ReleaseObject(Object obj)
    {
        if(!inUse.isEmpty())
            inUse.remove(obj);
    }


}


public class ObjectPool {
}
