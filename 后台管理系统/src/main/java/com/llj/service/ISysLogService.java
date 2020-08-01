package com.llj.service;

import com.llj.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page,int size) throws Exception;

    void delete(String[] ids);
}
