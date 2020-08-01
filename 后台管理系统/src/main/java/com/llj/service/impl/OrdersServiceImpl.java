package com.llj.service.impl;

import com.github.pagehelper.PageHelper;
import com.llj.dao.IOrdersDao;
import com.llj.domain.Orders;
import com.llj.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception{
        return ordersDao.findById(ordersId);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            ordersDao.delete(id);
        }

    }
}
