package be.vdab;

import be.vdab.dao.BeerDAO;
import be.vdab.dao.BeerDAOImpl;
import be.vdab.model.Beer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BeerTests {

    BeerDAO beerDAO = new BeerDAOImpl();

    @Test
    @DisplayName("Test if beer id 21 is updated")
    void testUpdateBeer() {

        Beer testBeer = null;
        Beer beerFoundInDBAfterUpdate = new Beer();

        try {

            // Make beer object with id 21 and different values
            testBeer = beerDAO.getBeerByID(21);
            testBeer.setName("RANDOMNESS");
            testBeer.setStock(500000);
            testBeer.setPrice(20F);
            testBeer.setAlcohol(20F);

            // Update that beer in the database
            beerDAO.updateBeer(testBeer);

            // Get same beer from database
            beerFoundInDBAfterUpdate = beerDAO.getBeerByID(testBeer.getId());

        } catch (BeerException e) {
            fail();
            e.printStackTrace();
        }

        // Assert that result of getBeerById is same as original beer used to update
        assertEquals(testBeer, beerFoundInDBAfterUpdate,
                "Beer in database after update didn't match the original you tried to write.");

    }
}
