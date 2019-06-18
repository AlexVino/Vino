$(document).ready(function () {
    $("#btnSignUp").click(function () {
        registerUser();
    });
    var result = getUrlVar();

    if (result['error'] === "true") {
        throwMessage($('#error-login-or-password').val());
    }
});

function getUrlVar(){
    var urlVar = window.location.search;
    var valueAndKey = [];
    var resultArray = [];
    arrayVar = (urlVar.substr(1)).split('&');
    if(arrayVar[0] === "") return [];
    for (i = 0; i < arrayVar.length; i ++) {
        valueAndKey = arrayVar[i].split('=');
        resultArray[valueAndKey[0]] = valueAndKey[1];
    }
    return resultArray;
}

function registerUser() {
    var user = {};
    user["username"] = $("#new-username").val();
    user["password"] = $("#new-password").val();
    user["firstname"] = $("#firstname").val();
    user["lastname"] = $("#lastname").val();
    user["phone"] = $("#telephone").val();
    user["email"] = $("#email").val();

    if ($("#new-password").val() != $("#confirm-password").val()) {
        throwMessage($('#error-password').val());
        return;
    }

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