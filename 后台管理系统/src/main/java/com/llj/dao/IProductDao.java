package com.llj.dao;

import com.llj.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    @Select("select * from product where id=#{id}")
    public Product findById(String id) ;

    @Select("select * from product")
    public List<Product> findAll() ;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(String id);
}
