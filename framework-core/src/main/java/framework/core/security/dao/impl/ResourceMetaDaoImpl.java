package framework.core.security.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import framework.core.security.dao.ResourceMetaDao;
import framework.core.security.dto.ResourceMeta;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ResourceMetaDaoImpl implements ResourceMetaDao {

    private final SqlSession sqlSession;

    private final String pkgName = "framework.core.security.dao.ResourceMetaDao.";

    @Override
    public List<ResourceMeta> selectAllAuthorities() {
        return sqlSession.selectList(pkgName + "selectAllAuthorities");
    }

}
