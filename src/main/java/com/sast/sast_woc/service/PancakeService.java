package com.sast.sast_woc.service;

import com.sast.sast_woc.pojo.data.Pancake;
import com.sast.sast_woc.pojo.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PancakeService {
    //查询全部饼
    List<Pancake> list();
    void delete(Integer id);
    void draw(Integer id,String title,String ddl,String now);
}
