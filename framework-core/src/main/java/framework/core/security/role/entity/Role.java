package framework.core.security.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import framework.core.entity.CommonAudit;
import framework.core.security.program.entity.Program;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_ROLE")
@SequenceGenerator(name = "TB_ROLE_SQ_GEN", sequenceName = "SQ_TB_ROLE")
public class Role extends CommonAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ROLE_SQ_GEN")
    @Column(name = "SEQ")
    private Long id;

    @NaturalId
    @Column(name = "ROLE_NM", length = 60)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_ROLE_PROGRAM",
            joinColumns = @JoinColumn(name = "ROLE_SEQ"),
            inverseJoinColumns = @JoinColumn(name = "PRGM_SEQ"))
    private List<Program> programs = new ArrayList<Program>();

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

}