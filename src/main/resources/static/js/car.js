$(document).ready(function () {
    getUserName();
    $('#btn-order').click(function () {
        postOrder();
    });
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
                $('#username').val(data);
            }
            return data;
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function postOrder() {
    if ($('#username').val() !== "") {
        if ($('#btn-order').hasClass('cancel')) {
            $.ajax({
                type: "DELETE",
                url: "/rest/orders/" + window.location.href.match(/([^\/]*)\/*$/)[1],
                success: function (data) {
                    if (data !== "false") {
                        $('#btn-order').text($('#order').val()).removeClass("cancel");
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        } else {
            $.ajax({
                type: "POST",
                url: "/rest/orders/" + window.location.href.match(/([^\/]*)\/*$/)[1],
                success: function (data) {
                    if (data !== "false") {
                        $('#btn-order').text($('#cancel').val()).addClass("cancel");
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        }
    } else {
        window.location.href = "/signUp";
    }
}
