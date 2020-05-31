package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author: TongYaZhou
 * @create: 2020-05-31 18:13
 * 此类作用：CustomFilterInvocationSecurityMetadataSource中返回了执行此路径都需要哪些角色，我们在这个类中拿到用户拥有的角色，去匹配一下。
 * 看当前用户是否有相应角色
 **/
@Component
public class CustomDecisionUrlManager implements AccessDecisionManager {
    /**
     *
     * @param authentication  存储着用户拥有的角色
     * @param object
     * @param configAttributes 存储执行该路径需要的角色
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            //遍历执行此菜单需要的角色列表，获取到每个角色
            String needRole = configAttribute.getAttribute();
            //如果角色为ROLE_LOGIN证明此菜单是登录后就可以访问的
            if (needRole.equals("ROLE_LOGIN")){
                //既然此菜单是登录后就可以访问的，那我们需要判断一下此用户是否登录了，如果没有登录就抛异常，如果登录了就直接放行。
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录,请登录!");
                }else {
                    return;
                }
            }
            //获取用户拥有的角色列表
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //遍历角色列表，获取到用户拥有的每个角色
                String authority1 = authority.getAuthority();
                //判断用户是否拥有执行此菜单的角色，如果有直接放行
                if (needRole.equals(authority1)){
                    return;
                }
            }
        }
        //如果上面的逻辑都没有满足，证明此用户不具有访问该菜单的权利!
        throw new AccessDeniedException("权限不足,请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
