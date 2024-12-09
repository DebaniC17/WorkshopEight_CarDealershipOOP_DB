package com.ps.data;

import com.ps.models.LeaseContract;
import java.util.List;

public interface LeaseDaoInt {
    void create(LeaseContract leaseContract);
    LeaseContract getById(int id);
    List<LeaseContract> getAll();
    void update(int id, LeaseContract leaseContract);
    void delete(int id);
}
