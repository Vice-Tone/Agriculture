$(document).ready(function(){
    $("#nav").load("nav.html")
    $("#header").load("search.html")
    $("#footer").load("footer.html")
})

let id = window.location.href.split("?")[1].split("=")[1];

layui.use(['element','layer'], function(){
    let layer = layui.layer;

    $("#realMoney").click(function () {
       $.ajax({
           url:"/shop/sporders/add",
           data:{"id":id,"username":"user"},
           dataType:"json",
           success:function (ret) {
               if (ret.code===0){
                   alert("下单成功啦");
               } else {
                   alert("下单失败");
               }
           }
       })

    });

      request(BASE_URL+'shop/spproduct/getById', 'POST', {id: id}, function (res) {
        $('#name').text(res.data.name)
        $('#mainImg').attr('src',res.data.mainUrl)
        $('#price').text(res.data.price)
        $('#xinghao').text(res.data.xinghao)
        $('#brand').text(res.data.brand)
        $('#location').text(res.data.location)
        $('#company').text(res.data.company)
        $('#realMoney').on('click', function(){
            let that = this;
            layer.tips(res.data.realMoney, that, {
                tips: [4, '#0288D1']
              }); 
        });
    
        $('#contact').on('click', function(){
            let that = this;
            layer.tips(res.data.mobile, that, {
                tips: [2, '#0288D1']
              });
        });
    })
});

//加载类别
request(BASE_URL+'shop/sptype/list', 'GET', '', function (res) {
    $("#categoryList").empty()
    for(let val of res.data){
        $("#categoryList").append(`<li>
        <a href='javascript:void(0)'>${val.typeName}</a>
    </li>`)
    }
})

request(BASE_URL+'shop/spproductdetail/detail', 'POST', {id: id}, function (res) {
    $('.brand').text(res.data.brand)
    $('#type').text(res.data.type)
    $('#service').text(res.data.service)
    $('#produceType').text(res.data.produceType)
    $('#gas').text(res.data.gas)
    $('#processing').text(res.data.processing)
    $(".text").append(res.data.brief)
    $(".des").html(res.data.detail)
});


request(BASE_URL+'shop/spimage/getImages', 'POST', {id: id}, function (res) {
    $(".img-box").empty()
    for(let val of res.data){
        $(".img-box").append(`<img src="${val.imageUrl}" width="750"><br>`)
    }
})