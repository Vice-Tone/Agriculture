$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#footer").load("footer.html")
})

let type = window.location.href.split("?")[1].split("=")[1]

function showContent(listUrl, commentUrl) {
    request(listUrl, 'get', '', function (res) {
        $("#content").empty()
        for (let val of res.data) {
            let keys = []
            for (let key in val) {
                keys.push(key)
            }
            let str = ''
            str = `<div class="layui-card" data-id="${val[keys[0]].id}">
                <div class="layui-card-header">${val[keys[0]].title}<p>${val[keys[0]].publishTime}</p></div>
                <div class="layui-card-body">
                    <p>${val[keys[0]].content}</p>
                    <hr style="height:1px;background-color: #e6e6e6;" />
                    <div class="comments-list">`
            if (val[keys[1]].length != 0) {
                for (let comment of val[keys[1]]) {
                    str = str + `<div class="comment-item">
                                <div class="comment-wrap">
                                    <p>${comment.username}: ${comment.content}
                                    <span>${comment.publishTime}</span></p>
                                </div>
                            </div>`
                }
            }
            str = str + `</div>
                        </div>
                        <div class="comments-poster">
                            <textarea placeholder="评论" class="layui-textarea"></textarea>
                            <button type="button" class="layui-btn blue comment">发表</button>
                        </div>
                    </div>`;
            $("#content").append(str);
        }
        $(".comment").on("click", function () {
            if (window.localStorage.username) {
                let id = $(this).parent().parent().data("id");
                let textarea = $(this).prev();
                request(commentUrl, 'post', {
                    linkId: id,
                    username: window.localStorage.username,
                    content: textarea.val()
                }, function () {
                    layer.msg(" 评论成功 ", {
                        time: 1000
                    })
                    showContent(listUrl, commentUrl)
                    textarea.val('')
                })
            } else {
                $(".nav-r").children(":first").trigger("click")
            }
        })
    })
}

if (type == 'announcement') {
    showContent(BASE_URL + 'service/sevannounce/list', BASE_URL + 'service/sevannounce/publishComment')
    $('title').text('活动公告')
} else if (type == 'offers') {
    showContent(BASE_URL + 'service/sevenroll/list', BASE_URL + 'service/sevenroll/publishComment')
    $('title').text('招聘信息')
}