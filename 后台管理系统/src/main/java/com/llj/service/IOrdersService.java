package com.llj.service;

import com.llj.domain.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrdersService {


    List<Orders> findAll(int page, int size) throws Exception;

    public Orders findById(String ordersId) throws Exception;

    public void delete(String[] ids);
}
