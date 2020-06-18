$(document).ready(function () {
    $("#nav").load("nav.html")
    $("#footer").load("footer.html")
})

function showContent(res) {
    $("#content").empty()
    for (let val of res.data) {
        let keys = []
        for (let key in val) {
            keys.push(key)
        }
        let str = ''
        str = `<div class="layui-card" data-id="${val[keys[0]].id}">
            <div class="layui-card-header">${val[keys[0]].username}<p>${val[keys[0]].publishTime}</p></div>
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
            request(BASE_URL + 'service/sevquestion/publishComment', 'post', {
                linkId: id,
                username: window.localStorage.username,
                content: textarea.val()
            }, function () {
                layer.msg(" 评论成功 ", {
                    time: 1000
                })
                request(BASE_URL + 'service/sevquestion/list', 'get', '', showContent)
                textarea.val('')
            })
        } else {
            $(".nav-r").children(":first").trigger("click")
        }
    })
}

request(BASE_URL + 'service/sevquestion/list', 'get', '', showContent)

layui.config({
    dir: '/layui/'
}).use(['form', 'layer'], function () {
    let form = layui.form
    let layer = layui.layer
    $("#publish").on("click", function () {
        if (window.localStorage.username) {
            layer.open({
                type: 1,
                area: ['500px', '350px'],
                title: '发布问题',
                content: $("#publishForm")
            })
        } else {
            $(".nav-r").children(":first").trigger("click")
        }
    })

    form.on('submit(sublit)', function (data) {
        request(BASE_URL + 'service/sevquestion/publishQuestion', 'post', {
            content: data.field.content,
            username: window.localStorage.username
        }, function () {
            layer.close(layer.index)
            layer.msg(" 发表成功 ", {
                time: 1000
            })
            request(BASE_URL + 'service/sevquestion/list', 'get', '', showContent)
            $("#question").val('')
        })
        return false
    })
})