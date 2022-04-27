package com.alibaba.csp.sentinel.dashboard.rule.nacos.authority;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosParams;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName AuthorityRuleNacosProvider
 * @Author zzp
 * @Date 2021/9/1  10:44
 * @Version 1.0
 **/
@Component("authorityRuleNacosProvider")
public class AuthorityRuleNacosProvider implements DynamicRuleProvider<List<AuthorityRuleEntity>> {
    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosConfigUtil nacosConfigUtil;
    @Autowired
    private NacosParams nacosParams;

    @Override
    public List<AuthorityRuleEntity> getRules(String appName) throws Exception {
        return nacosConfigUtil.getRuleEntitiesFromNacos(
                this.configService,
                appName,
                nacosParams.getAuthorityDataPostfix(),
                AuthorityRuleEntity.class
        );
    }
}
