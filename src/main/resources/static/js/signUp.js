$(document).ready(function () {
    $("#btnSignUp").click(function (event) {
        event.preventDefault();
        registerUser();
    });
});

function registerUser() {
    var user = {};
    user["username"] = $("#new-username").val();
    user["password"] = $("#new-password").val();
    user["firstname"] = $("#firstname").val();
    user["lastname"] = $("#lastname").val();
    user["phone"] = $("#telephone").val();

    $("#btnSignUp").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/users",
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data !== null) {
                if (data.id !== -1) {
                    window.location.href = '/';
                }
            } else {
                $('.error').css('display', 'block');
            }

            $("#btnSignUp").prop("disabled", false);
        },
        error: function (e) {
            $('.error').css('display', 'block');
            $("#btnSignUp").prop("disabled", false);
        }
    });
}