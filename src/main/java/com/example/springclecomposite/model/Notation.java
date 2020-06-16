package com.example.springclecomposite.model;

import com.example.springclecomposite.model.cle.CleNotation;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Notation {

    @EmbeddedId
    CleNotation id;

    @ManyToOne
    @MapsId("id_etudiant")
    @JoinColumn(name = "id_etudiant")
    Etudiant etudiant;

    @ManyToOne
    @MapsId("id_module")
    @JoinColumn(name = "id_module")
    Module module;

    Integer note;

    public CleNotation getId() {
        return id;
    }

    public void setId(CleNotation id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
