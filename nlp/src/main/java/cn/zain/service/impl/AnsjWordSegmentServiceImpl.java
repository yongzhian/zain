package cn.zain.service.impl;

import cn.zain.model.entity.RobotSceneWord;
import cn.zain.service.WordSegementService;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * IK分词
 * @author Zain
 */
public class AnsjWordSegmentServiceImpl implements WordSegementService {
    @Override
    public List<String> wordCutting(String sentence, RobotSceneWord robotSceneWord) throws URISyntaxException {
        //无须词典文件，直接加载
    //只关注这些词性的词
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");
            add("v");
            add("vd");
            add("vn");
            add("vf");
            add("vx");
            add("vi");
            add("vl");
            add("vg");
            add("nt");
            add("nz");
            add("nw");
            add("nl");
            add("ng");
            add("userDefine");
            add("wh");
        }};
        DicLibrary.insert(DicLibrary.DEFAULT,"打开电视");
        //分词结果的一个封装，主要是一个List<Term>的terms
        Result result = ToAnalysis.parse(sentence);
        //拿到terms
        List<Term> terms = result.getTerms();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < terms.size(); i++) {
            res.add(terms.get(i).getName());
        }
        return res;
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
