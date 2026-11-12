package util;

import java.util.UUID;

public class UniqueIdGenerator {
    public static String getUniqueId(){
        return UUID.randomUUID().toString().substring(0,8);
    }
}
