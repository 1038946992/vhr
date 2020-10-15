package com.kkk.config;

import com.kkk.model.Menu;
import com.kkk.model.Role;
import com.kkk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 提供权限访问，根据用户传来的请求地址分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取前端传来的请求地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // 匹配数据库中配置的url
        List<Menu> allMenuWithRole = menuService.getAllMenuWithRole();
        for (Menu menu : allMenuWithRole) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                // 如果url匹配上，获取当前请求所需要的角色
                List<Role> roles = menu.getRoles();
                String[] strings = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    strings[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(strings);
            }
        }
        // 一个都没匹配上，给一个标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
