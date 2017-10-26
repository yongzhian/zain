package cn.zain.service.impl;

import cn.zain.model.entity.RobotSceneWord;
import cn.zain.service.WordSegementService;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.wordseg.ChineseDictionary;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * IK分词
 * 部分自定义词典生效
 * @author Zain
 */
public class StanfordWordSegmentServiceImpl implements WordSegementService {
    @Override
    public List<String> wordCutting(String sentence, RobotSceneWord robotSceneWord) throws URISyntaxException {
        List<String> result = new ArrayList<String>();
        ChineseDictionary cd = new ChineseDictionary("stanford/stanford_Dic.dic");
        System.out.println(cd.contains("第1次"));
        StanfordCoreNLP pipeline = new StanfordCoreNLP("stanford/CoreNLP-chinese.properties");        // 用一些文本来初始化一个注释。文本是构造函数的参数。
        Annotation annotation = new Annotation(sentence);
        pipeline.annotate(annotation);
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        CoreMap sentence1 = sentences.get(0);
        List<CoreLabel> tokens = sentence1.get(CoreAnnotations.TokensAnnotation.class);
        for (CoreLabel token : tokens) {
            result.add(token.getString(CoreAnnotations.TextAnnotation.class));
        }
        result.add("------------stanford分词");
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
