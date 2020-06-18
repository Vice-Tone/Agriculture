package com.ruoyi.project.agricultrue.sev.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SevactivityWithComment {

    private Sevannounce sevannounce;
    private List<Sevcomment> sevcomments;
}
