package framework.core.security;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import framework.core.security.dto.ResourceMeta;

@Component
public class AuthCacheManager implements ApplicationListener<AuthCacheEventMessage> {

    private Map<String, List<ResourceMeta>> authorities;

    public Map<String, List<ResourceMeta>> getAuthorities() {
        return authorities;
    }

    public List<ResourceMeta> getAuthorities(String key) {
        return authorities.get(key);
    }

    @Override
    public void onApplicationEvent(AuthCacheEventMessage event) {
        authorities = event.getAuthorities()
                .stream().collect(Collectors.groupingBy(ResourceMeta::getUrl, Collectors.toList()));
    }
}
