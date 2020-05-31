package org.javaboy.vhr.config;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.MenuService;
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
 * @author: TongYaZhou
 * @create: 2020-05-31 17:03
 *
 * 此类作用：返回有权执行该路径的角色列表(通俗的说就是执行当前路径都需要哪些角色,把这些角色找到并返回)
 **/
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    /**
     * 创建路径匹配工具
     */
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的url地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获取菜单列表及各个菜单有权访问的角色
        List<Menu> menuListWithRole = menuService.getMenuListWithRole();
        for (Menu menu : menuListWithRole) {
            //循环遍历菜单列表,匹对一下请求的路径和数据库中哪个路径相匹配。
            if (antPathMatcher.match(menu.getUrl(), requestUrl)){
                //找到匹配菜单之后，获取访问该菜单需要的角色列表
                List<Role> roles = menu.getRoles();
                String[] strArr = new String[roles.size()];
                //由于该方法的返回值是Collection<ConfigAttribute>，所以这里用SecurityConfig.createList来构建返回值,但是该方法的参数是一个可变长参数，所以要做一下转换
                for (int i = 0, len = roles.size(); i < len; i++) {
                    //注意security默认的权限会以ROLE_匹配，但是由于我们数据库中已经加了ROLE，所以这里就不需要加了。如果数据库中没有加，这里需要手动在角色前面添加一个ROLE_
                    strArr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(strArr);
            }
        }
        //如果请求的路径没有在数据库中记录(是有这种可能的)，那么默认给他设置成登录后即可访问。注意这里的ROLE_LOGIN只是做标记，而不是已经达到了权限控制的目的。后续我们需要拿到这个标记自己去做处理
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
