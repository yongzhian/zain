package cn.zain.service.impl;

import cn.zain.model.entity.RobotSceneWord;
import cn.zain.service.WordSegementService;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 结巴分词
 * @author Zain
 */
public class JieBaWordSegmentServiceImpl implements WordSegementService {
    private static String DIC_PATH = "/jieba/jieba_Dic.dict";
    @Override
    public List<String> wordCutting(String sentence, RobotSceneWord robotSceneWord) throws URISyntaxException {
        //基于robotSceneWord生成模型文件,生成词典
        //todo
        JiebaSegmenter segmenter = new JiebaSegmenter();
        URL url1 = JieBaWordSegmentServiceImpl.class.getResource(DIC_PATH);
        Path dictPath = Paths.get(url1.toURI());
        WordDictionary.getInstance().loadUserDict(dictPath);
        List<String> jiebaResult = segmenter.sentenceProcess(sentence);
        return jiebaResult;
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
