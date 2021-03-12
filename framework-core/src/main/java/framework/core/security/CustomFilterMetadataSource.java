package framework.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import framework.core.security.dto.ResourceMeta;
import framework.core.security.service.ResourceMetaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomFilterMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    private final ResourceMetaService service;

    private final AuthCacheManager cacheManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        service.findAllResources();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();

        HttpServletRequest request = fi.getRequest();
        Map<String, List<ResourceMeta>> authorities = cacheManager.getAuthorities();
        List<ResourceMeta> resourceMeta = authorities.entrySet()
                .stream().filter(e -> {
                    return new AntPathRequestMatcher(e.getKey()).matches(request);
                })
                .map(e -> e.getValue())
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());

        if (resourceMeta == null) {
            log.info("resourceMeta is null");
            return null;
        }
        List<String> roles = resourceMeta.stream().map(ResourceMeta::getRoleName).distinct().collect(Collectors.toList());

        String[] stockArr = new String[roles.size()];
        stockArr = roles.toArray(stockArr);

        if (stockArr.length == 0) {
            log.info("resourceMeta stockArr is empty");
            List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
            list.add(null);

            return list;
        }
        return SecurityConfig.createList(stockArr);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
