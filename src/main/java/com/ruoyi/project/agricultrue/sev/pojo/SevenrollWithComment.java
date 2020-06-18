package com.ruoyi.project.agricultrue.sev.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SevenrollWithComment {

    private Sevenroll sevenroll;
    private List<Sevcomment> sevcomments;
}
