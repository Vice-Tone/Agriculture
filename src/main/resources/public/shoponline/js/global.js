let BASE_URL = 'http://localhost:9010/'

function request(url, type, data, callback){
    $.ajax({
        url: url,
        type: type,
        data: data,
        success: callback
    })
}