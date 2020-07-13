package be.vdab.dao;

import be.vdab.BeerException;
import be.vdab.model.Beer;

public interface BeerDAO {
    Beer getBeerByID(int id) throws BeerException;

    void updateBeer(Beer beer) throws BeerException;
}
