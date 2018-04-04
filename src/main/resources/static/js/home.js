$(document).ready(function () {
    getUserName();
    $('.b-search').click(function () { search(); });
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
                $('.b-sign').text(data).attr('href', "/logout");
            }
        }
    });
}

function search() {
    $.ajax({
        type: "GET",
        url: "/rest/cars?order=carId ASC",
        cache: false,
        timeout: 600000,
        dataType: "text",
        success: function (data) {
            if (data !== "false") {
                console.log(JSON.stringify(data));
            }
        }
    });
}