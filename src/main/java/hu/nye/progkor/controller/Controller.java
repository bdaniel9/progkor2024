// A HTTP kérések kezeléséért felelős.

package hu.nye.progkor.controller;

import java.util.List;

import hu.nye.progkor.entity.Product;
import hu.nye.progkor.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Az osztály felelős a HTTP kérések kezeléséért.
 */
@RestController
@RequiredArgsConstructor
public class Controller {
    /**
     * A csapatok kezeléséért felelős szolgáltatás.
     */
    private final TeamService teamService;

    /**
     * A termék mentése vagy frissítése.
     *
     * @param product a menteni vagy frissíteni kívánt termék
     * @return a válaszüzenet
     */
    @PostMapping(value = "/saveOrUpdate")
    public ResponseEntity<String> saveOrUpdateProduct(
            @RequestBody final Product product) {
        teamService.saveOrUpdateProduct(product);
        return new ResponseEntity<>("Sikeresen mentve: "
                + product.getTeamName(),
                HttpStatus.OK);
    }

    /**
     * Egy termék törlése az azonosítója alapján.
     *
     * @param teamID a törlendő termék azonosítója
     * @return a válaszüzenet
     */
    @DeleteMapping(value = "/delete/{teamID}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable(value = "teamID"
            ) final int teamID) {
        teamService.deleteTeam(teamID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Egy termék frissítése az azonosítója alapján.
     *
     * @param teamID az frissítendő termék azonosítója
     * @param productDetails az új termék adatai
     * @return a válaszüzenet
     */
    @PutMapping("/update/{teamID}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable(value = "teamID")
            final int teamID, @RequestBody final Product productDetails) {
        Product product = teamService.getTeam(teamID);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        product.setTeamName(productDetails.getTeamName());
        teamService.saveOrUpdateProduct(product);
        return ResponseEntity.ok().build();
    }


    /**
     * Az összes termék lekérdezése.
     *
     * @return az összes termék listája
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts =  teamService.getAllTeams();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    /**
     * Egy termék lekérdezése az azonosítója alapján.
     *
     * @param productId a lekérdezni kívánt termék azonosítója
     * @return a lekért termék
     */
    @GetMapping(value = "/getOne")
    public ResponseEntity<Product> getOneProduct(
            @RequestParam("teamID")
            final String productId) {
        Product product = teamService.getTeam(Integer.parseInt(productId));
        return ResponseEntity.ok(product);
    }

    /**
     * Új csapat hozzáadása.
     *
     * @param product az új csapat adatai
     * @return a válaszüzenet
     */
    @PostMapping("/addTeam")
    public ResponseEntity<String> addTeam(
            @RequestBody final Product product
    ) {
        String responseMessage = "Az új csapat hozzá lett adva: "
                + product.getTeamName();
        teamService.saveOrUpdateProduct(product);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
