package threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zain
 */
public class Singleton {
    private static Logger logger = LoggerFactory.getLogger(Singleton.class);

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public Connection getConnection(){
        if(threadLocal.get() == null || threadLocal.get().isBusy()){
            threadLocal.set(ConnectionFactory.createConnection());
        }
        return threadLocal.get();
    }

    public static void main(String[] args) {
        Connection connection0 = ConnectionFactory.createConnection();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();
        logger.info("1:{} , {} ,{}",singleton1,singleton1.getConnection(),singleton1.getConnection().getId());
        logger.info("2:{} , {} ,{}",singleton2,singleton2.getConnection(),singleton2.getConnection().getId());
        logger.info("3:{} , {} ,{}",singleton3,singleton3.getConnection(),singleton3.getConnection().getId());

    }
}
