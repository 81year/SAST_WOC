package com.sast.sast_woc.service.impl;

import com.sast.sast_woc.Mapper.PancakeMapper;
import com.sast.sast_woc.pojo.data.Pancake;
import com.sast.sast_woc.pojo.response.Response;
import com.sast.sast_woc.service.PancakeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PancakeServiceimpl implements PancakeService {
    @Resource
    private PancakeMapper pancakeMapper;

    @Override
    public List<Pancake> list() {
        return pancakeMapper.list();
    }

    @Override
    public void delete(Integer id) {
       pancakeMapper.delete(id);
    }

    @Override
    public void draw(Integer id,String title, String ddl, String now) {
        pancakeMapper.draw(id,title,ddl,now);
    }
}
