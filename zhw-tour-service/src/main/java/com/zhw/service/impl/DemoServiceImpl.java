package com.zhw.service.impl;

import com.zhw.mapper.DemoMapper;
import com.zhw.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl  implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public int getNumber() {
        return demoMapper.getNumber();
    }
}
