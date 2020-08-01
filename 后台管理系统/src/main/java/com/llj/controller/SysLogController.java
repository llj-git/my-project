package com.llj.controller;

import com.github.pagehelper.PageInfo;
import com.llj.domain.SysLog;
import com.llj.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogList= sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
       mv.setViewName("syslog-list");
        return mv;
    }

    @RequestMapping("/delete.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(String[] ids) {
        if (ids != null && ids.length != 0) {
            sysLogService.delete(ids);
        }
        return "redirect:/sysLog/findAll.do";
    }
}
