package com.ruoyi.project.agricultrue.sev.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SevquestionWithComment {

    private Sevquestion sevquestion;
    private List<Sevcomment> sevcomments;
}
