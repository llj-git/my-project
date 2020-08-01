package com.llj.controller;

import com.github.pagehelper.PageInfo;
import com.llj.domain.Product;
import com.llj.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/delete.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(String[] ids) {
        if (ids != null && ids.length != 0) {
            productService.delete(ids);
        }
        return "redirect:/product/findAll.do";
    }
}
