package framework.core.security.dao;

import java.util.List;

import framework.core.security.dto.ResourceMeta;

public interface ResourceMetaDao {
    public List<ResourceMeta> selectAllAuthorities();
}
