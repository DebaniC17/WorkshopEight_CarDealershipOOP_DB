package com.ps.data;

import com.ps.models.SalesContract;
import com.ps.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesDaoImpl implements SalesDaoInt {
    private DataSource dataSource;
    private VehicleDaoImpl vehicleDao;

    public SalesDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.vehicleDao = new VehicleDaoImpl(dataSource);
    }

    @Override
    public void create(SalesContract salesContract) {
        String query = "INSERT INTO sales_contracts (customer_name, customer_email, vin, sale_date, sale_price) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, salesContract.getCustomerName());
            preparedStatement.setString(2, salesContract.getCustomerEmail());
            preparedStatement.setString(3, salesContract.getVehicleSold().getVin());
            preparedStatement.setDate(4, Date.valueOf(salesContract.getStartDate()));
            preparedStatement.setDouble(5, salesContract.getTotalPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SalesContract getById(int id) {
        String query = "SELECT * FROM sales_contracts WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapToSalesContract(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SalesContract> getAll() {
        List<SalesContract> salesContracts = new ArrayList<>();
        String query = "SELECT * FROM sales_contracts";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                salesContracts.add(mapToSalesContract(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesContracts;
    }

    @Override
    public void update(int id, SalesContract salesContract) {
        String query = "UPDATE sales_contracts SET customer_name=?, customer_email=?, vin=?, sale_date=?, sale_price=? WHERE id=?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, salesContract.getCustomerName());
            preparedStatement.setString(2, salesContract.getCustomerEmail());
            preparedStatement.setString(3, salesContract.getVehicleSold().getVin());
            preparedStatement.setDate(4, Date.valueOf(salesContract.getStartDate()));
            preparedStatement.setDouble(5, salesContract.getTotalPrice());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM sales_contracts WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private SalesContract mapToSalesContract(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String customerName = resultSet.getString("customer_name");
        String customerEmail = resultSet.getString("customer_email");
        String vin = resultSet.getString("vin");
        String saleDate = resultSet.getString("sale_date");
        double salePrice = resultSet.getDouble("sale_price");

//        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl(dataSource);
//        Vehicle vehicle = vehicleDAO.getByVin(vin);

        Vehicle vehicle = null;
        throw new SQLException("Vehicle with VIN " + vin + " not found in database");

    }
}

