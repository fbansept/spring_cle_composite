package com.example.springclecomposite.model.cle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CleNotation implements Serializable {

    @Column(name = "id_etudiant")
    private int idEtudiant;

    @Column(name = "id_module")
    private int idModule;

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleNotation that = (CleNotation) o;
        return idEtudiant == that.idEtudiant &&
                idModule == that.idModule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtudiant, idModule);
    }
}
