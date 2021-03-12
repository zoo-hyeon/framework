package framework.core.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import framework.core.security.dto.ResourceMeta;

@Mapper
public interface ResourceMetaMapper {
    public List<ResourceMeta> selectAllAuthorities();
}
