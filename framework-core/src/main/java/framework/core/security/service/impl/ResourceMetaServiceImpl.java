package framework.core.security.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import framework.core.security.AuthCacheEventMessage;
import framework.core.security.dto.ResourceMeta;
import framework.core.security.mapper.ResourceMetaMapper;
import framework.core.security.service.ResourceMetaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceMetaServiceImpl implements ResourceMetaService {

    private final ResourceMetaMapper resourceMetaMapper;
    private final ApplicationContext applicationContext;

    @Override
    public void findAllResources() {
        List<ResourceMeta> authorities = resourceMetaMapper.selectAllAuthorities();

        authorities.stream().forEach(item -> {
            log.info("role name {} ", item.getRoleName());
            log.info("url {}", item.getUrl());
        });
        applicationContext.publishEvent(new AuthCacheEventMessage(this, authorities));
    }
}
