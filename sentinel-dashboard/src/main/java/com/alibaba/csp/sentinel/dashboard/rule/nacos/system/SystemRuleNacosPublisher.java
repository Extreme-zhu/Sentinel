package com.alibaba.csp.sentinel.dashboard.rule.nacos.system;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosParams;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SystemRuleNacosPublisher
 * @Author zzp
 * @Date 2021/9/1  10:32
 * @Version 1.0
 **/
@Component("systemRuleNacosPublisher")
public class SystemRuleNacosPublisher implements DynamicRulePublisher<List<SystemRuleEntity>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosConfigUtil nacosConfigUtil;
    @Autowired
    private NacosParams nacosParams;

    @Override
    public void publish(String app, List<SystemRuleEntity> rules) throws Exception {
        nacosConfigUtil.setRuleStringToNacos(
                this.configService,
                app,
                nacosParams.getSystemDataPostfix(),
                rules
        );
    }
}
