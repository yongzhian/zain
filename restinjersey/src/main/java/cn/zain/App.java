package cn.zain;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * @author Zain
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        ResourceConfig config = new ResourceConfig().packages("cn.zain.controller");
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/app/"), config);
        logger.info("Start Grizzly Server success...");
        logger.info("you can test by url: http://127.0.0.1:8080/app/user/tom");
        System.in.read();
        httpServer.shutdown();


        //sun的jersey1.x版本 不推荐
//        URI uri = UriBuilder.fromUri("http://127.0.0.1").port(8080).build();
//        ResourceConfig rc = new PackagesResourceConfig("cn.zain.controller");
//        HttpServer server = null;
//        try {
//            server = GrizzlyServerFactory.createHttpServer(uri, rc);
//            server.start();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        logger.info("Start Grizzly Server success...");
//        System.in.read();
//        server.stop();
    }
}
