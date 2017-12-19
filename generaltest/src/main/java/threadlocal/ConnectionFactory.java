package threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zain
 */
public class ConnectionFactory {
    private static List<Connection> list ;

    public static synchronized Connection createConnection(){
        if(list == null){
            list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new Connection(i));
            }
        }

        for (int i = 0; i < 10; i++) {
            if(!list.get(i).isBusy()){
                list.get(i).setBusy(true);
                return list.get(i);
            }
        }
        return null;
    }

}
