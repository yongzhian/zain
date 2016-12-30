package com.zain.view;

import com.zain.util.JsonSerializeUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MappingJsonlibVeiw extends AbstractView {
    
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    
    public static final String DEFAULT_CHAR_ENCODING = "UTF-8";
 
    private String encoding = DEFAULT_CHAR_ENCODING;
 
    private Set<String> renderedAttributes;

    public MappingJsonlibVeiw() {
        setContentType(DEFAULT_CONTENT_TYPE);
    }
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        model = filterModel(model);
        response.setCharacterEncoding(encoding);
        PrintWriter out = response.getWriter();
        out.print(JsonSerializeUtils.serialize(model));
    }

    protected Map<String, Object> filterModel(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>(model.size());
        Set<String> renderedAttributes =
                !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : model.keySet();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            if (!(entry.getValue() instanceof BindingResult) && renderedAttributes.contains(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

	 
}