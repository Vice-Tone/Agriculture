package com.ruoyi.project.agricultrue.sev;


import com.ruoyi.AgricultrueApplication;
import com.ruoyi.project.agricultrue.sev.mapper.SevactivityMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevactivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class SevActivityTest {

    @Autowired
    private SevactivityMapper sevactivityMapper;


    @Test
    public void sevactivity_01() {
        Sevactivity sevactivity = new Sevactivity();
        sevactivity.setMainUrl("http://img68.nongjx.com/3/20200313/637197258310226666262.jpg");
        sevactivity.setPsource("农机网整理发布");
        sevactivity.setPublishTime("2020-03-13 19:57:03");
        sevactivity.setContent("<p>【农机网 一周看点】<br/>\n" +
                " <br/>　　2020年出台50项农村人居环境整治举措<br/>\n" +
                " <br/>　　近日，中央农村工作领导小组办公室、农业农村部印发了《2020年农村人居环境整治工作要点》(简称《要点》)，制定11个方面50项举措，涉及21个部门，对各地区各部门结合实际认真贯彻落实、确保按时保质完成农村人居环境整治三年行动方案目标任务提出了要求。<br/>\n" +
                " <br/>　　《要点》确定的主要任务有：扎实推进农村人居环境整治面上工作，抓好农村人居环境整治大检查问题整改，举办全国农村人居环境整治工作培训班，研究谋划新一轮农村人居环境整治行动方案。整治提升村容村貌，以“干干净净迎小康”为主题深入开展村庄清洁行动……<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　农业农村部预计投入春季生产农机具超2000万台套<br/>\n" +
                " <br/>　　当前，春季农业生产正由南向北陆续展开，农业农村部立足农村疫情防控和农业生产“两手抓”“两不误”，细化实化农业机械化发展措施，为确保今年春耕备耕的进度和质量提供机械化支撑。从新调度情况看，全国各地投入春季农业生产的农机具总量预计超过2000万台套，满足春耕备耕需要是有保障的。<br/>\n" +
                " <br/>　　据介绍，疫情期间，农业农村部主要从大力推行线上服务、加快实施农机购置补贴、保障农机转运通畅三项农业机械化发展措施保障春耕生产。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　开展2020年全国“农机3•15”消费者权益日活动<br/>\n" +
                " <br/>　　在国际消费者权益日到来之际，为贯彻落实《中央应对新型冠状病毒感染肺炎疫情工作领导小组关于印发当前春耕生产工作指南的通知》精神，保障春耕生产，维护农机用户和生产、销售企业的合法权益，根据农业农村部农业机械化管理司的工作部署，农业农村部农业机械试验鉴定总站、农业农村部农业机械化技术开发推广总站和中国农业机械化协会联合组织开展2020年全国“农机3·15”消费者权益日活动。<br/>\n" +
                " <br/>　　活动主题为“聚力提质量，护农保春耕”，以“线上”方式开展，主要利用农业农村(农业机械化)等行业进行宣传。3月15日起，中国农业机械化信息网、农业农村部农机推广与监理网和中国农业机械化协会网站同时上线“农机3·15”主题专栏，并利用《中国农机化》《中国农机化协会》微信公众号等媒体同步宣传。<br/>\n" +
                " <br/>　　主要内容包括：利用网站专栏宣传农机质量监督政策法规，普及购机、用机、修机和识假辨假知识，提供质量投诉指南；征集、展示农机企业质量服务承诺(图文或视频)；公布全国农机质量投诉监督机构信息，提供远程农机质量投诉咨询、受理服务。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　农业农村部部署启动农资打假“春雷”行动<br/>\n" +
                " <br/>　　3月10日，农业农村部组织召开2020年春耕备耕农资打假工作视频会议，抓实抓细春季农资打假工作，迅速启动“春雷”行动，为春耕备耕保驾护航。<br/>\n" +
                " <br/>　　农资是农业生产的基础，要坚持问题导向，积极主动作为，迅速启动春耕备耕农资打假“春雷”行动。重点是抓好隐患排查、监督抽查、执法办案、农资产品审批准入、农民识假辨假宣传引导、放心农资下乡进村活动等任务，查办一批大案要案、端掉一批黑窝点、严惩一批违法犯罪分子、公布一批典型案件，给假劣农资来一次“大扫除”，给制售者来一个“连窝端”。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　甘肃省下达4500万省级财政农机购置补贴项目资金<br/>\n" +
                " <br/>　　近日，甘肃省农业农村厅下发《关于下达2020年省级农机购置补贴项目任务清单及实施方案的通知》，对相关工作做了部署安排。<br/>\n" +
                " <br/>　　《通知》明确， \n" +
                "2020年省级财政农机购置补贴项目下达资金4500万元，主要开展一乡一农机合作社建设试点、农机合作社装备提升行动试点、特色产业农机配套抓点示范、农机购置补贴机具核验及政策宣传培训等4个方面工作。各市县要按照分项方案要求，明确责任分工，细化实施方案，签订计划任务书，落实各项措施，强化过程监管，确保项目顺利实施和资金安全高效使用。</p>");
        sevactivity.setTitle("【一周看点】3.15前夕，保障农业机械供应各项措施稳步");
        sevactivityMapper.insert(sevactivity);
    }

    @Test
    public void sevactivity_02() {
        Sevactivity sevactivity = new Sevactivity();
        sevactivity.setMainUrl("http://img71.nongjx.com/3/20200313/637197203425058666982.jpg");
        sevactivity.setPsource("农机网整理发布");
        sevactivity.setPublishTime("2020-03-13 19:57:03");
        sevactivity.setContent("<p>【农机网 一周看点】<br/>\n" +
                " <br/>　　2020年出台50项农村人居环境整治举措<br/>\n" +
                " <br/>　　近日，中央农村工作领导小组办公室、农业农村部印发了《2020年农村人居环境整治工作要点》(简称《要点》)，制定11个方面50项举措，涉及21个部门，对各地区各部门结合实际认真贯彻落实、确保按时保质完成农村人居环境整治三年行动方案目标任务提出了要求。<br/>\n" +
                " <br/>　　《要点》确定的主要任务有：扎实推进农村人居环境整治面上工作，抓好农村人居环境整治大检查问题整改，举办全国农村人居环境整治工作培训班，研究谋划新一轮农村人居环境整治行动方案。整治提升村容村貌，以“干干净净迎小康”为主题深入开展村庄清洁行动……<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　农业农村部预计投入春季生产农机具超2000万台套<br/>\n" +
                " <br/>　　当前，春季农业生产正由南向北陆续展开，农业农村部立足农村疫情防控和农业生产“两手抓”“两不误”，细化实化农业机械化发展措施，为确保今年春耕备耕的进度和质量提供机械化支撑。从新调度情况看，全国各地投入春季农业生产的农机具总量预计超过2000万台套，满足春耕备耕需要是有保障的。<br/>\n" +
                " <br/>　　据介绍，疫情期间，农业农村部主要从大力推行线上服务、加快实施农机购置补贴、保障农机转运通畅三项农业机械化发展措施保障春耕生产。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　开展2020年全国“农机3•15”消费者权益日活动<br/>\n" +
                " <br/>　　在国际消费者权益日到来之际，为贯彻落实《中央应对新型冠状病毒感染肺炎疫情工作领导小组关于印发当前春耕生产工作指南的通知》精神，保障春耕生产，维护农机用户和生产、销售企业的合法权益，根据农业农村部农业机械化管理司的工作部署，农业农村部农业机械试验鉴定总站、农业农村部农业机械化技术开发推广总站和中国农业机械化协会联合组织开展2020年全国“农机3·15”消费者权益日活动。<br/>\n" +
                " <br/>　　活动主题为“聚力提质量，护农保春耕”，以“线上”方式开展，主要利用农业农村(农业机械化)等行业进行宣传。3月15日起，中国农业机械化信息网、农业农村部农机推广与监理网和中国农业机械化协会网站同时上线“农机3·15”主题专栏，并利用《中国农机化》《中国农机化协会》微信公众号等媒体同步宣传。<br/>\n" +
                " <br/>　　主要内容包括：利用网站专栏宣传农机质量监督政策法规，普及购机、用机、修机和识假辨假知识，提供质量投诉指南；征集、展示农机企业质量服务承诺(图文或视频)；公布全国农机质量投诉监督机构信息，提供远程农机质量投诉咨询、受理服务。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　农业农村部部署启动农资打假“春雷”行动<br/>\n" +
                " <br/>　　3月10日，农业农村部组织召开2020年春耕备耕农资打假工作视频会议，抓实抓细春季农资打假工作，迅速启动“春雷”行动，为春耕备耕保驾护航。<br/>\n" +
                " <br/>　　农资是农业生产的基础，要坚持问题导向，积极主动作为，迅速启动春耕备耕农资打假“春雷”行动。重点是抓好隐患排查、监督抽查、执法办案、农资产品审批准入、农民识假辨假宣传引导、放心农资下乡进村活动等任务，查办一批大案要案、端掉一批黑窝点、严惩一批违法犯罪分子、公布一批典型案件，给假劣农资来一次“大扫除”，给制售者来一个“连窝端”。<br/>\n" +
                " <br/>　　查看详情 <br/>\n" +
                " <br/>　　甘肃省下达4500万省级财政农机购置补贴项目资金<br/>\n" +
                " <br/>　　近日，甘肃省农业农村厅下发《关于下达2020年省级农机购置补贴项目任务清单及实施方案的通知》，对相关工作做了部署安排。<br/>\n" +
                " <br/>　　《通知》明确， \n" +
                "2020年省级财政农机购置补贴项目下达资金4500万元，主要开展一乡一农机合作社建设试点、农机合作社装备提升行动试点、特色产业农机配套抓点示范、农机购置补贴机具核验及政策宣传培训等4个方面工作。各市县要按照分项方案要求，明确责任分工，细化实施方案，签订计划任务书，落实各项措施，强化过程监管，确保项目顺利实施和资金安全高效使用。</p>");
        sevactivity.setTitle("国际消费者权益日到来之际，各地积极响应开展农机3.15");
        sevactivityMapper.insert(sevactivity);
    }

    @Test
    public void sevactivity_03() {
        Sevactivity sevactivity = new Sevactivity();
        sevactivity.setMainUrl("http://img71.nongjx.com/3/20200313/637197125436758666766.jpg");
        sevactivity.setPsource("农机网整理发布");
        sevactivity.setPublishTime("2020-03-13 19:57:03");
        sevactivity.setContent("<p>【农机网 \n" +
                "编辑视角】当前正值疫情防控和春耕备耕的关键时期，为统筹抓好新冠肺炎疫情防控和春耕生产工作，抓好春季农业生产，实现“藏粮于地、藏粮于技”， \n" +
                "我国多地都出台了关于春耕生产工作的相关政策。其中，保护性耕作这一可持续农业技术愈加受到重视，大有蔚然成风的趋势。<br/>\n" +
                " <br/>　　什么是保护性耕作？<br/>\n" +
                " <br/>　　什么是保护性耕作？顾名思义，保护性为重点，那么也就意味着我们在农业机械活动过程中，要注意预防河流泛滥、 沙尘暴猖獗、土壤退化、水土流失等问题，否则就是“破坏性”耕作而非“保护性”耕作了。<br/>\n" +
                " <br/>　　保护性耕作以机械化为基础，集成秸秆还田覆盖、少免耕精量播种、高效植保和深松等技术，通过少耕、免耕、地表微地形改造技术及地表覆盖、合理种植等综合配套措施，从而减少农田土壤侵蚀，保护农田生态环境，并获得生态效益、经济效益及社会效益协调发展，在蓄水保墒、培肥地力、节本增效、减少农田土壤侵蚀和保护生态环境等方面具有显著成效，可以实现旱作地区农业生产目标和环境保护目标“双赢”，绿色、高效，是对传统耕作的技术革命。</p><p>其涵盖了秸秆残茬处理、免(少)耕播种、机械化深松、杂草及病虫害防治、土壤改良等五个方面，核心技术包括少耕、免耕、缓坡地等高耕作、沟垄耕作、残茬覆盖耕作、秸秆覆盖等农田土壤表面耕作技术及其配套的专用机具等，配套技术包括绿色覆盖种植、作物轮作、带状种植、多作种植、合理密植、沙化草地恢复以及农田防护林建设等。<br/>\n" +
                " <br/>　　主要技术内容有什么？<br/>\n" +
                " <br/>　　少耕、免耕技术：免耕就是除播种之外不进行任何耕作，用免耕播种机一次完成破茬开沟、施肥、播种、覆土和镇压作业，简化工序，减少机械进地次数，降低成本。少耕包括深松与表土耕作，深松即疏松深层土壤，基本上不破坏土壤结构和地面植被，可提高天然降雨入渗率，增加土壤含水量。<br/>\n" +
                " <br/>　　秸秆覆盖技术：主要分为秸秆粉碎还田覆盖、整秆还田覆盖和留茬覆盖三种方式。将作物秸秆、残茬覆盖地表，在培肥地力的基础上，用秸秆盖土，可以实现根茬固土、保护土壤、减少风蚀水蚀和水分无效蒸发、提高天然降雨利用率的作用。<br/>\n" +
                " <br/>　　合理化用水、药和施肥技术：这也是保护性耕作技术的重要环节之一，包括节水灌溉技术、自控精确喷药技术以及按需施肥及液态施肥技术。其目的是使农药和化肥用量实现更大范围的节省，以及实现有效保护土壤环境。<br/>\n" +
                " <br/>　　为什么要推行保护性耕作？<br/>\n" +
                " <br/>　　东北黑土地保护性耕作被提升到国家农业战略层面，黑龙江省将保护性耕作重点放在解决机械化秸秆还田耕种上，在全省快速形成保护性耕作技术推广势头。早在2004年，黑龙江省就开展了保护性耕作技术试验示范，围绕秸秆还田提高地力这一核心，并探索出了适合当地的保护性耕作技术模式。而《东北黑土地保护性耕作国家行动计划(2020—2025年)》，提出用5-6年，在东北适宜地区实施高质量保护性耕作，找到一条运用机械化手段解决东北黑土地保护问题的有效路径，将保护性耕作纳入到顶层设计制定中。<br/>\n" +
                " <br/>　　2019年辽宁沈阳举办的“秸秆综合利用经验交流活动”消息，截至12月，全国秸秆综合利用率达到85.45%，有10个省利用率超过90%，有9个省利用率超过85%，近50%的县区利用率超过90%，秸秆综合利用总体呈现出稳中有进、稳中向好的态势。<br/>\n" +
                " <br/>　　2019年，黑龙江省财政投资43亿元加大秸秆综合利用率；甘肃省2020年中央财政提前下达部分农业资源及生态保护补助资金主要用于支持农作物秸秆综合化利用2820万元；江苏省也提出要适度开展稻秸秆还田作业补助，鼓励开展犁耕深翻作业补助……不仅如此，对购置秸秆还田、保护性耕作等农机具，我国多地也实行了地方财政资金累加补贴政策，市场免耕作业机械保有量逐渐增加，各项政策利好为保护性耕作发展提供了生长土壤。</p>");
        sevactivity.setTitle("春耕备耕热潮到来，保护性耕作这一可持续农业技术蔚然");
        sevactivityMapper.insert(sevactivity);
    }

    @Test
    public void sevactivity_04() {
        Sevactivity sevactivity = new Sevactivity();
        sevactivity.setMainUrl("http://img68.nongjx.com/9/20200213/637172105132839466872.jpg");
        sevactivity.setPsource("农机网整理发布");
        sevactivity.setPublishTime("2020-03-13 19:57:03");
        sevactivity.setContent("<p>【农机网 编辑视角】 2月5日，2020年中央一号文件正式发布，文件指出，今年是全面建成小康社会目标实现之年，是全面打赢脱贫攻坚战的收官之年。“三农”工作再一次被摆在了重中之重。<br/>\n" +
                " <br/>　　对此，2月12日，农业农村部发布《农业农村部关于落实党中央、国务院2020年农业农村重点工作部署的实施意见》(以下简称《实施意见》)，《实施意见》从多方面对今年农业农村工作进行了部署。笔者从中提炼了与农机行业紧密相关的几点，相应的几个农机领域在2020年或将迎来更大发展：<br/>\n" +
                " <br/>　　一、做大做强农产品加工业<br/>\n" +
                " <br/>　　《实施意见》指出，引导龙头企业建设农产品加工技术集成基地和精深加工示范基地，推动加工产能向农产品主产区和重要物流节点布局。支持各地聚焦优势特色主导品种，打造各具特色的农业全产业链，培育一批产值超百亿元的区域优势特色产业集群。认定第四批中国特色农产品优势区、第十批“一村一品”示范村镇。加强马铃薯主食产业推进工作。建设休闲农业重点县，推介一批乡村休闲旅游精品景点线路。<br/>\n" +
                " <br/>　　解读：农产品加工业是农业现代化的支撑力量和国民经济的重要产业，对促进农业提质增效、农民就业增收和农村一二三产业融合发展，对提高人民群众生活质量和健康水平、保持经济平稳较快增长有着十分重要的作用。<br/>\n" +
                " <br/>　　做大做强农产品加工业对相应农产品加工机械发展提出了更高要求。此前，虽然农产品初加工机械已被纳入全国农机购置补贴范围，但总体来说，此类机械还处于农机中的小众领域。2020年，农产品加工机械或将迎来更大发展。<br/>\n" +
                " <br/>　　二、大力推进畜禽粪污资源化利用<br/>\n" +
                " <br/>　　《实施意见》指出，全面完成大型规模养殖场粪污治理设施建设，对规模养殖场粪污处理设施配套率开展评估，确保达到95%以上。扩大畜禽粪污资源化利用整县推进范围，将具备条件的非畜牧大县逐步纳入。健全畜禽粪污处理利用标准体系，鼓励发展收贮运社会化服务组织，探索粪肥运输、施用引导激励政策。<br/>\n" +
                " <br/>　　解读：畜禽粪污资源化利用虽然是近几年农机行业比较火热的词，但相应机械发展不够完善、产业链不够齐全也是目前较为突出的问题。此类机械发展完善起来不只是对农机行业全面发展的补充，更是对农村环境治理有着重要贡献。</p>");
        sevactivity.setTitle("2020年，这几个农机领域将持续“火热”");
        sevactivityMapper.insert(sevactivity);
    }



}
