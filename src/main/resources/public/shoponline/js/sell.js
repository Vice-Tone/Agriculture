$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#header").load("search.html")
    $("#footer").load("footer.html")
})

function html(res) {
    if (res.count == 0) {
        $("#productList").append(`<div class="error"><i class="layui-icon layui-icon-face-surprised"></i>很抱歉，没有找到相关的产品信息</div>`)
    } else {
        $("#productList").empty()
        for (let val of res.data) {
            $("#productList").append(`<li>
                <a class="img-wrap" href="good-detail.html?id=${val.id}" title="${val.name}">
                    <img src="${val.mainUrl}" width="200" height="200">
                </a><br>
                <a class="name" href="good-detail.html?id=${val.id}" title="${val.name}">${val.name}</a>
                <p>${val.company}</p>
                <div class="price">
                    <b>${val.price === "面议" ? val.price : '￥'+val.price}</b>
                    <span><i class="layui-icon layui-icon-location"></i>${val.location}</span>
                </div>
            </li>`)
        }
    }

    $('#num').text(res.count)
}

//加载产品
let parameter = window.location.href.split("?");
if (parameter[1]) {
    let keyword = decodeURI(parameter[1].split("=")[1])
    if (parameter[1].split("=")[0] == 'keyword') {
        request(BASE_URL + 'shop/spproduct/getByName', 'POST', {
            value: keyword
        }, html)
        $('#keyword').text('"' + keyword + '"')
    } else if (parameter[1].split("=")[0] == 'id') {
        request(BASE_URL + 'shop/spproduct/getByTypeId', 'POST', {
            typeId: keyword
        }, html)
        $('#keyword').text('"' + decodeURI(parameter[2].split("=")[1]) + '"')
    }
} else {
    request(BASE_URL + 'shop/spproduct/list', 'GET', '', html)
}

//加载类别
request(BASE_URL + 'shop/sptype/list', 'GET', '', function (res) {
    $("#categoryList").empty()
    for (let val of res.data) {
        $("#categoryList").append(`<li>
        <a href="sell.html?id=${val.id}?name=${val.typeName}" target="_blank">${val.typeName}</a>
    </li>`)
    }
})

//资讯列表
request(BASE_URL + 'shop/spconsul/list', 'POST', {
    typeId: 1
}, function (res) {
    $("#infoList").empty()
    for (let val of res.data) {
        $("#infoList").append(`<li>
        <a href="sell-post.html?id=${val.id}?typeId=1" title="${val.title}" target="_blank">${val.title}</a>
    </li>`)
    }
})

//技术文章
request(BASE_URL + 'shop/spconsul/list', 'POST', {
    typeId: 2
}, function (res) {
    $("#techList").empty()
    for (let val of res.data) {
        $("#techList").append(`<li>
        <a href="sell-post.html?id=${val.id}?typeId=2" title="${val.title}" target="_blank">${val.title}</a>
    </li>`)
    }
})