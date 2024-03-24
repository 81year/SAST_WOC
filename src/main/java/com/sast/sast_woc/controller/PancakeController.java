package com.sast.sast_woc.controller;
import com.sast.sast_woc.pojo.data.Pancake;
import com.sast.sast_woc.pojo.data.Pancakes;
import com.sast.sast_woc.pojo.response.Response;
import com.sast.sast_woc.service.impl.PancakeServiceimpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PancakeController {
    Integer pid=-1;
    @Resource
    private PancakeServiceimpl pancakeServiceimpl;
    @GetMapping("/pancake")
    public Response querypancake(){
        List<Pancake> pancakes = pancakeServiceimpl.list();
        Pancakes result = new Pancakes(pancakes);
        return Response.success(result);
    }
    @PostMapping("/pancake/{pancake_id}")
    public Response dopancake(@PathVariable Integer pancake_id){
        pid = pancake_id;
        return Response.success();
    }
    @PutMapping("/pancake")
    public Response drawpancake(@RequestBody Pancake pancake){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeString = now.format(formatter);
        if(pid<=0){
            return Response.error();
        }
        pancakeServiceimpl.draw(pid,pancake.getTitle(),pancake.getDdl(),currentTimeString);
        return Response.success();
    }
    @DeleteMapping("/pancake/{pancake_id}")
    public Response deletepancake(@PathVariable Integer pancake_id){
        pancakeServiceimpl.delete(pancake_id);
        return Response.success();
    }
}
