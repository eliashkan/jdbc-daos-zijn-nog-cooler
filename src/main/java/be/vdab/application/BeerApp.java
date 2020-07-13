package be.vdab.application;

import be.vdab.BeerException;
import be.vdab.dao.BeerDAO;
import be.vdab.dao.BeerDAOImpl;
import be.vdab.model.Beer;

public class BeerApp {
    public static void main(String[] args) {

        Beer beerToUpdate = new Beer();
        beerToUpdate.setId(4);
        beerToUpdate.setName("Andere Naam");
        beerToUpdate.setStock(100000000);
        beerToUpdate.setAlcohol(15);
        beerToUpdate.setPrice(0.5F);

        BeerDAO beerDAO = new BeerDAOImpl();

        try {
            beerDAO.updateBeer(beerToUpdate);
        } catch (BeerException e) {
            e.printStackTrace();
        }
    }
}
