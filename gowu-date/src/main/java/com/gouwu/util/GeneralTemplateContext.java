package com.gouwu.util;

import java.util.HashMap;
import java.util.Map;

public class GeneralTemplateContext implements TemplateContext {
    private HashMap<String, Object> varTable = new HashMap<String, Object>();

    public GeneralTemplateContext() {
    }

    public GeneralTemplateContext(Map<String, Object> defaultVals) {
        if (defaultVals != null) {
            varTable.putAll(defaultVals);
        }
    }

    public Object getTmplVar(String name) {
        return varTable.get(name);
    }

    public void setVar(String name, Object val) {
        this.varTable.put(name, val);
    }
}
