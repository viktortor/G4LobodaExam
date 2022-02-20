package libs;

import java.sql.Timestamp;

public class Util {

    public static String getCurrentTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String currentTimeStamp = " ";
        return currentTimeStamp = String.valueOf(timestamp.getTime());
    }
}
