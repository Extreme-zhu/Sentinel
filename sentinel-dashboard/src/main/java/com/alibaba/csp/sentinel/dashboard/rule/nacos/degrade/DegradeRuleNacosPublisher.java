package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosParams;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DegradeRuleNacosProvider
 * @Author zzp
 * @Date 2021/8/31  16:08
 * @Version 1.0
 **/
@Component("degradeRuleNacosPublisher")
public class DegradeRuleNacosPublisher implements DynamicRulePublisher<List<DegradeRuleEntity>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosConfigUtil nacosConfigUtil;
    @Autowired
    private NacosParams nacosParams;

    @Override
    public void publish(String app, List<DegradeRuleEntity> rules) throws Exception {
        nacosConfigUtil.setRuleStringToNacos(
                this.configService,
                app,
                nacosParams.getDegradeDataPostfix(),
                rules
        );
    }
}
