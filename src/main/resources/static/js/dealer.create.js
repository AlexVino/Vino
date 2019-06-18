$(document).ready(function () {

    $('#add').click(function () {
        var data = {};
        addIfNotEmpty(data,         'username',     $('#filter_models').find('li a.selected').text());
        addIfNotEmpty(data,         'make',         $('#filter_makes').find('li a.selected').text());
        addIfNotEmptyForTitle(data, 'bodystyle',    $('#filter_bodystyle').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'transmission', $('#filter_transmission').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'fuelType',     $('#filter_fueltype').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'color',        $('#filter_color').find('li a.selected'));
        addIfNotEmpty(data,         'price',        $('#price').val());
        addIfNotEmpty(data,         'mileage',      $('#mileage').val());
        addIfNotEmpty(data,         'enginevolume', $('#enginevolume').val());
        addIfNotEmpty(data,         'description',  $('#description').val());
        addIfNotEmpty(data,         'year',         $('#year').val());

        addIfNotEmpty(data,         'vin',          $('#vin').val());
        addIfNotEmpty(data,    'complectationName', $('#complectation').val());
        addIfNotEmptyForTitle(data, 'headlight',    $('#filter_headlights').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'drivetype',    $('#filter_drivetype').find('li a.selected'));
        addIfNotEmpty(data,         'rrPrice',      $('#rrPrice').val());
        addIfNotEmpty(data,         'horsepower',   $('#horsepower').val());
        addIfNotEmpty(data,         'maxspeed',     $('#maxspeed').val());
        addIfNotEmpty(data,    'commonconsumption', $('#commonconsumption').val());
        addIfNotEmpty(data,      'cityconsumption', $('#cityconsumption').val());
        addIfNotEmpty(data,     'routeconsumption', $('#routeconsumption').val());
        addIfNotEmpty(data,         'acceleration', $('#acceleration').val());
        addIfNotEmpty(data,         'length',       $('#length').val());
        addIfNotEmpty(data,         'width',        $('#width').val());

        addIfNotEmpty(data,         'electricheatingofthewindshield', document.getElementById("myonoffswitchElectricheatingofthewindshield").checked);
        addIfNotEmpty(data,         'electricheatingofsidemirrors',   document.getElementById("myonoffswitchElectricheatingofsidemirrors").checked);
        addIfNotEmpty(data,         'headlightwashersystem',          document.getElementById("myonoffswitchHeadlightwashersystem").checked);
        addIfNotEmpty(data,         'rainsensor',                     document.getElementById("myonoffswitchRainsensor").checked);
        addIfNotEmpty(data,         'foglight',                       document.getElementById("myonoffswitchFoglight").checked);
        addIfNotEmpty(data,         'bluetooth',                      document.getElementById("myonoffswitchBluetooth").checked);
        addIfNotEmpty(data,         'usb',                            document.getElementById("myonoffswitchUSB").checked);
        addIfNotEmpty(data,         'aux',                            document.getElementById("myonoffswitchAUX").checked);
        addIfNotEmpty(data,         'navigationsystem',               document.getElementById("myonoffswitchNavigationsystem").checked);
        addIfNotEmpty(data,         'cruisecontrol',                  document.getElementById("myonoffswitchCruisecontrol").checked);
        addIfNotEmpty(data,         'parktronic',                     document.getElementById("myonoffswitchParktronic").checked);
        addIfNotEmpty(data,         'climatecontrol',                 document.getElementById("myonoffswitchClimatecontrol").checked);
        addIfNotEmpty(data,         'powerWindows',                   document.getElementById("myonoffswitchPowerWindows").checked);
        addIfNotEmpty(data,         'steeringadjustment',             document.getElementById("myonoffswitchsteeringadjustment").checked);

        data['image'] = $('#myimage').attr('src');

        // Отправляем запрос

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/ads",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (respond) {
                window.location.href = "/ads/" + respond.adId;
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
});




$(document).ready(function () {
    $("#add").click(function () {
        registerDealer();
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

function registerDealer() {
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

    $("#add").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/dealers",
        data: JSON.stringify(user),
        dataType: 'json',
        success: function (data) {
            if (data !== null) {
                window.location.href = "/";
            }
            $("#add").prop("disabled", false);
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
            $("#add").prop("disabled", false);
        }
    });
}