$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#footer").load("footer.html")
})

let id = window.location.href.split("?")[1].split("=")[1];
let typeId = window.location.href.split("?")[2].split("=")[1];

request(BASE_URL + 'shop/spconsul/detail', 'POST', {
    id: id
}, function (res) {
    $('title').text(res.data.title)
    $("#content h1").text(res.data.title)
    $("#content .time").text(res.data.publishTime)
    $("#content .source span").text(res.data.psource)
    if (res.data.mainUrl) {
        $("#content img").attr('src', res.data.mainUrl)
    }
    $("#content .essay").html(res.data.content)
    request(BASE_URL + 'shop/spconsul/list', 'POST', {
        typeId: typeId
    }, function (res) {
        $(".information ul").empty()
        for (let i in res.data) {
            $(".information ul").append(`<li>
                    <span>${i*1+1}</span>
                    <a href="sell-post.html?id=${res.data[i].id}?type=${typeId}" title="${res.data[i].title}" target="_blank">${res.data[i].title}</a>
                </li>`)
        }
    })
})