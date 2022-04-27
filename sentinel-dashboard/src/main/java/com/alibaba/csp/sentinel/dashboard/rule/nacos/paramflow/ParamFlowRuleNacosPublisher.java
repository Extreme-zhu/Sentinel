package com.alibaba.csp.sentinel.dashboard.rule.nacos.paramflow;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosParams;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ParamFlowRuleNacosPublisher
 * @Author zzp
 * @Date 2021/9/1  10:20
 * @Version 1.0
 **/
@Component("paramFlowRuleNacosPublisher")
public class ParamFlowRuleNacosPublisher implements DynamicRulePublisher<List<ParamFlowRuleEntity>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosConfigUtil nacosConfigUtil;
    @Autowired
    private NacosParams nacosParams;

    @Override
    public void publish(String app, List<ParamFlowRuleEntity> rules) throws Exception {
        nacosConfigUtil.setRuleStringToNacos(
                this.configService,
                app,
                nacosParams.getParamFlowDataPostfix(),
                rules
        );
    }
}
