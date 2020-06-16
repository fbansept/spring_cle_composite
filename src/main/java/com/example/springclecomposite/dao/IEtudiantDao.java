package com.example.springclecomposite.dao;

import com.example.springclecomposite.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantDao extends JpaRepository<Etudiant, Integer> {

}
