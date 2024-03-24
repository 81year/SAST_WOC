package com.sast.sast_woc.Mapper;

import com.sast.sast_woc.pojo.data.Pancake;
import com.sast.sast_woc.pojo.response.Response;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Mapper
public interface PancakeMapper {

    @Select("select * from test.sast_pancake_pancake")
    List<Pancake> list();

    @Delete("delete from test.sast_pancake_pancake where id = #{pancake_id}")
    void delete(Integer pancake_id);
    @Insert("INSERT INTO test.sast_pancake_pancake(id,title,ddl,create_time,is_done) values (#{id},#{title},#{ddl},#{time},0)")
    void draw(Integer id,String title, String ddl,String time);

}
