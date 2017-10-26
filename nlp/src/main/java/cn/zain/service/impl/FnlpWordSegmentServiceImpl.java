package cn.zain.service.impl;

import cn.zain.model.entity.RobotSceneWord;
import cn.zain.service.WordSegementService;
import org.fnlp.ml.types.Dictionary;
import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.nlp.cn.tag.CWSTagger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 复旦fnlp分词
 *
 * @author Zain
 */
public class FnlpWordSegmentServiceImpl implements WordSegementService {
    private static String DIC_PATH_SEG = "/fudan/seg.m";
    private static String DIC_PATH_DIC = "/fudan/fudan_Dic.txt";

    @Override
    public List<String> wordCutting(String sentence, RobotSceneWord robotSceneWord) throws Exception {
        List<String> result = new ArrayList<>();
        URL url1 = FnlpWordSegmentServiceImpl.class.getResource(DIC_PATH_SEG);
        URL url2 = FnlpWordSegmentServiceImpl.class.getResource(DIC_PATH_DIC);
        CWSTagger tag2 = new CWSTagger(url1.getPath(), new Dictionary(url2.getPath()));
        String s2 = tag2.tag(sentence);
        return result;
    }

    @Override
    public boolean addWords2Robot(List<String> words, RobotSceneWord robotSceneWord) {
        return false;
    }

    @Override
    public boolean deleteWords2Robot(List<String> words, RobotSceneWord robotSceneWord) {
        return false;
    }
}
