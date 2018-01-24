package cn.zain.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class MessageFormatTest {
    private static Logger logger = LoggerFactory.getLogger(MessageFormatTest.class);

    @Test
    public void name() throws Exception {
        String msg = "{0}{1}{2}{3}{4}{5}{6}{7}{9}";
        Object [] array = new Object[]{"A","B","C","D","E","F","G","H","I",};
        logger.info(MessageFormat.format(msg, array));
        //两个单引号才表示一个单引号，单个单引号会被省略
        String value = MessageFormat.format("oh, {0} is 'a' pig", "ZhangSan");  // 输出：oh, ZhangSan is a pig

        value = MessageFormat.format("oh, {0} is ''a'' pig", "ZhangSan");  // 输出：oh, ZhangSan is 'a' pig

        MessageFormat.format("{0}{1}", 1, 2); // 结果12
        MessageFormat.format("'{0}{1}", 1, 2); // 单引号会使其后面的占位符均失效,结果{0}{1}
        MessageFormat.format("'{0}'-{1}", 1, 2); // 结果{0}-2

        value = MessageFormat.format("oh, ''{0}'' is a pig", "ZhangSan"); // 输出：oh, 'ZhangSan' is a pig

        // { ArgumentIndex , FormatType , FormatStyle }
        value = MessageFormat.format("oh, {0,number,#.#} is good num", Double.valueOf("3.1415"));  // 输出：oh, 3.1 is good num

        value = MessageFormat.format("oh, } is good num", Double.valueOf("3.1415")); // 输出：oh, } is good num
        value = MessageFormat.format("oh, { is good num", Double.valueOf("3.1415"));  // java.lang.IllegalArgumentException: Unmatched braces in the pattern.
        MessageFormat.format("'{'{0}}", "X-rapido"); // {X-rapido} //要使用到左花括号需要使用单引号配合使用

        MessageFormat.format("oh, {{ is good num", "d"); // 出现两个或2个以上左花括号，就会出现分割字符串 oh,

//        每调用一次MessageFormat.format方法，都会新创建MessageFormat的一个实例，相当于MessageFormat只使用了一次。

    }
}
