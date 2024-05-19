/**
 * Ez a csomag a DAO interfészt tartalmazza.
 */

package hu.nye.progkor.dao;

import hu.nye.progkor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Product, Integer> {
}
