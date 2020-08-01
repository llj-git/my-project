package com.llj.service.impl;

import com.github.pagehelper.PageHelper;
import com.llj.dao.IProductDao;
import com.llj.domain.Product;
import com.llj.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            productDao.delete(id);
        }
    }

    @Override
    public List<Product> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }
}
