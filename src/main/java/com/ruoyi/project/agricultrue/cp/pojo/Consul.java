package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

@WebMapping("consul")
public class Consul {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;//编号
    @FieldMapping(value = "标题")
    private String title;//标题
    @FieldMapping(value = "内容")
    private String content;//内容
    @FieldMapping(value = "来源")
    private String psource;//来源
    @FieldMapping(value = "发布时间")
    private String enterTime;//发布时间

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Consul{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", psource='" + psource + '\'' +
                ", enterTime='" + enterTime + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPsource() {
        return psource;
    }

    public void setPsource(String psource) {
        this.psource = psource;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }
}
