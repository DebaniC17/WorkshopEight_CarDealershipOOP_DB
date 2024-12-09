package com.ps.data;

import com.ps.models.LeaseContract;
import com.ps.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseDaoImpl implements LeaseDaoInt {
    private DataSource dataSource;

    public LeaseDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(LeaseContract leaseContract) {
        String query = "INSERT INTO lease_contracts (customer_name, customer_email, vin, lease_start_date, lease_end_date, monthly_payment) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, leaseContract.getCustomerName());
            preparedStatement.setString(2, leaseContract.getCustomerEmail());
            preparedStatement.setString(3, leaseContract.getVehicleSold().getVin());
            preparedStatement.setDate(4, Date.valueOf(leaseContract.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(leaseContract.getEndDate()));
            preparedStatement.setDouble(6, leaseContract.getMonthlyPayment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LeaseContract getById(int id) {
        String query = "SELECT * FROM lease_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapLeaseContract(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LeaseContract> getAll() {
        List<LeaseContract> leaseContracts = new ArrayList<>();
        String query = "SELECT * FROM lease_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                leaseContracts.add(mapLeaseContract(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaseContracts;
    }

    @Override
    public void update(int id, LeaseContract leaseContract) {
        String query = "UPDATE lease_contracts SET customer_name = ?, customer_email = ?, vin = ?, lease_start_date = ?, lease_end_date = ?, monthly_payment = ? " +
                "WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, leaseContract.getCustomerName());
            preparedStatement.setString(2, leaseContract.getCustomerEmail());
            preparedStatement.setString(3, leaseContract.getVehicleSold().getVin());
            preparedStatement.setDate(4, Date.valueOf(leaseContract.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(leaseContract.getEndDate()));
            preparedStatement.setDouble(6, leaseContract.getMonthlyPayment());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM lease_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private LeaseContract mapLeaseContract(ResultSet resultSet) throws SQLException {
        VehicleDaoImpl vehicleDao = new VehicleDaoImpl(dataSource);
        String vin = resultSet.getString("vin");
        Vehicle vehicle = vehicleDao.getByVin(vin);

        return new LeaseContract(
                resultSet.getString("lease_start_date"),
                resultSet.getString("lease_end_date"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_email"),
                vehicle
        );
    }
}

