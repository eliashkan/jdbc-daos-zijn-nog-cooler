package be.vdab.dao;

import be.vdab.CategoryException;
import be.vdab.model.Category;

public interface CategoryDAO {
    Category getCategoryById(int id) throws CategoryException;
    void updateBeer(Category category) throws CategoryException;
}
