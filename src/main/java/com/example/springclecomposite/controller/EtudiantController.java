package com.example.springclecomposite.controller;

import com.example.springclecomposite.dao.IEtudiantDao;
import com.example.springclecomposite.dao.INotationDao;
import com.example.springclecomposite.model.Etudiant;
import com.example.springclecomposite.model.cle.CleNotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EtudiantController {

    IEtudiantDao iEtudiantDao;
    INotationDao iNotationDao;

    @Autowired
    public EtudiantController(
            IEtudiantDao iEtudiantDao,
            INotationDao iNotationDao
    ) {
        this.iEtudiantDao = iEtudiantDao;
        this.iNotationDao = iNotationDao;
    }


    /**
     *
     * Exemple :
     * {
     *     "nom" : "toto",
     *     "prenom" : "tata",
     *     "listeNotation" : [
     *         {
     *             "note" : 15,
     *             "module" : {"id" : 42}
     *         }
     *     ]
     * }
     *
     * @param etudiant
     * @return
     */
    @PutMapping("/sauvegarde-etudiant") // Ajoute une compétence. Ne vérifie pas l'objet donc ne renvoie que du true.
    public boolean sauvegarderEtudiant(@RequestBody Etudiant etudiant)
    {
        iEtudiantDao.saveAndFlush(etudiant); // SAVE AND FLUSH POUR récupérer id

        etudiant.getListeNotation().forEach(notation -> {

            //plus conforme au com.example.demo.model merise
            CleNotation cle = new CleNotation();
            cle.setIdEtudiant(etudiant.getId());
            cle.setIdModule(notation.getModule().getId());

            notation.setId(cle);
            notation.setEtudiant(etudiant);

            iNotationDao.save(notation);
        });

    	return true;
    }
}
