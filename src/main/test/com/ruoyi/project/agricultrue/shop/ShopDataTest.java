package com.ruoyi.project.agricultrue.shop;


import com.ruoyi.AgricultrueApplication;
import com.ruoyi.project.agricultrue.sp.mapper.SpimageMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductdetailMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spimage;
import com.ruoyi.project.agricultrue.sp.pojo.Spproduct;
import com.ruoyi.project.agricultrue.sp.pojo.Spproductdetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class ShopDataTest {

    @Autowired
    private SpproductMapper spproductMapper;

    @Autowired
    private SpimageMapper spimageMapper;

    @Autowired
    private SpproductdetailMapper spproductdetailMapper;

    @Test
    public void generateData_01() {
        int linkId = 1;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("手扶拖拉机带电启动座椅旋地机 手扶旋耕机");
        spproduct.setMainUrl("http://img68.nongjx.com/2/20191126/637103591513786183589_480_347_5.jpg");
        spproduct.setXinghao("HS");
        spproduct.setBrand("宏燊");
        spproduct.setCompany("生产商");
        spproduct.setLocation("曲阜市");
        spproduct.setPrice("4380");
        spproduct.setRealMoney("4380");
        spproduct.setMobile("86-0537-4553099");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(1);
        spproduct.setTypeName("手扶拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20191008/637061227190103816876_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20190329/636894469068763763953_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img56.nongjx.com/2/20171111/636459847404274177453_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img68.nongjx.com/2/20191008/637061227156562311469_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/9/20191214/637119107608678633601.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("宏燊");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);
        spproductdetail.setBrief("<p>手扶拖拉机带电启动座椅旋地机 手扶旋耕机手扶拖拉机旋耕机农用小型旋耕机手扶除草旋耕机果园大棚微耕机松土机手扶式开沟机水田旱田手扶犁地机手扶拖拉机打田机四驱柴油汽油微耕机电启动小型手扶拖拉机耕田机手扶拖拉机耕地机<br/></p>");
        spproductdetail.setDetail("<p><strong>手扶拖拉机带电启动座椅旋地机 手扶旋耕机</strong><strong>手扶拖拉机带电启动座椅旋地机 手扶旋耕机</strong>手扶拖拉机旋耕机农用小型旋耕机手扶除草旋耕机果园大棚微耕机松土机手扶式开沟机水田旱田手扶犁地机手扶拖拉机打田机四驱柴油汽油微耕机电启动小型手扶拖拉机耕田机手扶拖拉机耕地机</p><p><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">手扶拖拉机配套的旋耕机是用螺栓直接固紧于拖拉机变速箱体上</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">因此不需要万向节</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">直接用动力输出轴传动</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">.</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">提升时旋耕机可绕主梁转动</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">动力由变速箱传动齿轮通过侧边传动链带动刀辊旋转</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">.</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">一般由旋耕刀</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">变速齿轮箱</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">左、右臂壳体</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">传动箱</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">左支臂和刀滚等组成一个框状矩形机架</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">以承受旋耕作业产生的力矩</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">.</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">在矩形机架的上部装有旋耕机罩壳</span><span style=\"color:rgb(101,104,111); font-family:helvetica; font-size:18px\">,</span><span style=\"color:rgb(101,104,111); font-family:宋体; font-size:18px\">在罩壳的尾轮架上装有乘坐装置的尾轮机构。</span></p><p><span style=\"font-family:宋体; font-size:16px\">该产</span><span style=\"font-family:宋体; font-size:16px\">品操作简单、配套农机具齐全，适用范围广，其在果园旋耕、大棚开沟起垄、梯田旋耕、坡地开沟等地域作业以及在棉花起垄、玉米开沟起垄、葡萄埋藤、茶园开沟施肥、烟草培土、苗木除草等经济作物的中耕、松土、除草等。种姜、出姜、土豆挖掘，更能发挥，独到之处，其体积小、力量大、用途广泛。</span></p><p><span style=\"font-family:宋体; font-size:16px\">主要用途：用于农业大棚和农田旋耕、开荒、松土、培土、起垄。适用范围：主要进行大棚作业、菜地、花场、果园、水田、山坡等小地块作业。</span></p><p><span style=\"font-size:16px\">&nbsp;一、本产品机型为牵引、驱动兼用型，</span><span style=\"font-size:16px\">并缩短了柴油机与变速箱的距离，不需使用配重铁，具有外形美观，结构紧凑合理，可靠，耐用，操作轻便，灵活，适应性强等优点。</span></p><p><span style=\"font-size:16px\">二、该产品广泛适用于平原、山区、丘陵等地区的水旱田作业。</span></p><p><span style=\"font-size:16px\">三、配上相应的农机具，可进行犁耕、旋耕、耙田、收割、平整、碎土、播种、运输、抽水等多种作业。</span></p><p><span style=\"font-size:16px\">四。配有照明设施，可进行夜间作业。</span></p><p><span style=\"font-family:宋体; font-size:18px\">犁耕作业</span></p><p><span style=\"font-family:宋体; font-size:18px\">手扶拖拉机牵引单向双铧犁作业时．一侧驱动轮在未耕地上．另一侧驱动轮在犁沟内．两轮与地面间的附着系数不同，打滑率各异，致使机组常向一个方向偏驶。对于手扶拖拉机可进行以下的调整加以解决：调整牵引架上左右两个调整螺钉与中间连接架之间的间隙值(摆动间隙)，在犁耕过程中，如发现拖拉机仍向右偏驶，可将两个紧固螺钉松开，旋短左调整螺钉的伸出部分，旋长右螺钉的伸出部分。直到放开扶手架机组能沿沟壁正常行驶为止。</span></p><p><span style=\"font-family:宋体; font-size:18px\">旋耕作业</span></p><p><span style=\"font-family:宋体; font-size:18px\">旋耕作业中产生偏驶的可能原因：尾轮又变形、尾轮轴在叉内装配不到位等使尾轮偏斜：尾轮轴上的轴承损坏或严重磨损：犁刀装错或断裂、掉落。当旋耕作业发生跑偏现象时，应针对具体情况对相关零件进行矫正、修复、重装或更换。在问题解决前，应尽量不使用转向离合器纠偏，而是用推拉扶手架的方法纠偏。</span></p><p><span style=\"font-family:宋体; font-size:18px\">开沟作业</span></p><p><span style=\"font-family:宋体; font-size:18px\">一般手扶拖拉机配置的主要是小圆盘式开沟机，主要用来开挖田间排水沟。开沟作业直线性差的主要原因：刀盘平面对称中心线与手扶拖拉机驱动轮轴中心平面偏差超过规定(偏差8mm，偏差5&nbsp;mm)：刀盘扭曲变形，机架变形歪斜．犁刀安装错误，犁刀断裂、脱落等。应注意检查、矫正刀盘和机架。正确安装旋切犁刀，认真调整好刀盘位置，发现犁刀断裂、脱落，应立即停机熄火．更换部件。</span></p><p><span style=\"font-size:16px\"><strong>手扶拖拉机技术参数</strong>：</span></p><p><span style=\"font-size:16px\">1、型号:101B</span></p><p><span style=\"font-size:16px\">2、配套旋耕机型号：HS-100(mm)</span></p><p><span style=\"font-size:16px\">3、手扶配套后尾轮乘坐</span></p><p><span style=\"font-size:16px\">4、拖拉机型式:驱动、牵引兼用型</span></p><p><span style=\"font-size:16px\">5、外形尺寸:(长x宽x高）mm：2170x845x1150</span></p><p><span style=\"font-size:16px\">6、轮距：680-750（mm）</span></p><p><span style=\"font-size:16px\">7、标定功率：7.35-8.8kw</span></p><p><span style=\"font-size:16px\">8、重量：290(kg)</span></p><p><span style=\"font-size:16px\">9、档位数:前进/倒退，6/2</span></p><p><span style=\"font-size:16px\">10、连接方式：皮带连接</span></p><p><span style=\"font-size:16px\">11、启动方式：手摇启动</span></p><p><span style=\"font-size:16px\">12、发动机型式：单杠、卧式、水冷、四冲程</span></p><p><span style=\"font-size:16px\">13、发动机型号:190/192/195</span></p><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_02() {
        int linkId = 2;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("云南40马力农用小型拖拉机");
        spproduct.setMainUrl("http://img71.nongjx.com/2/20200229/637185893243707524939_82_82_5.jpg");
        spproduct.setXinghao("xnjx-10");
        spproduct.setBrand("xnjx");
        spproduct.setCompany("生产商");
        spproduct.setLocation("曲阜市");
        spproduct.setPrice("13000.00");
        spproduct.setRealMoney("13000.00");
        spproduct.setMobile("86-0537-4553099");
        spproduct.setUpdateTime("2020-03-13 08:34:46");
        spproduct.setTypeId(1);
        spproduct.setTypeName("手扶拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20200229/637185893243707524939_82_82_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20200229/637185893212038712525_82_82_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img68.nongjx.com/2/20200229/637185893310321232246_82_82_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img68.nongjx.com/2/20200229/637185893300180972654_82_82_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("其他品牌");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保两年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300CM,宽:1500CM,高:145CM");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);
        spproductdetail.setBrief("<p>云南40马力农用小型拖拉机<br/>性能好、质量精良、操作简单、配套农机具齐全，适用范围广，成其在果园、大棚、梯田、坡地等地域作业以及在棉花、玉米、葡萄、茶园、烟草、苗木等经济作物的中耕、松土、除草等。种姜、出姜、土豆挖掘，更能发挥，独到之处，其体积小、力量大、用途广泛。本横轴式旋耕机有较强的碎土能力，一次作业即能使土壤细碎，土肥掺和均匀，地面平整，达到旱地播种或水田栽插的要求，有利于争取\n" +
                "\t &nbsp; &nbsp;</p>");

        spproductdetail.setDetail("<p><strong>云南40马力农用小型拖拉机</strong></p><p><span style=\"font-family:宋体\">技术参数</span></p><p><span style=\"font-family:宋体\">【柴油</span>15<span style=\"font-family:宋体\">马力拖拉机为例】</span></p><p><span style=\"font-family:宋体\">外形尺寸：车长</span>2000mm&nbsp;<span style=\"font-family:宋体\">宽</span>980mm&nbsp;<span style=\"font-family:宋体\">高</span>1100mm<span style=\"font-family:宋体\">，机器总长</span>2500mm</p><p><span style=\"font-family:宋体\">重量：</span>500<span style=\"font-family:宋体\">公斤</span></p><p><span style=\"font-family:宋体\">配套动力：</span>15<span style=\"font-family:宋体\">马力</span></p><p><span style=\"font-family:宋体\">耕深：</span>30-45<span style=\"font-family:宋体\">厘米</span></p><p><span style=\"font-family:宋体\">耕宽：</span>1.25<span style=\"font-family:宋体\">厘米（耕宽可调节）</span></p><p><span style=\"font-family:宋体\">前轮型号：</span>500-10<span style=\"font-family:宋体\">平纹，前轮轮距</span>50cm<span style=\"font-family:宋体\">左右；</span></p><p><span style=\"font-family:宋体\">后轮型号：</span>600-12<span style=\"font-family:宋体\">人字花，后轮轮距</span>60cm<span style=\"font-family:宋体\">左右</span></p><p><span style=\"font-family:宋体\">后轮轮距：</span>1.2<span style=\"font-family:宋体\">米</span></p><p><span style=\"font-family:宋体\">启动方式：电启动</span></p><p><span style=\"font-family:宋体\">档位数量：</span>8<span style=\"font-family:宋体\">个档（低</span>4<span style=\"font-family:宋体\">档，高</span>4<span style=\"font-family:宋体\">档）</span></p><p><span style=\"font-family:宋体\">右转弯半径：</span>3.5<span style=\"font-family:宋体\">米</span></p><p><span style=\"font-family:宋体\">左转弯半径：</span>2.5<span style=\"font-family:宋体\">米</span></p><p><span style=\"font-family:宋体\">升降方式：液压升降</span></p><p><span style=\"font-family:宋体\">旋耕机转速：高</span>410R/M<span style=\"font-family:宋体\">，低：</span>280R/M</p><p><span style=\"font-family:宋体\">旋耕深度：</span>30-45cm</p><p><span style=\"font-family:宋体\">离地距离：</span>25CM</p><p><strong>云南40马力农用小型拖拉机</strong></p><p><span style=\"font-family:microsoft yahei; font-size:14px\">四轮拖拉机，田园管理机是专门为果园、菜地、温室大棚、丘陵坡地和小块地作业而设计的农机产品。新型四轮拖拉机，多功能田园管理机本机车身短小，马力足，是丘陵地区，果树植保，松土施肥，收果运输等理想的农机，达到了一机多用,受到广大用户的*好评。新型四轮管理机在创新、品质方面有突破性进展，该机型小巧、灵活、外形美观。外观设计合理。该产品可配套40多种农机具，能够完成旋耕、除草、开沟、培土、起垄、埋沟、埋藤、覆膜、犁耕、播种、施肥、抽水、喷药、运输、土豆割秧、土豆收获、花生收获、大葱收获、水田作业等。适用于平原、蔬菜大棚、果园、坡地、梯田等大型农业机械难以作业的地方，配套不同农机具可以完成不同的农艺作业。多功能田园管理机。该机结构合理，结实耐用，采用了特制后桥，选配20——45马力名牌柴油机。主要优点是操作灵活，用的是大后桥，大柴油机，耐用不坏。单缸，多缸等多种机型！该机配套产品有旋耕机﹑喷药机﹑施肥机﹑锄草机﹑翻转犁﹑播种机﹑拖斗﹑葡萄埋藤机等农机具，是果农朋友的好帮手。</span></p><p><span style=\"font-family:microsoft yahei; font-size:14px\">外形尺寸：偏座2100mm×1100mm×900mm正座2300mmX1000mmX1150mm&nbsp;\n" +
                " &nbsp;整机重量：750--800 kg&nbsp; &nbsp; 配套动力： 20--45马力&nbsp; &nbsp; &nbsp; &nbsp;联接方式：悬挂式&nbsp; 可配套机具： \n" +
                "旋耕机，葡萄埋藤机，秸秆还田机，挖坑机，起垄机，开沟施肥机，旋耕起垄机，单铧翻转犁，双铧翻转犁， 锄草轮 开沟机，施肥机 打药机 \n" +
                "双铧犁，回填机，除草轮等&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;配套旋耕机宽度：0.9m--1.2mm&nbsp; 前轮型号：400-12（可选配） \n" +
                "后轮型号：600-12（可选配） 启动方式：电启动升降方式：齿轮泵液压升降 轴距:1600mm&nbsp; &nbsp; &nbsp; 变速箱：6+1组合式&nbsp; \n" +
                "&nbsp;输出方式：一轴输出 710，900/后输出540&nbsp;&nbsp; <br/></span></p><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_03() {
        int linkId = 3;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("手扶拖拉机带的秸秆收割机");
        spproduct.setMainUrl("http://img49.nongjx.com/2/20180330/636580147789453568130_480_347_5.jpg");
        spproduct.setXinghao("HS");
        spproduct.setBrand("圣隆");
        spproduct.setCompany("生产商");
        spproduct.setLocation("济宁市");
        spproduct.setPrice("面议");
        spproduct.setRealMoney("面议");
        spproduct.setMobile("86-0537-4553099");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(1);
        spproduct.setTypeName("手扶拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img49.nongjx.com/2/20180330/636580147789453568130_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img50.nongjx.com/2/20180330/636580147866051041516_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img50.nongjx.com/2/20180330/636580147908795863256_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img49.nongjx.com/2/20180330/636580147707395990666_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img50.nongjx.com/2/20180330/636580147894755593110_400_400_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("圣隆");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);
        spproductdetail.setBrief("<p>手扶拖拉机带的秸秆收割机，该机具有结构简单、合理、操作维修方便，体积小、重量轻、能耗低、性能稳定、可靠性好、适用性强等特点。特别适用于小地块、山地、丘陵及需要秸杆利用地区的水稻、三麦以及大豆，芦苇,辣椒的收割。</p>");
        spproductdetail.setDetail("<p><span style=\"font-size:14px\"><strong>手扶拖拉机带的秸秆收割机</strong></span></p><p><span style=\"font-size:14px\"><span style=\"font-family:宋体\">该机具有结构简单、合理、操作维修方便，体积小、重量轻、能耗低、性能稳定、可靠性好、</span><br/><span style=\"font-family:宋体\">适用性强等特点。特别适用于小地块、山地、丘陵及需要秸杆利用地区的水稻、三麦以及大豆，芦苇,辣椒的收割。</span></span></p><p><span style=\"font-size:14px\"><strong>手扶拖拉机带的秸秆收割机</strong></span></p><p><span style=\"font-size:14px\"><span style=\"font-family:宋体\">配套主机由发动机、传动变速箱、机架、控制运动的多功能扶手及加宽轮胎构成，主要用于收割小麦、水稻等桔梗作物，适应于平台地势、株高在0.5~1.5米，茎杆直径（倒伏小于45°）风力小于4级，非雨天作业。割晒机的动力输出轴经传动轴传到割台变速箱，经变速箱爪型离合和一对伞齿轮传递给偏心曲柄滑框机构来驱动割刀，同时又经链轮链条传给输送链主动轴，从而带动上下输送链运动。扶禾带是由扶禾器星轮带动。扶禾器星轮的运动由输送链拔齿来带动。</span></span></p><p><span style=\"font-size:14px\"></span></p><p><span style=\"font-size:14px\"><strong><span style=\"font-family:宋体\">主要技术参数</span></strong></span></p><p><br/><span style=\"font-size:14px\"><span style=\"font-family:宋体\">主离合方式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family:宋体\">&nbsp;齿轮结合式</span><br/><span style=\"font-family:宋体\">行走离合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family:宋体\">右手手动离合</span><br/><span style=\"font-family:宋体\">行走轮直径&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family:宋体\">&nbsp;470MM</span><br/><span style=\"font-family:宋体\">行走变速档数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-family:宋体\">&nbsp;前进一档，后退一档，空挡一档</span><br/><span style=\"font-family:宋体\">动力输出轴转速&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"font-family:宋体\">1800转/分</span><br/><span style=\"font-family:宋体\">外形尺寸MM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp; &nbsp; &nbsp; &nbsp; <span style=\"font-family:宋体\">长2390x宽1470x高900</span><br/><span style=\"font-family:宋体\">重量&nbsp; &nbsp;</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"font-family:宋体\">115KG</span><br/><span style=\"font-family:宋体\">作业幅宽&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;<span style=\"font-family:宋体\">0.8M</span><br/><span style=\"font-family:宋体\">割台形式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;<span style=\"font-family:宋体\">立式</span><br/><span style=\"font-family:宋体\">辅放形式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;<span style=\"font-family:宋体\">侧向条放</span><br/><span style=\"font-family:宋体\">割刀行程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;<span style=\"font-family:宋体\">50MM</span></span></p><p>&nbsp;</p><p><span style=\"font-size:14px\"><span style=\"font-family:宋体\">机器包装发货：机器属于大件货物一律物流发货，发到显示物流网点验货自提。提货时请务必当场验货没问题再签收，如有问题请及时！自付款之日起如无特殊情况当天通过物流发货，具体运费咨询厂家。</span></span></p><p><span style=\"font-size:14px\"><span style=\"font-family:宋体\">机器售后服务：我们对我们所售机械承诺终身服务，机械保修期一年，常年提供零配件及技术咨询。每台机械卖出去，只是我们合作的开始，您在机械使用过程中，有任何问题都可以随时跟我们，专业的技术人员会及时跟您沟通，共同解决难题，“凡出言，信为先”圣隆机械始终坚持以人为本，诚信经营的服务理念”真诚期待与您的合作。</span></span></p><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_04() {
        int linkId = 4;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("优质农用拖拉机 大棚王");
        spproduct.setMainUrl("http://img69.nongjx.com/2/20190313/636880739509851788904.jpg");
        spproduct.setXinghao("DP33");
        spproduct.setBrand("圣隆");
        spproduct.setCompany("生产商");
        spproduct.setLocation("邢台市");
        spproduct.setPrice("13300");
        spproduct.setRealMoney("13300");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(2);
        spproduct.setTypeName("农用拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20190313/636880739509851788904_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20190313/636880740483922032847_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20190313/636880740538990385217_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190313/636880819962843509534_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190313/636880820063308153594_400_400_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("圣隆");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);

        spproductdetail.setBrief("<p>优质农用拖拉机 大棚王该机配套产品有旋耕机﹑喷药机﹑施肥机﹑锄草机﹑翻转犁﹑播种机﹑拖斗﹑葡萄埋藤机等农机具，是果农朋友的好帮手。 &nbsp; &nbsp; &nbsp;\n" +
                "棚王 &nbsp;专业生产四轮拖拉机，小四轮拖拉机，大棚王系列拖拉机。配套各种农机具。 前轮型号：400-12（可选配） 后轮型号：600-12（可选配）\n" +
                " 启动方式：电启动升降方式：齿轮泵液压升降 轴距:1600mm<br/></p>");
        spproductdetail.setDetail("<p><strong>大棚王</strong><strong>优质农用拖拉机 大棚王</strong>该机配套产品有旋耕机﹑喷药机﹑施肥机﹑锄草机﹑翻转犁﹑播种机﹑拖斗﹑葡萄埋藤机等农机具，是果农朋友的好帮手。&nbsp;\n" +
                " &nbsp; &nbsp; 棚王&nbsp; 专业生产四轮拖拉机，小四轮拖拉机，大棚王系列拖拉机。配套各种农机具。 前轮型号：400-12（可选配） \n" +
                "后轮型号：600-12（可选配） 启动方式：电启动升降方式：齿轮泵液压升降 轴距:1600mm&nbsp; \n" +
                "&nbsp;多功能田园管理机。该机结构合理，结实耐用，采用了特制后桥，选配20——45马力名牌柴油机。主要优点是操作灵活，用的是大后桥，大柴油机，耐用不坏。单缸，多缸等多种机型！该机配套产品有旋耕机﹑喷药机﹑施肥机﹑锄草机﹑翻转犁﹑播种机﹑拖斗﹑葡萄埋藤机等农机具，是果农朋友的好帮手。</p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_05() {
        int linkId = 5;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("菱代-120 多功能果园管理机 旋耕机");
        spproduct.setMainUrl("http://img71.nongjx.com/2/20190802/637003619680137509733_480_347_5.jpg");
        spproduct.setXinghao("LD-120");
        spproduct.setBrand("其他品牌");
        spproduct.setCompany("生产商");
        spproduct.setLocation("洛阳市");
        spproduct.setPrice("3300");
        spproduct.setRealMoney("3300");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2019-08-02 17:04:16");
        spproduct.setTypeId(2);
        spproduct.setTypeName("农用拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190802/637003619680137509733_480_347_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20190802/637003619803535091607_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190802/637003620926905493573_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img68.nongjx.com/2/20190802/637003619913672503404_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20190802/637003620278249177248_400_400_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("其他品牌");
        spproductdetail.setType("全新");
        spproductdetail.setService("全国联保");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);

        spproductdetail.setBrief("<p>菱代-120 多功能果园管理机 \n" +
                "主要功能功能有：旋耕，割草，打药，施肥，开沟，回填，起垄，树枝粉碎和运输平台等。本产品适合空间比较狭窄的果园，大棚，苗木，园林及林业和农业的多功能作业使用，整机采用遥控操作，实现人机分离，安全可靠，操作简单易学，九大功能可满足客户的不同需求，生产作业效率高，性能稳定，深受广大客户的喜爱。</p>");
        spproductdetail.setDetail("<p><strong>菱代-120型多功能履带式遥控果园管理机</strong>，是我公司在满足不同用户作业需求和实践论证，在原有产品的基础上，自主开发研制的新一代多功能机型。该产品主要用于果园开沟施化肥和有机肥料、旋耕、喷药、除草、园区开沟排水作业。该机体积小（外形尺寸为：总长2.3米、宽1米、高0.93米），操作灵便，可原地转向。有九大功能:1、开沟施肥自动回填；2、单独开沟；3、单独回填；4、旋耕；5、除草；6、风送喷药；7、树枝粉碎；8、运输平台；9、起垄功能。开沟宽度为30厘米，开沟深度为0～40厘米可调，作业速度为每小时450米～1200米；施肥深度为0～35厘米可调，旋耕装置宽为120厘米，除草120厘米；回填装置宽为150厘米；喷药装置总高度为130厘米可加高50厘米自由拆装，整机带旋耕总重830千克。车辆行走速度约为每小时2～8公里，分高低6个前进档位和2个到退档位。该机动力采用25马力江淮单缸柴油机，在丘陵地区开沟施肥作业时不用外加配重，箱内全部为齿轮传动，结实耐用。选用履带行走方式具有柔性接地、不易压损土壤、有利保墒、通过性强等优点，无论是在平原、水田、坡地丘陵地带均能发挥优势特点。开沟刀采用65锰钢自制，刀刃全部用耐磨焊条加强焊制，比普通开沟刀结实耐用至少10倍；采用蛟龙式强制排肥，下肥量可调，每米0.5～15斤，并且干的小块牛羊粪可通过施肥自动回填装置直接施肥，大块农家肥可通过单独开沟进行施肥；喷药采用风送式进口防滴漏陶瓷喷嘴和高效药泵，陶瓷片可更换，喷药幅宽5-10米，喷药高度5-8米，并且每个喷头可单独开关，大小可调方向可调，药箱容积300升即600斤水。目前该机被广泛应用于各种果树、葡萄、核桃等经济作物的田间管理作用，堪称果园全能王，可节省大量人工！目前尚无补贴，该机在新疆、甘肃、山西、陕西、广西、云南、四川、海南、广州、湖南、安徽、河南、河北、浙江、江苏、吉林等地销量较多，农户对此产品先进性、实用性和耐用性给予了很高的评价，大部分用户反映:每台机器每天光节省人工费就一千多元并且人工容易偷懒而机器不会偷懒，标准化程度高！我们实行谁销售谁售后，产品按三包凭证规定进行三包</p>");
        spproductdetailMapper.insert(spproductdetail);

    }

    @Test
    public void generateData_06() {
        int linkId = 6;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("大棚王四驱四轮农用拖拉机高效田园耕整机");
        spproduct.setMainUrl("http://img69.nongjx.com/2/20190406/636901634046046517197.jpg");
        spproduct.setXinghao("HX-XGJ-30");
        spproduct.setBrand("宏博机械");
        spproduct.setCompany("曲阜市宏博机械设备有限公司");
        spproduct.setLocation("济宁市");
        spproduct.setPrice("13300");
        spproduct.setRealMoney("13300");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(2);
        spproduct.setTypeName("农用拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20190406/636901634046046517197.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20190313/636880740483922032847_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20190313/636880740538990385217_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190313/636880819962843509534_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20190313/636880820063308153594_400_400_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("宏博机械");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);


        spproductdetail.setBrief("<p>大棚王四驱四轮农用拖拉机高效田园耕整机<br/>多功能四轮田园管理机，车身短小，马力足，是丘陵地区、果树植保、松土、施肥、收果运输等理想农机，在葡萄园区更是灵巧好用，达到了一机多用，并出口乌克兰的国家，受到国际专家的好评。<br/>信誉、创新、品质、服务是农发公司不断追求的目标，不断追求产品的高品质、高科技含量、高可靠、高服务质量是农发公司的前进动力。</p>");
        spproductdetail.setDetail("<p>形式：2*2轮式.平架.皮带传动<br/>&nbsp;<br/>牵引动力：2000N<br/>&nbsp;<br/>外阔尺寸长*宽*高：2000*960*1100MM<br/>&nbsp;<br/>拖拉机主要尺寸：轮距前轮4.00-10.后轮6.00-12<br/>&nbsp;<br/>最小地隙：【变速箱下部】190MM<br/>&nbsp;<br/>转向半径：1.85M<br/>&nbsp;<br/>Ⅰ档：2.11 Ⅱ档：3.1 Ⅲ档5.39 Ⅳ档：8.04 Ⅴ：11.81 Ⅵ：16.92<br/>&nbsp;<br/>倒Ⅰ档1.62 倒Ⅱ档6.18<br/>&nbsp;<br/>拖拉机总质量：535千克</p><p><span style=\"line-height:1.6em\">能适合旱地和水田操作，有省时、省力、作业质量高成本低等特点。本机与拖拉机配套完成耕、耙作业，具有碎土能力强、耕后地表平坦等特点。工作部件包括旋耕刀辊和按多头螺线均匀配置的若干把切土刀片，刀辊的旋转方向通常与拖拉机轮子转动的方向*。切土刀片由前向后切削土层，并将土块向后上方抛到罩壳和拖板上，使之进一步破碎。</span></p><p>&nbsp;\n" +
                " \n" +
                "&nbsp;柴油旋耕机是专业化生产的田园管理机，是集众家之长，开发研制的新型农机产品，该产品性能卓越、质量精良、操作简单、配套农机具齐全，适用范围广，成其在果园、大棚、梯田、坡地等地域作业以及在棉花、玉米、葡萄、茶园、烟草、苗木等经济作物的中耕、松土、除草等。种姜、出姜、土豆挖掘，更能发挥，独到之处，其体积小、力量大、用途广泛，具有其它类似产品无可替代的优越性。<br/>主要用途：用于农业大棚和农田旋耕、开荒、松土、培土、起垄。适用范围：主要进行大棚作业、菜地、花场、果园、水田、山坡等小地块作业。</p><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_07() {
        int linkId = 7;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("大棚王四驱四轮农用拖拉机高效田园耕整机");
        spproduct.setMainUrl("http://img66.nongjx.com/2/20151014/635804301749394135215_298_268_5.png");
        spproduct.setXinghao("HX-XGJ-30");
        spproduct.setBrand("克拉斯");
        spproduct.setCompany("经销商");
        spproduct.setLocation("哈尔滨市");
        spproduct.setPrice("11883");
        spproduct.setRealMoney("11883");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(3);
        spproduct.setTypeName("大型拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img66.nongjx.com/2/20151014/635804301749394135215_298_268_5.png"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101646334762.png!w640qm.jpg"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101651364516.png!w640qm.jpg"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101648461520.png!w640qm.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("克拉斯");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);


        spproductdetail.setBrief("<p>Axion 850德国克拉斯拖拉机基本参数：DPS发动机，气缸数：6，排气量：6788cm3，发动机额定转速：2200转/分，发动机额定功率（ECER120标准）：233马力，Z大输出功率：238马力,油箱：503升。</p>");
        spproductdetail.setDetail("<p><br/></p><p>1 &nbsp;&nbsp;GPS PILOT 自动导航转向系统</p><p>2 &nbsp;&nbsp;可接 ISOBUS 数据总线</p><p>3 &nbsp;&nbsp;多达四个的控制器，带有流量控制装 置</p><p>4 &nbsp;&nbsp;出厂时整车重量</p><p>5 &nbsp;&nbsp;机械四点悬浮驾驶室</p><p>6 &nbsp;&nbsp;在发动机转速降低时，最大行驶速度为 40 公里/小时或 50 公里/小时</p><p>7 &nbsp;&nbsp;33 千克/马力（45 千克/千瓦）以上的重 量动力比和高负载能力</p><p>8 &nbsp;&nbsp;轴距长，驾驶舒适，重量分布合理</p><p>9 &nbsp;&nbsp;HEXASHIFT 四区段变速箱</p><p>10 &nbsp;功率可达 197 到 238 马力</p><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_08() {
        int linkId = 8;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("铺方式 大型拖拉机带花生收获机械厂");
        spproduct.setMainUrl("http://img68.nongjx.com/2/20190614/636961034636914929496_480_347_5.jpg");
        spproduct.setXinghao("HX-XGJ-30");
        spproduct.setBrand("宏博机械");
        spproduct.setCompany("经销商");
        spproduct.setLocation("哈尔滨市");
        spproduct.setPrice("11883");
        spproduct.setRealMoney("11883");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(3);
        spproduct.setTypeName("大型拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img66.nongjx.com/2/20151014/635804301749394135215_298_268_5.png"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101646334762.png!w640qm.jpg"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101651364516.png!w640qm.jpg"));
        spimageList.add(new Spimage(linkId, "https://storage.nongjitong.com/UploadFiles/product/2015/2/201502101648461520.png!w640qm.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("宏博机械");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);
        spproductdetail.setBrief("<p>铺方式 大型拖拉机带花生收获机械厂单台工作效率为4-6亩/H，使花生抢收时间短，收获成本更低，适用范围广，适用于各种土壤，起垄种植的花生地可进行作业，花生无落果摆放整齐。<br/></p>");
        spproductdetail.setDetail("<section><p><strong>铺方式 大型拖拉机带花生收获机械厂</strong>单台工作效率为4-6亩/H，使花生抢收时间短，收获成本更低，适用范围广，适用于各种土壤，起垄种植的花生地可进行作业，花生无落果摆放整齐。<strong>铺方式 大型拖拉机带花生收获机械厂</strong></p><p>铺方式花生收获机 大型拖拉机带花生收获机械厂</p><p>新一代狂野花生收获机是本公司2017年新研制成功的机器，特有的夹持链设计，可以使收获过程更高效，收获效果更完善，本品具有如下特点：作业流程完整有序，在作业时完成扶秧、挖掘、碎土、抖土和花生的铺放晾晒任务，且损失率低，作业效率高，收获成本低。</p><p>铺方式花生收获机 大型拖拉机带花生收获机械厂</p><p>单台工作效率为4-6亩/H，使花生抢收时间短，收获成本更低，适用范围广，适用于各种土壤，起垄种植的花生地可进行作业，花生无落果摆放整齐。</p><p><br/></p><p>花生收获机机器参数：&nbsp;</p><p>配套动力：18马力以上<br/>传动方式：万向节<br/>输入转速：540/720r/min<br/>结构重量：430kg<br/>工作效率：4-6亩/h&nbsp;&nbsp;</p><p>尺寸：2560mm*1010mm*1050mm</p><p>本机分两种类型：一是中心输出模式，二是侧输出模式，如果您的四轮车属于单缸拖拉机 ，没有中心输出的话，那么我厂可为您提供加装分动器（费用自理），以下是实际为客户安装分动器的 图例，仅供参考，如有实际需要的话 请在订购机器时和客服详谈。</p></section>");
        spproductdetailMapper.insert(spproductdetail);
    }

    @Test
    public void generateData_09() {
        int linkId = 9;
        Spproduct spproduct = new Spproduct();
        spproduct.setId(linkId);
        spproduct.setName("山东科阳大型拖拉机带链条式开沟机厂家定制");
        spproduct.setMainUrl("http://img69.nongjx.com/2/20200121/637152116078070326406_480_347_5.jpg");
        spproduct.setXinghao("HX-XGJ-30");
        spproduct.setBrand("科阳");
        spproduct.setCompany("经销商");
        spproduct.setLocation("济宁市");
        spproduct.setPrice("15000");
        spproduct.setRealMoney("15000");
        spproduct.setMobile("0319-5985777");
        spproduct.setUpdateTime("2020-01-30 14:51:07");
        spproduct.setTypeId(3);
        spproduct.setTypeName("大型拖拉机");
        spproductMapper.insert(spproduct);
        List<Spimage> spimageList = new ArrayList<>();
        spimageList.add(new Spimage(linkId, "http://img69.nongjx.com/2/20200121/637152116078070326406_480_347_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img68.nongjx.com/2/20200121/637152116278846187732_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img71.nongjx.com/2/20200121/637152116268705992784_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20200121/637152116256849764963_400_400_5.jpg"));
        spimageList.add(new Spimage(linkId, "http://img70.nongjx.com/2/20200121/637152116242653491969_400_400_5.jpg"));
        for (Spimage spimage : spimageList) {
            spimageMapper.insert(spimage);
        }
        Spproductdetail spproductdetail = new Spproductdetail();
        spproductdetail.setBrand("科阳");
        spproductdetail.setType("全新");
        spproductdetail.setService("质保一年");
        spproductdetail.setProcessing("是");
        spproductdetail.setGas("长:2300mm,宽:1500mm,高:1450mm");
        spproductdetail.setProduceType("国产");
        spproductdetail.setLinkId(linkId);

        spproductdetail.setBrief("\u200B山东科阳大型拖拉机带链条式开沟机厂家定制\n" +
                "开沟机是一种用于土方施工中的开、挖沟机械，与挖掘机有很多相似之外，均具有入土、碎土和取土的功能。");
      spproductdetail.setDetail("<section><p><strong><strong>山东科阳大型拖拉机带链条式开沟机厂家定制</strong><strong>山东科阳大型拖拉机带链条式开沟机厂家定制</strong></strong></p><p><span style=\"font-size:14pt\">开沟机是一种用于土方施工中的开、挖沟机械，与挖掘机有很多相似之外，均具有入土、碎土和取土的功能。不同之处在于开沟机能连续作业，开沟效率高，地表破坏小，非常适合农田水利灌溉、管道铺设、果园种植收获、农用物种植收获等。即使在砖石等坚硬的地质条件下，也能开出形状整齐、规格一致的沟槽。</span></p><p><span style=\"font-size:14pt\">　　开沟机按照结构的不同，分为链条开沟机和盘式开沟机。按照用途的不同，分为农田水利开沟机、果园开沟机和工程开沟机。按照安装方式的不同，分为悬挂式开沟机和固定式开沟机。按照工作方式的不同，分为拖拉机开沟机和履带式开沟机。</span></p><p><span style=\"font-size:14pt\">开沟机由于开出沟沟形整齐，土质疏松，沟深上下统一，宽度左右匀称，非常适合农业和工程使用。在农业方面，非常适合农田水利灌溉、管道铺设、果园管理、农作物种植收获等。在工程方面，非常适合路沿石开沟、公路开沟、路岩石开沟、混凝土路面开沟、冻土开沟等。</span></p><p><span style=\"font-size:14pt\">　　生产的链式开沟机使用时风牌35马力四驱动(其他厂家都是两驱的)拖拉机,变速箱(质保三年),6*12的方钢,切削刀片有蒙钢和合头两种!!!</span></p><p><span style=\"font-size:14pt\">　　型号:配套动力(马力)开沟深度(毫米)开沟宽度(毫米)作业速度(米/小时)前进档位</span></p><p><span style=\"font-size:14pt\">　　链式开沟机主要用于自来水管道挖沟、通讯光缆挖沟、电缆挖沟等。每小时可以挖沟400米左右。该机采用回旋式开沟器，分为大中小型，小型：开沟宽度为50厘米，深度为50厘米，工作效率150—450米∕时;中型：开沟宽度为50厘米，深度为100厘米，工作效率150—500米∕时;大型：开沟宽度50厘米，深度150厘米，工作效率150—700米∕时,可挖冻土1.5米深。适用农田水利灌溉渠道，煤气管道、石油管道、自来水管道，地下电缆铺设等各项工作的开沟作业。并配套墙边、路边专用挖沟设备。</span></p><p><span style=\"font-size:14pt\">　　产品用途：广泛用于农田节水灌溉开矩形沟槽铺设自来水管道或电缆，以及种植山药等。</span></p><p><span style=\"font-size:14pt\">　　主要组成：链式动力、传动系统、行走系统、齿轮箱、传动链、开沟切削根和分土器等组成</span></p><p><span style=\"font-size:14pt\">　　主要特点：</span></p><p><span style=\"font-size:14pt\">　　经济效益显著</span></p><p><span style=\"font-size:14pt\">　　购买该机器，投资少、见效快，一台机器是人工的几十倍、小型挖掘机的几倍。</span></p><p><span style=\"font-size:14pt\">　　开沟质量好</span></p><p><span style=\"font-size:14pt\">　　开出的沟，可窄到10公分，深达2米，且沟直、壁陡，人工和挖掘机无法开出这样的沟;</span></p><p><span style=\"font-size:14pt\">　　质量好，寿命长</span></p><p><span style=\"font-size:14pt\">　　切削刀片和链条采用特殊材料与工艺制造，使用寿命长;</span></p><p><span style=\"font-size:14pt\">　　效率高</span></p><p><span style=\"font-size:14pt\">　　较人工和挖掘机有更高的作业效率(是挖掘机的3-5倍)和经济效益，特别在挖窄深沟的情况(埋管或埋电缆)下，该机的作业效果就更显突出。</span></p><p><span style=\"font-size:14pt\">　　整机结构简单，操作方便，维护容易。若配套的拖拉机没有超低速档(爬行档)，我单位可对其进行改造，加装超低速装置。</span></p><p><span style=\"font-size:14pt\">产品列表单链条开沟机双沟开沟机双链条开沟机悬挂开沟机山药打沟机路沿石开沟机大型开沟回填一体机螺旋回填机南水北调定制开沟机液压高速回填机大型开沟机开沟回填一体机中型820开沟机工程开沟机多用开沟机开沟配套填土机两用开沟机开沟机、挖沟机悬挂开沟机954开沟机产品中心当单链条开沟机。</span></p></section><p><br/></p>");
        spproductdetailMapper.insert(spproductdetail);
    }


}
