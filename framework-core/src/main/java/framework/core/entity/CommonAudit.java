package framework.core.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@DynamicInsert
@JsonIgnoreProperties(
        value = { "useYn", "delYn" },
        allowGetters = true
)
public class CommonAudit extends UserDateAudit {
    @NotBlank
    @Column(name = "USE_YN")
    @ColumnDefault(value = "'Y'")
    private String useYn;

    @NotBlank
    @Column(name = "DEL_YN")
    @ColumnDefault(value = "'N'")
    private String delYn;
}
