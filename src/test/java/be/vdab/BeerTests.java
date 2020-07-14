package be.vdab;

import be.vdab.dao.BeerDAOImpl;
import be.vdab.model.Beer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class BeerTests {

    @Test
    @DisplayName("Test if beer id 21 is updated")
    void testUpdateBeer() {

        // Make beer object with id 21 and different values
        Beer testBeer = null;
        try {
            testBeer = new BeerDAOImpl().getBeerByID(21);
        } catch (BeerException e) {
            fail();
            e.printStackTrace();
        }

        testBeer.setName("RANDOMNESS");
        testBeer.setStock(500000);
        testBeer.setPrice(20F);
        testBeer.setAlcohol(20F);

        // Update that beer in the database
        try {
            new BeerDAOImpl().updateBeer(testBeer);
        } catch (BeerException e) {
            fail();
            e.printStackTrace();
        }

        // Get same beer from database
        Beer beerFoundInDBAfterUpdate = new Beer();
        try {
            beerFoundInDBAfterUpdate = new BeerDAOImpl().getBeerByID(testBeer.getId());
        } catch (BeerException e) {
            fail();
            e.printStackTrace();
        }

        // Assert that result of getBeerById is same as original beer used to update
        assertEquals(testBeer, beerFoundInDBAfterUpdate,
                "Beer in database after update didn't match the original you tried to write.");

    }
}
