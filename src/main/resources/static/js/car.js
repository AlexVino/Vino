$(document).ready(function () {
    $('#btn-order').click(function () {
        postOrder();
    });
    $('#btn-edit').click(function () {
        window.location.href = "/cars/" + window.location.href.match(/([^\/]*)\/*$/)[1] + "/edit";
    });
    $('#btn-delete').click(function () {
        $.ajax({
            type: "DELETE",
            url: "/rest/cars/" + window.location.href.match(/([^\/]*)\/*$/)[1],
            success: function (data) {
                if (data !== "false") {
                    window.location.href = "/";
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
});

function postOrder() {
    if ($('#username').val() !== "") {
        if ($('#btn-order').hasClass('cancel')) {
            $.ajax({
                type: "DELETE",
                url: "/rest/orders/cars/" + window.location.href.match(/([^\/]*)\/*$/)[1],
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
