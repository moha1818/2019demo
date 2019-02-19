package com.sunland.utils;

import com.sunland.pojo.SysParameters;
import com.sunland.service.SysParametersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ParamUtils {
    private static HashMap parametersMap = null;

    @Autowired
    private SysParametersService sysParametersService;
    /**
     * 初始化系统参数：从数据库读取
     */
    private void initParameters() {

        parametersMap = new HashMap();
        List paramsList = sysParametersService.selectAll();
        if (paramsList != null && paramsList.size() > 0) {
            for (int i = 0; i < paramsList.size(); i++) {
                SysParameters sysParameters = (SysParameters) paramsList.get(i);
                parametersMap.put(sysParameters.getParaname(), sysParameters.getParavalue());
            }
        }
    }

    public static String getParametersString(String paraName) {
        if (parametersMap != null) {
            Object obj = parametersMap.get(paraName);
            if (obj != null) return obj.toString();
        }
        return null;
    }
}
