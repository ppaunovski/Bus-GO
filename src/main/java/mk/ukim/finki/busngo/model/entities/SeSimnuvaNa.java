package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
//@jakarta.persistence.Table(name = "se_simnuva_na", schema = "project", catalog = "db_202324z_va_prj_busngo")
//@jakarta.persistence.IdClass(mk.ukim.finki.busngo.model.entities.SeSimnuvaNaPK.class)
public class SeSimnuvaNa {
    @EmbeddedId
    private SeSimnuvaNaPK id;


}
