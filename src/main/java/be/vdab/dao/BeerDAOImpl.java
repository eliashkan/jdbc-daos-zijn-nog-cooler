package be.vdab.dao;

import be.vdab.BeerException;
import be.vdab.model.Beer;

import java.sql.*;

import static be.vdab.ConnectionUtils.*;

public class BeerDAOImpl implements BeerDAO {

    @Override
    public Beer getBeerByID(int id) throws BeerException {

        try (Connection con = DriverManager.getConnection(
                ADDRESS,
                USER,
                PASSWORD);

             PreparedStatement prepstat = con.prepareStatement(
                     "SELECT * FROM Beers WHERE Id = ?"
             );

             ResultSet rs = prepstat.executeQuery()
        ) {

            prepstat.setInt(1, id);

                if (rs.next()) {
                    Beer resultingBeer = new Beer();
                    resultingBeer.setId(id);
                    resultingBeer.setName(rs.getString("Name"));
                    resultingBeer.setPrice(rs.getFloat("Price"));
                    resultingBeer.setAlcohol(rs.getFloat("Alcohol"));
                    resultingBeer.setStock(rs.getInt("Stock"));
                    return resultingBeer;
                } else {
                    return null;
                }

        } catch (SQLException sqlException) {
            System.out.println("oops something went wrong");
            sqlException.printStackTrace();
            throw new BeerException(sqlException);
        }
    }

    @Override
    public void updateBeer(Beer beer) throws BeerException {

        // Connection
        try (Connection con = DriverManager.getConnection(
                ADDRESS,
                USER,
                PASSWORD);

             // Prepared Statement
                PreparedStatement prepstat = con.prepareStatement(
                        "UPDATE Beers SET Name=?, Price=?, Alcohol=?, Stock=? WHERE Id=?"
                )
        ) {

            // Vraagtekens setten
            prepstat.setString(1, beer.getName());
            prepstat.setFloat(2, beer.getPrice());
            prepstat.setFloat(3, beer.getAlcohol());
            prepstat.setInt(4, beer.getStock());
            prepstat.setInt(5, beer.getId());

            // Execute!
            prepstat.executeUpdate();

        } catch (Exception e) {
            // catch... BeerException
            System.out.println("something went wrong :)");
            e.printStackTrace();
            throw new BeerException(e);
        }
    }
}
