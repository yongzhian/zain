package cn.zain.service;


import cn.zain.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class WordSegementServiceTest {
    private static Logger logger = LogManager.getLogger();

    @Test
    public void jieBaWordSegmentServiceImplTest() throws Exception {
        JieBaWordSegmentServiceImpl jieBaWordSegmentService = new JieBaWordSegmentServiceImpl();
        List<String> result = jieBaWordSegmentService.wordCutting("打开电视", null);
        logger.info(result);
    }

    @Test
    public void ansjBaWordSegmentServiceImplTest() throws Exception {
        AnsjWordSegmentServiceImpl ansjWordSegmentService = new AnsjWordSegmentServiceImpl();
        List<String> result = ansjWordSegmentService.wordCutting("打开电视", null);
        logger.info(result);
    }

    @Test
    public void fnlpWordSegmentServiceImplTest() throws Exception {
        FnlpWordSegmentServiceImpl fnlpWordSegmentService = new FnlpWordSegmentServiceImpl();
        fnlpWordSegmentService.wordCutting("打开电视", null);
    }

    @Test
    public void ikWordSegmentServiceTest() throws Exception {
        IkWordSegmentServiceImpl ikWordSegmentService = new IkWordSegmentServiceImpl();
        List<String> result = ikWordSegmentService.wordCutting("打开电视", null);
        logger.info(result);
    }

    @Test
    public void stanfordWordSegmentServiceTest() throws Exception {
        StanfordWordSegmentServiceImpl stanfordWordSegmentService = new StanfordWordSegmentServiceImpl();
        List<String> result = stanfordWordSegmentService.wordCutting("打开电视,齐悦花园", null);
        logger.info(result);
    }

    @Test
    public void hanlpWordSegmentServiceTest() throws Exception {
        HanlpWordSegmentServiceImpl hanlpWordSegmentService = new HanlpWordSegmentServiceImpl();
        List<String> result = hanlpWordSegmentService.wordCutting("打开电视,齐悦花园", null);
        logger.info(result);
    }
}
