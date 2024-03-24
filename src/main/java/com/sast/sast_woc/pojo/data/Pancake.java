package com.sast.sast_woc.pojo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pancake {
    private Integer id;
    private String title;
    private String creatTime;
    private String ddl;
    private boolean isDone;
}
