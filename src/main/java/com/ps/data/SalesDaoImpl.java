package com.ps.data;

import com.ps.data.VehicleDaoImpl;
import com.ps.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDaoImpl {
    private DataSource dataSource;

    public SalesDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveSalesContract(SalesContract contract) {
        String query = "INSERT INTO sales_contracts (customer_name, customer_email, vin, sale_date, sale_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, contract.getCustomerName());
            preparedStatement.setString(2, contract.getCustomerEmail());
            preparedStatement.setString(3, contract.getVehicleSold().getVin());
            preparedStatement.setDate(4, java.sql.Date.valueOf(contract.getStartDate()));
            preparedStatement.setDouble(5, contract.getTotalPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<SalesContract> getAllSalesContracts() {
        List<SalesContract> contracts = new ArrayList<>();
        String query = "SELECT * FROM sales_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                contracts.add(mapSalesContract(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
    private SalesContract mapSalesContract(ResultSet resultSet) throws SQLException {
        VehicleDaoImpl vehicleDao = new VehicleDaoImpl(dataSource);
        String vin = resultSet.getString("vin");
        return new SalesContract(
                resultSet.getString("sale_date"),
                null,
                resultSet.getString("customer_name"),
                resultSet.getString("customer_email"),
                vehicleDao.getByVin(vin),
                true
        );
    }
}
