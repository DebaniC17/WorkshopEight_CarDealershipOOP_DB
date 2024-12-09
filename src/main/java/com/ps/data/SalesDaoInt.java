package com.ps.data;

import com.ps.models.SalesContract;
import java.util.List;

public interface SalesDaoInt {
    void create(SalesContract salesContract);
    SalesContract getById(int id);
    List<SalesContract> getAll();
    void update(int id, SalesContract salesContract);
    void delete(int id);
}
