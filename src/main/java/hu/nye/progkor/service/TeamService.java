package hu.nye.progkor.service;

import java.util.List;

import hu.nye.progkor.dao.TeamDao;
import hu.nye.progkor.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j


public class TeamService {

    /**
     * Az adatbázis műveleteket végző DAO objektum.
     */
    private final TeamDao teamDao;

    /**
     * Termék mentése vagy frissítése az adatbázisban.
     *
     * @param product a menteni vagy frissíteni kívánt termék objektum
     */
    public void saveOrUpdateProduct(final Product product) {
        log.info("Inserting product object: " + product.getTeamName());
        teamDao.save(product);
    }

    /**
     * Az összes csapat objektum lekérése az adatbázisból.
     *
     * @return az összes csapat objektum listája
     */
    public List<Product> getAllTeams() {
        log.info("Finding all product objects");
        return teamDao.findAll();
    }

    /*
    public List<Product> getAllTeams() {
        log.info("Finding all product object");
        return teamDao.findAll();
    }

     */
    /**
     * Egy csapat objektum lekérése az azonosítója alapján.
     *
     * @param teamID a lekérdezni kívánt csapat azonosítója
     * @return a lekért csapat objektum, vagy null, ha nem található
     */
    public Product getTeam(final int teamID) {
        log.info("Finding specific team by id-{}", teamID);
        return teamDao.findById(teamID).orElse(null);
    }

    /**
     * Egy csapatot töröl az azonosítója alapján az adatbázisból.
     *
     * @param teamID a törlendő csapat azonosítója
     * @throws UnsupportedOperationException ha az osztály kiterjeszthetetlen
     */
    public void deleteTeam(final int teamID) {
        log.info("Deleting product object by product id");
        teamDao.deleteById(teamID);
    }

}
