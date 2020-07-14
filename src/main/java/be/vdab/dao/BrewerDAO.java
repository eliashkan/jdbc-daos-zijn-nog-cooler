package be.vdab.dao;

import be.vdab.CategoryException;
import be.vdab.model.Brewer;

import java.util.List;

public interface BrewerDAO {
    // Brewer getBrewerById(int id) throws BrewerException;
    // void updateBrewer(Brewer brewer) throws BrewerException;

    List<Brewer> getBrewersByZipCode(int zipcode) throws CategoryException;
}
