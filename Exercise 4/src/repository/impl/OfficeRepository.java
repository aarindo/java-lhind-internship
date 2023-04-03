package repository.impl;

import mapper.OfficeMapper;
import model.entity.Office;
import util.JdbcConnection;
import util.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficeRepository extends BaseRepository<Office, String> {

    public OfficeRepository() {
        super(new OfficeMapper());
    }

    @Override
    public List<Office> findAll() {
        List<Office> offices = new ArrayList<>();
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ALL_OFFICES)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Office office = getMapper().map(result);
                offices.add(office);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return offices;
    }

    @Override
    public Office findById(String s) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_OFFICE_BY_ID)) {
            statement.setString(1, s);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return getMapper().map(result);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }


    @Override
    public Boolean exists(String s) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_IF_OFFICE_EXISTS)) {
            statement.setString(1, s);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("The office with the office code " + '\'' + s + '\'' + " exists!");
                return true;
            } else {
                System.out.println("The office with the office code " + '\'' + s + '\'' + " does not exist!");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public Boolean save(Office office) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.ADD_OFFICE)) {

            statement.setString(1, office.getId());
            statement.setString(2, office.getCity());
            statement.setString(3, office.getPhone());
            statement.setString(4, office.getAddressLine1());
            statement.setString(5, office.getAddressLine2());
            statement.setString(6, office.getState());
            statement.setString(7, office.getCountry());
            statement.setString(8, office.getPostalCode());
            statement.setString(9, office.getTerritory());

            statement.executeUpdate();
            System.out.println("Record has been added.");

        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public Integer update(Office office) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_OFFICE, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, office.getCity());
            statement.setString(2, office.getPhone());
            statement.setString(3, office.getAddressLine1());
            statement.setString(4, office.getAddressLine2());
            statement.setString(5, office.getState());
            statement.setString(6, office.getCountry());
            statement.setString(7, office.getPostalCode());
            statement.setString(8, office.getTerritory());
            statement.setString(9, office.getId());

            statement.executeUpdate();
            int rowsAffected = statement.getUpdateCount();
            System.out.println(rowsAffected + " rows have been affected.");
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }
}
