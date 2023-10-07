package org.javaboy.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class MyCondition implements ConfigurationCondition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断当前容器中是否存在一个名为 a 的 Bean
        return context.getBeanFactory().containsBean("a");
    }

    /**
     * 返回条件注解评估的阶段：
     * 1。 要么在配置类解析的时候评估条件注解 PARSE_CONFIGURATION
     * 2。 要么在注册 Bean 的时候再去评估条件注解 REGISTER_BEAN
     * @return
     */
    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }
}
