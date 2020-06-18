$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#footer").load("footer.html")
})

let id = window.location.href.split("?")[1].split("=")[1];
let type = window.location.href.split("?")[2].split("=")[1];

function html(detailUrl, relateUrl) {
    request(detailUrl, 'POST', {
        id: id
    }, function (res) {
        $('title').text(res.data.title)
        $("#content h1").text(res.data.title)
        $("#content .time").text(res.data.publishTime)
        $("#content .source span").text(res.data.psource)
        if (res.data.mainUrl) {
            $("#content img").attr('src',res.data.mainUrl)
        }
        $("#content .essay").html(res.data.content)
        //资讯或技术文章
        if (type == 1 || type == 2) {
            request(relateUrl, 'POST', {
                typeId: type
            }, function (res) {
                $(".information ul").empty()
                for (let i in res.data) {
                    $(".information ul").append(`<li>
                    <span>${i*1+1}</span>
                    <a href="public-post.html?id=${res.data[i].id}?typeId=${type}" title="${res.data[i].title}" target="_blank">${res.data[i].title}</a>
                </li>`)
                }
            })
        }
        //活动
        else {
            request(relateUrl, 'get', '', function (res) {
                $(".information ul").empty()
                for (let i in res.data) {
                    $(".information ul").append(`<li>
                    <span>${i*1+1}</span>
                    <a href="public-post.html?id=${res.data[i].id}?type=activity" title="${res.data[i].title}" target="_blank">${res.data[i].title}</a>
                </li>`)
                }
            })
        }
    })
}

if (type == 1 || type == 2) {
    html(BASE_URL + 'service/sevconsul/detail', BASE_URL + 'service/sevconsul/list')
} else if (type == 'activity') {
    html(BASE_URL + 'service/sevactivity/detail', BASE_URL + 'service/sevactivity/list')
}