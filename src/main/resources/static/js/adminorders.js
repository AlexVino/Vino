$(document).ready(function () {
    getUserName();
    search();
    $('#cancel').click(function () { cancel(); });
});

function getUserName() {
    $.ajax({
        type: "GET",
        url: "/rest/users/username",
        cache: false,
        timeout: 600000,
        dataType: "text",
        success: function (data) {
            if (data !== "false") {
                $('#btn-sign').text(data).attr('href', "/logout");
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function search() {
    $.ajax({
        type: "GET",
        url: "/rest/orders",
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                showOrders(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showOrders(orders) {
    for (var i = 0; i < orders.length; i++) {
        $('#result').append(
        '<tr class="id' + orders[i].id + '">' +
            '<td class="id">' + orders[i].id + '</td>' +
            '<td>' + orders[i].firstname + '</td>' +
            '<td>' + orders[i].lastname + '</td>' +
            '<td>+' + orders[i].phone + '</td>' +
            '<td>' + orders[i].fullModel + '</td>' +
            '<td>$' + orders[i].price + '</td>' +
            '<td>' +
            '<div class="onoffswitch">' +
            '<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch' + i +'">' +
            '<label class="onoffswitch-label" for="myonoffswitch' + i +'"></label>' +
            '</div>' +
            '</td>' +
            '</tr>');
    }
}

function cancel() {
    var orders = $('#result').find('input:checkbox:checked');
    for(var i = 0; i < orders.length; i++) {
        $.ajax({
            type: "DELETE",
            url: "/rest/orders/" + $(orders[i]).parent().parent().parent().find(".id").text(),
            cache: false,
            timeout: 600000,
            dataType: "text",
            success: function (data) {
                if (data !== "false") {
                    $(".id" + this.url.match(/([^\/]*)\/*$/)[1]).remove();
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    }
}