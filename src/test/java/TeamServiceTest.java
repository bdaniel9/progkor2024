import hu.nye.progkor.Main;
import hu.nye.progkor.entity.Product;
import hu.nye.progkor.dao.TeamDao;
import hu.nye.progkor.service.TeamService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = TeamServiceTest.class)
public class TeamServiceTest {

    @Mock
    private TeamDao teamDao;

    @InjectMocks
    private TeamService teamService;

    @Test
    public void testSaveOrUpdateProduct() {
        // Arrange
        Product product = new Product();
        product.setTeamName("Team A");
        product.setMainPlayer("Player X");
        product.setCoach("Coach Y");
        product.setStadiumName("Stadium Z");
        product.setStadiumCapacity(50000);

        // Act
        teamService.saveOrUpdateProduct(product);

        // Assert
        verify(teamDao).save(product);
    }
}
