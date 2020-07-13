package be.vdab.dao;

import be.vdab.BrewerException;
import be.vdab.model.Brewer;

public interface BrewerDAO {
    Brewer getBrewerById(int id) throws BrewerException;
    void updateBrewer(Brewer brewer) throws BrewerException;
}
