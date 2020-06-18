$("#search").on("click",function(){
    let keyword = $("#keyword").val()
    if(keyword){
        window.open("sell.html?keyword="+keyword)
    }
})

$("#keyword").on('keypress',function(e){
    if(e.keyCode == 13){
        $("#search").trigger('click')
    }
});

