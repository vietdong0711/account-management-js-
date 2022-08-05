var listAccout = [];
var listDepartment = [];
var listPosition = [];
var indexUpdate = "";

//Khai báo các biến lưu thông tin
var curentPage = 1;
var currentSize = 5;
var totalPage;
var sort = "id,asc";
var search = "";

//Lấy dữ liệu ở localstogate
var accountLocalStogare = JSON.parse(localStorage.getItem("accountLogin"));
var userLo = accountLocalStogare.userName;
var passLo = accountLocalStogare.password;
$(function () {
  search = "";
  //load dữ liệu API rồi đổ lên table
  fetchListAccountAPI();
  getListDepartment();
  getListPosition();
  //Xử lí nút reset
  $("#resetBtn").click(function (e) {
    $("#idID").val("");
    $("#emailID").val("");
    $("#usernameID").val("");
    $("#departmentID").val("");
    $("#positionID").val("");
    $("#fullnameID").val("");
    $("#createdateID").val("");
  });

  // $("#id").attr("dis", "dís");
  //Xử lí nút save
  // $("#saveBtn").click(function (e) {
  //     e.preventDefault();

  // });
  $("#formID").submit(function (e) {
    //b1: lấy dữ liệu
    var v_id = $("#idID").val();
    var v_email = $("#emailID").val();
    var v_username = $("#usernameID").val();
    var v_fullname = $("#fullnameID").val();
    var v_department = $("#departmentID").val();
    var v_position = $("#positionID").val();
    var v_createdate = $("#createdateID").val();

    // {
    //     "Email": "Email 1",
    //     "Username": "Username 1",
    //     "FullName": "FullName 1",
    //     "Department": "Department 1",
    //     "Position": "Position 1",
    //     "CreateDate": "CreateDate 1",
    //     "AccountID": "1"
    //   },
    //b2: đóng vào đối tượng
    var account = {
      email: v_email,
      userName: v_username,
      fullName: v_fullname,
      departmentId: v_department,
      positionId: v_position,
      password: "123456",
    };

    callAPICheckEmail(v_email)
      .then(function (mes) {
        return callAPICheckUsename(v_username);
      })
      .then(function (mes) {
        $.ajax({
          type: "POST",
          url: "http://localhost:8080/api/v1/account",
          data: JSON.stringify(account),
          contentType: "application/json; charset=UTF-8",
          beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
          },
          success: function (response) {
            fetchListAccountAPI();
            alert("Tạo tài khoản thành công, mật khẩu mặc định là 123456");
          },
          error: function (error) {
            alert("false");
          },
        });
      })
      .catch(function (mes) {
        alert(mes);
        console.log(mes);
        return true;
      });

    // //b3: lưu vào array
    // listAccout.push(account);
    // console.log("list", listAccout);
    //show dữ liệu
    // showAccout();
    e.preventDefault();
  });
});

function showAccout() {
  $("#tableBodyID").empty();
  for (let i = 0; i < listAccout.length; i++) {
    $("#tableBodyID").append(
      `<tr>
            <td>${listAccout[i].id}</td>
            <td>${listAccout[i].email}</td>
            <td>${listAccout[i].userName}</td>
            <td>${listAccout[i].fullName}</td>
            <td>${listAccout[i].departmentName}</td>
            <td>${listAccout[i].positionName}</td>
            <td>${listAccout[i].createDate}</td>
            <td>
            <button type="button" class="btn btn-large btn-block btn-warning bt" onclick="handleEdit(${i})">Edit</button>
            </td>
            <td>
            <button type="button" class="btn btn-large btn-block btn-warning bt" onclick="handleDelete(${listAccout[i].id})" >Delete</button>
            </td>
        </tr>`
    );
  }
}
//Hàm delete account
function handleDelete(i) {
  //console.log("index ", i);
  var confirmDel = confirm("Bạn có muốn xóa ko");
  if (confirmDel) {
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/api/v1/account/" + i,
      beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
      },
      success: function (response) {
        fetchListAccountAPI();
      },
      error: function (error) {
        alert("Xóa không thành công");
      },
    });
  }
}
//Hàm update account
function handleEdit(ii) {
  $("#emailID").attr("disabled", "disabled");
  $("#usernameID").attr("disabled", "disabled");
  $("#idID").val(listAccout[ii].id);
  $("#emailID").val(listAccout[ii].email);
  $("#usernameID").val(listAccout[ii].userName);
  $("#fullnameID").val(listAccout[ii].fullName);
  var idDep = listDepartment.find((department) => department.name == listAccout[ii].departmentName).id;
  // for (let i = 0; i < listDepartment.length; i++) {
  //   if (listDepartment[i].name === listAccout[ii].departmentName) {
  //     idDep = listDepartment[i].id;
  //   }
  // }

  var idPo = listPosition.find((position) => position.name == listAccout[ii].positionName).id;
  // for (let i = 0; i < listPosition.length; i++) {
  //   if (listPosition[i].name === listAccout[ii].positionName) {
  //     idPo = listPosition[i].id;
  //   }
  // }
  $("#departmentID").val(idDep);
  $("#positionID").val(idPo);

  $("#createdateID").val(listAccout[ii].createDate);
  indexUpdate = ii;
}

$("#updateBtn").click(function (e) {
  //Lấy thông tin người dùng cập nhật
  var v_id = $("#idID").val();
  var v_email = $("#emailID").val();
  var v_username = $("#usernameID").val();
  var v_fullname = $("#fullnameID").val();
  var v_department = $("#departmentID").val();
  var v_position = $("#positionID").val();
  var v_createdate = $("#createdateID").val();

  var account = {
    email: v_email,
    userName: v_username,
    fullName: v_fullname,
    departmentId: v_department,
    positionId: v_position,
  };
  console.log(account);

  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/v1/account/update/" + v_id,
    data: JSON.stringify(account),
    contentType: "application/json; charset=UTF-8",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
    },
    success: function (response) {
      fetchListAccountAPI();
    },
    error: function (error) {
      alert("cập nhật không thành công");
    },
  });

  // $.ajax({
  //   type: "PUT",
  //   url: "https://6289b2b1e5e5a9ad321bfaab.mockapi.io/AccountAPI",
  //   data: account,
  //   dataType: "json",
  //   success: function (response) {
  //     fetchListAccountAPI();
  //     alert("Đúng");
  //   },
  // });

  e.preventDefault();
});

function fetchListAccountAPI() {
  var urlGet = `http://localhost:8080/api/v1/account?size=${currentSize}&page=${curentPage}&sort=${sort}&search=${search}`;
  if (search == "") {
    urlGet = `http://localhost:8080/api/v1/account?size=${currentSize}&page=${curentPage}&sort=${sort}`;
  }
  //call API
  $.ajax({
    type: "GET",
    url: urlGet,
    dataType: "JSON",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
    },
    success: function (response) {
      listAccout = [];
      listAccout = response.content;
      //console.log(response);
      //chuyeern đổi response về listAccount
      //   response.forEach((element) => {
      //     var account = {
      //       AccountID: response.AccountID,
      //       Email: response.Email,
      //       Username: response.Username,
      //       FullName: response.FullName,
      //       Department: response.Department,
      //       Position: response.Position,
      //       CreateDate: response.CreateDate,
      //     };
      //     // add vào list account
      //     listAccout.push(account);
      //   });

      showAccout();
      totalPage = response.totalPages;
      generateButtonPaging();
      // $("#pagination").empty();
      // for (let i = 0; i < totalPage; i++) {
      //   $("#pagination").append(`<li><a  onclick="handlePage(${i + 1})">${i + 1}</a></li>`);
      // }
    },
  });
}

function getListPosition() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/position",
    dataType: "JSON",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
    },
    success: function (response) {
      listPosition = [];
      listPosition = response;
      for (let i = 0; i < listPosition.length; i++) {
        $("#positionID").append(`<option value="${listPosition[i].id}">${listPosition[i].name}</option>`);
      }
    },
  });
}

function getListDepartment() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/department",
    dataType: "JSON",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
    },
    success: function (response) {
      listDepartment = [];
      listDepartment = response;
      for (let i = 0; i < listDepartment.length; i++) {
        $("#departmentID").append(`<option value="${listDepartment[i].id}">${listDepartment[i].name}</option>`);
      }
    },
  });
}

function handlePage(page) {
  if (curentPage == page) {
    return;
  }
  curentPage = page;
  fetchListAccountAPI();
}
// chọn trang
function generateButtonPaging(totalPageParam) {
  var pagingString = "";
  for (let i = 0; i < totalPage; i++) {
    if (curentPage == i + 1) {
      pagingString += `<li class="active"><a  onclick="handlePage(${i + 1})">${i + 1}</a></li>`;
    } else {
      pagingString += `<li><a  onclick="handlePage(${i + 1})">${i + 1}</a></li>`;
    }
  }
  $("#pagination").empty();
  $("#pagination").append(pagingString);
}

// chỉnh size
function change(selecttag) {
  // if ($("#setSizePage").val() == currentSize) {
  //   return;
  // }
  // currentSize = $("#setSizePage").val();

  var sizeP = selecttag.value;
  if (currentSize == sizeP) {
    return;
  }
  currentSize = sizeP;
  fetchListAccountAPI();
}

function changeSortField(params) {
  var sortA = params.value + "," + $("#sortDirection").val();
  console.log(sortA);
  if (sortA == sort) {
    return;
  }
  sort = sortA;
  fetchListAccountAPI();
}

function changeSortDirection(params) {
  var sortA = $("#field").val() + "," + params.value;
  console.log(sortA);
  if (sortA == sort) {
    return;
  }
  sort = sortA;
  fetchListAccountAPI();
}

$("#search").keyup(function (e) {
  search = $(this).val().trim();
  fetchListAccountAPI();
});

//Hàm xử lí khi click Login
function handleLogin() {
  var usernameInput = $("#usename").val();
  var passwordInput = $("#password").val();

  var urlGet = `http://localhost:8080/api/v1/login`;

  //call API
  $.ajax({
    type: "GET",
    url: urlGet,
    dataType: "JSON",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(`${usernameInput}:${passwordInput}`));
    },
    success: function (response) {
      //login thành công
      var accountLogin = {
        userName: response.userName,
        password: passwordInput,
        fullname: response.fullName,
        email: response.email,
      };
      localStorage.setItem("accountLogin", JSON.stringify(accountLogin));
      alert("Login thành công");
      window.open("./index.html", "_self");
    },
    error: function (response) {
      alert("Sai thông tin đăng nhập");
    },
  });
}

function handleLogout() {
  localStorage.removeItem("accountLogin");
  window.open("./Login.html", "_self");
}

function handleRegister() {
  window.open("./Register.html", "_self");
}

function callAPICheckEmail(v_email) {
  return new Promise(function (resolve, reject) {
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/api/v1/account/checkEmail?email=" + v_email,
      dataType: "JSON",
      beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
      },
      success: function (response) {
        if (response == true) {
          reject("Email này đã tồn tại");
        } else {
          resolve();
        }
      },
      error: function (response) {
        alert("false");
      },
    });
  });
}
function callAPICheckUsename(v_username) {
  return new Promise(function (resolve, reject) {
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/api/v1/account/checkUsername?username=" + v_username,
      dataType: "JSON",
      beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Basic " + btoa(`${userLo}:${passLo}`));
      },
      success: function (response) {
        if (response == false) {
          reject("Username này đã tồn tại");
        } else {
          resolve();
        }
      },
      error: function (response) {
        alert("false");
      },
    });
  });
}
