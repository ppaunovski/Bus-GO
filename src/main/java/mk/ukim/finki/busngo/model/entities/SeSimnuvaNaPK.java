package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SeSimnuvaNaPK implements Serializable {
    private Long vozenjeId;
    private Long pnlId;
}
