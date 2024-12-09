package com.ps.models;

import com.ps.data.LeaseDaoImpl;
import com.ps.data.SalesDaoImpl;

import java.util.List;

public class Dealership {
    private int dealershipId;
    private String name;
    private String address;
    private String phone;
    private SalesDaoImpl salesDao;
    private LeaseDaoImpl leaseDao;

    public Dealership(int dealershipId, String name, String address, String phone, SalesDaoImpl salesDao, LeaseDaoImpl leaseDao) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salesDao = salesDao;
        this.leaseDao = leaseDao;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SalesDaoImpl getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    public LeaseDaoImpl getLeaseDao() {
        return leaseDao;
    }

    public void setLeaseDao(LeaseDaoImpl leaseDao) {
        this.leaseDao = leaseDao;
    }

    public void addSalesContract(SalesContract contract) {
        salesDao.create(contract);
    }
    public List<SalesContract> getAllSalesContracts() {
        return salesDao.getAll();
    }

    public void addLeaseContract(LeaseContract contract) {
        leaseDao.create(contract);
    }
    public List<LeaseContract> getAllLeaseContracts() {
        return leaseDao.getAll();
    }
}
