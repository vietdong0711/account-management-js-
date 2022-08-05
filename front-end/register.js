function handleRegisterAccount() {
  var account = {
    email: $("#emailID").val(),
    userName: $("#usernameID").val(),
    fullName: $("#fullnameID").val(),
    departmentId: 1,
    positionId: 1,
    password: $("#password").val(),
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/v1/account",
    data: JSON.stringify(account),
    contentType: "application/json; charset=UTF-8",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa("Username1:123456"));
    },
    success: function (response) {
      alert("Register succesfully");
      window.open("Login.html", "_self");
    },
    error: function (error) {
      alert("error");
    },
  });
}
