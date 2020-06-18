let layer
let form
let element

if (window.localStorage.username) {
    $(".nav-r").html(`<a href="javascript:;">${window.localStorage.username}</a> | 
    <a onclick="logout()" href="javascript:;">退出</a>`)
}

layui.config({
    dir: '/layui/'
}).use(['layer', 'form', 'element'], function () {
    layer = layui.layer
    form = layui.form
    element = layui.element
//登录
    form.on('submit(login)', function (data) {
        let $this = $(this)
        $this.text('正在登录...')
        request(BASE_URL + 'shop/spusers/login', 'POST', data.field, function (res) {
            if (res.status == false) {
                $(".error").css('opacity', '1')
                $this.text('登录')
            } else if (res.status == true) {
                if (data.field.remember) {
                    window.localStorage["password"] = data.field.password;
                }
                window.localStorage["username"] = data.field.username;
                layer.close(layer.index)
                $this.text('登录')
                layer.msg('登录成功', {
                    time: 1000
                }, function () {
                    $(".nav-r").html(`<a href="javascript:;">${data.field.username}</a> | 
                    <a onclick="logout()" href="javascript:;">退出</a>`)
                })
            }
        })
        return false
    });
//注册
    form.on('submit(reg)', function (data) {
        if (data.field.password === data.field.password2) {
            request(BASE_URL + 'shop/spusers/register', 'POST', data.field, function () {
                layer.close(layer.index)
                layer.msg('注册成功', {
                    time: 1000
                }, function () {
                    $(".nav-r").html(`<a href="javascript:;">${data.field.username}</a> | 
                <a onclick="logout()" href="javascript:;">退出</a>`)
                })
            })
            return false;
        } else {
            layer.msg("两次密码不一致", {time: 2000});
        }

    });
})

//弹出登录、注册框
function showLayer(obj) {
    layer.open({
        type: 1,
        title: false,
        area: ['380px', '370px'],
        content: $("#loginForm"),
        success: function (layero) {
            layero.css({
                'border-radius': '12px',
                'background': '#ffffff'
            })
            if (obj.text() == '登录') {
                element.tabChange('tab', 1)
            } else {
                element.tabChange('tab', 2)
            }
        }
    })
}

//隐藏错误提示
$("#loginForm").bind("click", function (e) {
    let target = $(e.target)
    if (target.closest(".error").length == 0) {
        $(".error").css('opacity', '0')
    }
})

//退出登录
function logout() {
    localStorage.clear()
    layer.msg('退出成功', {
        time: 1000
    }, function () {
        $(".nav-r").html(`<a onclick="showLayer($(this))" href="javascript:;">登录</a> |
        <a onclick="showLayer($(this))" href="javascript:;">注册</a>`)
    })
}