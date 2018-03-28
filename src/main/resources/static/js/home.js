$(document).ready(function () {
    getUserName()
});

function getUserName() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/users/username",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data) {
                $('#username').text(data).removeAttr('href');
            }
        }
    });
}