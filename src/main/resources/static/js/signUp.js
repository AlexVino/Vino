$(document).ready(function () {
    $("#btnSignUp").click(function () {
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
        success: function (data) {
            if (data !== null) {
                throwMessage("You can sign in.");
            }
            $("#btnSignUp").prop("disabled", false);
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
            $("#btnSignUp").prop("disabled", false);
        }
    });
}