package org.javaboy.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class WindowsCondition implements Condition {
    /**
     * 这个方法实际上就是一个匹配方法，如果这个方法返回 true，则表示匹配成功，否则匹配失败
     * @param context the condition context
     * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     * or {@link org.springframework.core.type.MethodMetadata method} being checked
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取当前操作系统的名字
        String osName = context.getEnvironment().getProperty("os.name");
        return osName.toLowerCase().contains("window");
    }
}
