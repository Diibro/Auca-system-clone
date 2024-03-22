
function parseCookies() {
     var cookies = {};
     var cookieString = document.cookie;
     cookieString.split(';').forEach(function(cookie) {
          var parts = cookie.split('=');
          var name = parts[0].trim();
          var value = parts[1];
          cookies[name] = value;
     });
     return cookies;
}

function displayLoginBtns(){
     let loginEle = document.getElementById("loginBtn");
     let logoutEle = document.getElementById("logoutBtn");
     const cookie = parseCookies();
     if(cookie.email === undefined || cookie.email == ""){
          logoutEle.style.display = "none"
          loginEle.style.display = "inline-flex"
     }else{
          loginEle.style.display = "none"
          logoutEle.style.display = "inline-flex"
     }
}

function getServerMessage(){
     const parent = document.querySelector("body");
     const popBox = document.createElement("div");
     parent.appendChild(popBox);
     const cookie = parseCookies();
     popBox.classList.add("pop-box")
     if(cookie.msg != undefined && cookie.msg != ""){
          popBox.classList.add("success-pop");
          popBox.innerHTML = cookie.msg.split("-").join(" ");
          setTimeout(function() {
               parent.removeChild(popBox);
          }, 3000);
          return;
     }

     if(cookie.msgErr != undefined && cookie.msgErr != ""){
          popBox.classList.add("fail-pop");
          popBox.innerHTML = cookie.msgErr.split("-").join(" ");
          setTimeout(function() {
               parent.removeChild(popBox);
          }, 3000);
     }
}

function getPathName(){
     var pathname = window.location.pathname;
     var pathArr = pathname.split('/');
     return pathArr[pathArr.length - 1];
}

function authorizationFilter(){
     var path = getPathName();
     if(path === ""){
          window.location.replace("login.html");
     }
}

(() => {
     displayLoginBtns();
     getServerMessage();
     authorizationFilter();
} )();
