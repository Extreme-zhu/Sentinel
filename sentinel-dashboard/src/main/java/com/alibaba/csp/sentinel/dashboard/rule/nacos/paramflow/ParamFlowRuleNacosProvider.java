package com.alibaba.csp.sentinel.dashboard.rule.nacos.paramflow;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosParams;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ParamFlowRuleNacosProvider
 * @Author zzp
 * @Date 2021/9/1  10:20
 * @Version 1.0
 **/
@Component("paramFlowRuleNacosProvider")
public class ParamFlowRuleNacosProvider implements DynamicRuleProvider<List<ParamFlowRuleEntity>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosConfigUtil nacosConfigUtil;
    @Autowired
    private NacosParams nacosParams;

    @Override
    public List<ParamFlowRuleEntity> getRules(String appName) throws Exception {
        return nacosConfigUtil.getRuleEntitiesFromNacos(
                this.configService,
                appName,
                nacosParams.getParamFlowDataPostfix(),
                ParamFlowRuleEntity.class
        );
    }
}
