$(document).ready(function () {
    search();
    $('#cancel').click(function () { cancel(); });
});

function search() {
    $.ajax({
        type: "GET",
        url: "/rest/dealers",
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                showDealers(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showDealers(dealers) {
    for (var i = 0; i < dealers.length; i++) {
        $('#result').append(
        '<tr class="id' + dealers[i].id + '">' +
            '<td class="id">' + (i+1) + '</td>' +
            '<td>' + dealers[i].username + '</td>' +
            '<td>' + dealers[i].firstname + '</td>' +
            '<td>' + dealers[i].lastname + '</td>' +
            '<td>+' + dealers[i].phone + '</td>' +
            '<td>' + dealers[i].email + '</td>' +
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
    var dealers = $('#result').find('input:checkbox:checked');
    for(var i = 0; i < dealers.length; i++) {
        $.ajax({
            type: "DELETE",
            url: "/rest/dealers/" + $(dealers[i]).parent().parent().parent().find(".id").text(),
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