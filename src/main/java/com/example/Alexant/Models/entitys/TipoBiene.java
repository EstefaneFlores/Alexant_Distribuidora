package com.example.Alexant.Models.entitys;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_biene")
public class TipoBiene implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_biene")
    private Integer id_tipo_biene;

    @Column(name = "nombre_tipo_biene")
    private String nombre_tipo_biene;

    @Column(name = "estado_tipo_biene")
    private String estado_tipo_biene;

/*========================================================= */
/*========================================================= */

	// -------------------------------------

	@Column(name = "registroTipoBiene", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroTipoBiene;

	@PrePersist
    protected void onCreate() {
        this.registroTipoBiene = LocalDate.now();
    }

	@Column(name = "modificacionTipoBiene")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionTipoBiene;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionTipoBiene = LocalDate.now();
    }

	// ----------------
 
    @Column(name = "usuario_registroTipoBiene")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroTipoBiene;
 
    @Column(name = "usuario_modificacionTipoBiene")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionTipoBiene;


    // ------------------------
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_biene", fetch = FetchType.LAZY)
    private List<Biene> biene;

}
