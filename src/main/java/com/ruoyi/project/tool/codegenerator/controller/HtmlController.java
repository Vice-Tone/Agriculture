package com.ruoyi.project.tool.codegenerator.controller;

import com.ruoyi.project.tool.codegenerator.constants.LocationConstants;
import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import java.lang.reflect.Field;

/*
 * 用法：传入实体类的全限定名
 * */
public class HtmlController {

    private String headPart = "<!DOCTYPE html>\n" +
            "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\"\n" +
            "      xmlns:shiro=\"http://www.pollix.at/thymeleaf/shiro\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <link rel=\"stylesheet\" href=\"/layui/css/layui.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"/css/addForm.css\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<fieldset class=\"layui-elem-field layui-field-title\">\n" +
            "    <legend>列表</legend>\n" +
            "</fieldset>\n" +
            "<div class=\"demoTable\">\n" +
            "    <div class=\"layui-inline\">\n" +
            "        <input class=\"layui-input\" placeholder=\"输入关键字搜索：\" name=\"id\" id=\"demoReload\" autocomplete=\"off\">\n" +
            "    </div>\n" +
            "    <button class=\"layui-btn\" data-type=\"reload\">搜索</button>\n" +
            "</div>\n"+
            "<shiro:hasPermission name=\"data:add\">\n" +
            "    <div class=\"layui-card\">\n" +
            "        <div class=\"layui-card-body\">\n" +
            "            <div>\n" +
            "                <button class=\"layui-btn\" id=\"addBtn\">添加</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</shiro:hasPermission>\n" +
            "\n" +
            "<table class=\"layui-hide\" id=\"demo\" lay-filter=\"test\"></table>\n" +
            "<script src=\"/layui/layui.all.js\"></script>\n" +
            "<script src=\"/layui/jquery-3.3.1.js\"></script>\n" +
            "<script type=\"text/html\" id=\"barDemo\">\n" +
            "    <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\n" +
            "    <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "    let layer;\n" +
            "    let table;\n" +
            "    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form'], function () {\n" +
            "        let laydate = layui.laydate //日期\n" +
            "            , layer = layui.layer //弹层\n" +
            "            , table = layui.table; //表格\n" +
            "        let form = layui.form;\n";

    private String footPart = "    });\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    private String entityName;
    private Class clazz;
    private String backUrlValue;
    private StringBuilder contentAll = new StringBuilder();


    public HtmlController(String entityName) {
        this.entityName = entityName;
        try {
            this.clazz = Class.forName(entityName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        contentAll.append(headPart);
    }

    private void getTableRender() {

        Field[] fields = clazz.getDeclaredFields();
        //-----------------------------------------------tableRender---------------------------------------------
        String tableRender = "            table.render({\n" +
                "            elem: '#demo'\n";
        if (clazz.isAnnotationPresent(WebMapping.class)) {
            WebMapping webAnno = (WebMapping) clazz.getAnnotation(WebMapping.class);
            this.backUrlValue = webAnno.value();
            tableRender += "            , url: '/" + backUrlValue + "/list' //数据接口\n";
        }
        tableRender += "            , method: 'get'\n" +
                " , id: 'allAltTable'\n"+
                "            , request: {\n" +
                "                pageName: 'pageIndex'\n" +
                "                , limitName: 'pageSize'\n" +
                "            }\n" +
                "            , title: '列表'\n" +
                "            , page: true //开启分页\n" +
                "            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档\n" +
                "            , totalRow: false //开启合计行\n" +
                "            , cols: [\n" +
                "                [ //表头\n" +
                "                    {type: 'checkbox', fixed: 'left'}\n";

        for (Field field : fields) {
            FieldMapping fieldMapping = field.getAnnotation(FieldMapping.class);
            String fieldName = field.getName();
            String value = fieldMapping.value();
            tableRender += "                    , {field: '" + fieldName + "', title: '" + value + "'}\n";
        }


        tableRender += "                    , {fixed: 'right', title: '操作', align: ' ', toolbar: '#barDemo'}\n" +
                "                ]\n" +
                "            ]\n" +
                "            , done: function () {//设置某列隐藏\n" +
                "                $(\"[data-field='typeId']\").css('display', 'none');\n" +
                "            }\n"+
                "        });\n";
//-----------------------------------------------tableRender   End!---------------------------------------------
        contentAll.append(tableRender);
    }

    private void addBtnStr() {
        Field[] fields = clazz.getDeclaredFields();
        //-----------------------------------------------addBtnStr---------------------------------------------
        String addBtnStr = "var $ = layui.$, active = {\n" +
                "            reload: function () {\n" +
                "                var demoReload = $('#demoReload');\n" +
                "                //执行重载\n" +
                "                table.reload('allAltTable', {\n" +
                "                    page: {\n" +
                "                        curr: 1 //重新从第 1 页开始\n" +
                "                    },\n" +
                "                    url: \"/"+backUrlValue+"/conditionlSel?value=\" + demoReload.val()\n" +
                "                });\n" +
                "            }\n" +
                "        };\n" +
                "\n" +
                "        $('.demoTable .layui-btn').on('click', function () {\n" +
                "            var type = $(this).data('type');\n" +
                "            active[type] ? active[type].call(this) : '';\n" +
                "        });\n"+
                "            $('#addBtn').click(function () {\n" +
                "            let index = layer.open({\n" +
                "                type: 1\n" +
                "                , title: '添加'\n" +
                "                , area: ['500px', 'auto']\n" +
                "                , offset: '100px'\n" +
                "                , content: ` <form class=\"layui-form\"  id=\"addForm\">\n";
        for (Field field : fields) {
            FieldMapping fieldMapping = field.getAnnotation(FieldMapping.class);
            String fieldName = field.getName();
            String value = fieldMapping.value();
            boolean isNeed = fieldMapping.isNeed();
            if (isNeed) {
                addBtnStr += "                        <div class='layui-form-item'>\n" +
                        "                            <label class='layui-form-label' >" + value + "</label>\n" +
                        "                            <div class='layui-input-block'>\n" +
                        "                                <input type='text' name='" + fieldName + "' required  lay-verify='required'  autocomplete='off' class='layui-input'>\n" +
                        "                            </div>\n" +
                        "                        </div>\n";
            }
        }
        addBtnStr += "                   <div class='layui-form-item'>\n" +
                "                            <div class='layui-input-block'>\n" +
                "                                <button type='button' class='layui-btn layui-btn-normal' lay-submit lay-filter='adduser'>添加</button>\n" +
                "                                <button type='reset' class='layui-btn layui-btn-primary'>重置</button>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </form>`\n" +
                "                , success: function () {\n" +
                "                    //同时绑定多个\n" +
                "                    lay('.test-item').each(function () {\n" +
                "                        laydate.render({\n" +
                "                            elem: this\n" +
                "                            , trigger: 'click'\n" +
                "                            , type: 'date'\n" +
                "                            , format: 'yyyy-MM-dd'\n" +
                "                        });\n" +
                "                    });\n" +
                "\n" +
                "                    form.render('select');\n" +
                "                    form.on('submit(adduser)', function (data) {\n" +
                "                        let userData = data.field;\n" +
                "                        $.ajax({\n" +
                "                            type: 'POST',\n" +
                "                            data: userData\n" +
                "                            , dataType: 'json'\n" +
                "                            , url: '/" + this.backUrlValue + "/add'\n" +
                "                            , success: function (res) {\n" +
                "                                if (res.code === 0) {\n" +
                "                                    setTimeout(function () {\n" +
                "                                        alert('添加成功');\n" +
                "                                        //清空表单，关掉弹窗\n" +
                "                                        layer.close(index);\n" +
                "                                        window.location.reload();\n" +
                "                                    }, 1000);\n" +
                "                                } else {\n" +
                "                                    setTimeout(function () {\n" +
                "                                        alert('添加失败');\n" +
                "                                        //清空表单，关掉弹窗\n" +
                "                                        layer.close(index);\n" +
                "                                        window.location.reload();\n" +
                "                                    }, 1000);\n" +
                "                                }\n" +
                "                            }\n" +
                "                            , error: function (msg) {\n" +
                "                                layer.msg('网络异常，请重试');\n" +
                "                            }\n" +
                "                        })\n" +
                "                    })\n" +
                "                }\n" +
                "            })\n" +
                "        });\n";
        //-----------------------------------------------addBtnStr End!---------------------------------------------
        contentAll.append(addBtnStr);
    }

    private void getTableToolBinding() {
        Field[] fields = clazz.getDeclaredFields();
        String tableToolBindingStart = "            table.on('tool(test)', function (obj) {\n" +
                "            let data = obj.data //获得当前行数据\n" +
                "                , layEvent = obj.event; //获得 lay-event 对应的值\n";
        contentAll.append(tableToolBindingStart);

        String layEventDelete = "                if (layEvent === 'del') {\n" +
                "                layer.confirm('真的删除么', function (index) {\n" +
                "                    $.ajax({\n" +
                "                        url: '/" + backUrlValue + "/delete',\n" +
                "                        type: 'POST',\n" +
                "                        dataType: 'json',\n" +
                "                        data: {'id': data.id},\n" +
                "                        success: function (res) {\n" +
                "                            if (res.code === 0) {\n" +
                "                                setTimeout(function () {\n" +
                "                                    alert('删除成功');\n" +
                "                                    layer.close(index);\n" +
                "                                    window.location.reload();\n" +
                "                                }, 1000);\n" +
                "                            } else {\n" +
                "                                alert(' 删除失败 ');\n" +
                "                            }\n" +
                "                        }\n" +
                "                    })\n" +
                "                    //向服务端发送删除指令\n" +
                "                });\n" +
                "            }\n";
        contentAll.append(layEventDelete);

        String layEventEdit = "                else if (layEvent === 'edit') {\n" +
                "                let index = layer.open({\n" +
                "                    type: 1\n" +
                "                    , title: '修改信息'\n" +
                "                    , area: ['500px', 'auto']\n" +
                "                    , offset: '100px'\n" +
                "                    , content: ` <form class='layui-form' action=\"\" id='addForm'>\n";


        for (Field field : fields) {
            FieldMapping fieldMapping = field.getAnnotation(FieldMapping.class);
            String fieldName = field.getName();
            String value = fieldMapping.value();
            layEventEdit += "                        <div class='layui-form-item'>\n" +
                    "                            <label class='layui-form-label' >" + value + "</label>\n" +
                    "                            <div class='layui-input-block'>\n" +
                    "                                <input type='text' name='" + fieldName + "' required  lay-verify='required'  value='${data." + fieldName + "}'  autocomplete='off' class='layui-input'>\n" +
                    "                            </div>\n" +
                    "                        </div>\n";
        }
        layEventEdit += "                        <div class='layui-form-item'>\n" +
                "                            <div class='layui-input-inline' id='btngroup'>\n" +
                "                                <button type='button' class='layui-btn layui-btn-normal' lay-submit lay-filter='adduser'>修改</button>\n" +
                "                                <button type='reset' class='layui-btn layui-btn-primary'>重置</button>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </form>`\n" +
                "                    , success: function () {\n" +
                "                    //同时绑定多个\n" +
                "                    lay('.test-item').each(function () {\n" +
                "                        laydate.render({\n" +
                "                            elem: this\n" +
                "                            , trigger: 'click'\n" +
                "                            , type: 'date'\n" +
                "                            , format: 'yyyy-MM-dd'\n" +
                "                        });\n" +
                "                    });\n"+
                "                        form.render('select');\n" +
                "                        form.on('submit(adduser)', function (data) {\n" +

                "                            let userData = data.field;\n" +
                "                            $.ajax({\n" +
                "                                type: 'POST',\n" +
                "                                data: userData\n" +
                "                                , dataType: 'json'\n" +
                "                                , url: '/" + backUrlValue + "/edit'\n" +
                "                                , success: function (res) {\n" +
                "                                    //0 成功\n" +
                "                                    //500 失败\n" +
                "                                    if (res.code === 0) {\n" +
                "\n" +
                "                                        setTimeout(function () {\n" +
                "                                            alert('修改成功');\n" +
                "                                            layer.close(index);\n" +
                "                                            window.location.reload();\n" +
                "                                        }, 1000);\n" +
                "\n" +
                "                                    } else {\n" +
                "\n" +
                "                                        setTimeout(function () {\n" +
                "                                            alert('修改失败');\n" +
                "                                            layer.close(index);\n" +
                "                                            window.location.reload();\n" +
                "                                        }, 1000);\n" +
                "\n" +
                "                                    }\n" +
                "                                }\n" +
                "                                , error: function (msg) {\n" +
                "                                    layer.msg('网络异常，请重试');\n" +
                "                                }\n" +
                "                            })\n" +
                "                        })\n" +
                "                    }\n" +
                "                })\n" +
                "            }\n";
        contentAll.append(layEventEdit);
        String tableToolBindingEnd = "        });\n";
        contentAll.append(tableToolBindingEnd);
        contentAll.append(footPart);
    }


    public String getHtml() {
        this.getTableRender();
        this.addBtnStr();
        this.getTableToolBinding();

        String filePath = LocationConstants.HTML_LOCATION + "\\" + this.backUrlValue + ".html";
        LocationConstants.writeToFile(this.contentAll.toString(), filePath);
        return this.contentAll.toString();
    }


}
