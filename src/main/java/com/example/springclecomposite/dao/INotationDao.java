package com.example.springclecomposite.dao;

import com.example.springclecomposite.model.Notation;
import com.example.springclecomposite.model.cle.CleNotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotationDao extends JpaRepository<Notation, CleNotation> {

}
