package framework.core.security;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import framework.core.security.dto.ResourceMeta;

public class AuthCacheEventMessage extends ApplicationEvent {

    final List<ResourceMeta> authorities;

    public AuthCacheEventMessage(Object source, final List<ResourceMeta> authorities) {
        super(source);
        this.authorities = authorities;
    }

    public List<ResourceMeta> getAuthorities() {
        return authorities;
    }
}
