$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#header").load("search.html")
    $("#footer").load("footer.html")
})

layui.use('carousel', function () {
    $.ajax({
        url: "/service/sevactivity/getAllCoursel",
        dataType: "json",
        async: false,
        success: function (ret) {
            for (var k = 0; k < ret.data.length; k++) {
                $("#carouselItem").append(`<div><img src="${ret.data[k].image}" width="1200" alt="" title=""></div>`);
            }
        }
    })
    let carousel = layui.carousel;
    carousel.render({
        elem: '#carousel',
        width: '100%',
        height: '360px',
        arrow: 'none'
    });
});

//活动列表
request(BASE_URL + 'service/sevactivity/list', 'get', '', function (res) {
    $(".activity ul").empty()
    for (let val of res.data) {
        $(".activity ul").append(`<li>
        <a href="public-post.html?id=${val.id}?type=activity" title="${val.title}" target="_blank"><img src="${val.mainUrl}" title="${val.title}"></a>
        <h3><a href="public-post.html?id=${val.id}?type=activity" title="${val.title}" target="_blank">${val.title}</a></h3>
        <p class="essay">${val.content.replace(/<.*?>/ig, "")}</p>
        <span><div class="date"><i class="layui-icon layui-icon-time"></i> ${val.publishTime}</div>来源：${val.psource}</span>
    </li>`)
    }
})

//公告信息
request(BASE_URL + 'service/sevannounce/list', 'get', '', function (res) {
    $(".announcement ul").empty()
    for (let i in res.data) {
        $(".announcement ul").append(`<li>
        <span>${i * 1 + 1}</span>
        <a href="offers.html?type=announcement" title="${res.data[i].sevannounce.title}" target="_blank">${res.data[i].sevannounce.title}</a>
    </li>`)
    }
})

//招聘信息
request(BASE_URL + 'service/sevenroll/list', 'get', '', function (res) {
    $(".offers ul").empty()
    for (let i in res.data) {
        $(".offers ul").append(`<li>
        <span>${i * 1 + 1}</span>
        <a href="offers.html?type=offers" title="${res.data[i].sevenroll.title}" target="_blank">${res.data[i].sevenroll.title}</a>
    </li>`)
    }
})

//资讯列表
request(BASE_URL + 'service/sevconsul/list', 'POST', {
    typeId: 1
}, function (res) {
    $("#infoList").empty()
    for (let val of res.data) {
        $("#infoList").append(`<li>
        <a href="public-post.html?id=${val.id}?typeId=1" title="${val.title}" target="_blank">${val.title}</a>
    </li>`)
    }
})

//技术文章
request(BASE_URL + 'service/sevconsul/list', 'POST', {
    typeId: 2
}, function (res) {
    $("#techList").empty()
    for (let val of res.data) {
        $("#techList").append(`<li>
        <a href="public-post.html?id=${val.id}?typeId=2" title="${val.title}" target="_blank">${val.title}</a>
    </li>`)
    }
})