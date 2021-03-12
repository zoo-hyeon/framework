package framework.core.security.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import framework.core.security.role.entity.QRole;
import framework.core.security.role.entity.Role;

@Repository
public class RoleRepositorySupport extends QuerydslRepositorySupport {

    public RoleRepositorySupport() {
        super(Role.class);
    }

    public List<Role> findByName(String name) {
        QRole role = QRole.role;
        return from(role)
                .where(role.name.eq(name))
                .fetch();
    }
}
