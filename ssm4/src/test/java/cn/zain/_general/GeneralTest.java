package cn.zain._general;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneralTest {
    private static Logger logger = LogManager.getLogger();
    private static Logger logger2 = LogManager.getLogger(GeneralTest.class);
    private static Logger logger3 = LogManager.getLogger("abc");
    private static Logger logger4 = LogManager.getLogger("cn.zain._general.BaseLogze");

    @Test
    public void loggerTest() throws Exception {
        logger.info(Boolean.TRUE.toString().equals("true"));
        logger.info("来自1");
        logger2.info("来自2");
        logger3.info("来自3");
        logger4.info("来自4");

    }

    @Test
    public void strSubstitutorTest() throws Exception {
        String src = "<RollingFile name=\"Rolling-${sd:type}\" fileName=\"${filename}\"";
        Map<String, Object> map = new HashMap<>();
        map.put("filename", "二娃");
        logger.info(StrSubstitutor.replace(src, map));

        Map valuesMap = new HashMap();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);//输出：The quick brown fox jumped over the lazy dog.
        logger.info(resolvedString);
    }

    @Test
    public void formatTest() throws Exception {
        //%1$表示位置1
        logger.info(String.format("%s,%s,%1$s,%2$s-%1$s", "a", "b"));   //输出：a,b,a,b,a
    }
}
