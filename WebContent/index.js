const parent = document.querySelector("body");
const popBox = document.createElement("div");

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

function displayErrorMessage() {
     var msg = window.localStorage.getItem("msgErr");
     if(parseCookies().msg != undefined || parseCookies().msgErr != undefined){
          if(msg != undefined && msg != "" && msg != null){
               window.localStorage.removeItem("msgErr");
          }
          return;
     }else{
          if(msg != undefined && msg != "" && msg != null){
               console.log(msg);
               parent.appendChild(popBox);
               popBox.classList.add("fail-pop");
               popBox.innerHTML = msg;
               setTimeout(function() {
                    parent.removeChild(popBox);
               }, 3000);
               window.localStorage.removeItem("msgErr");
          }
     }
     
}

function getPathName(){
     var pathname = window.location.pathname;
     var pathArr = pathname.split('/');
     return pathArr[pathArr.length - 1];
}

function authorizationFilter(){
     var path = getPathName();
     console.log(path);
     var cookies = parseCookies();
     const { role } = cookies;
     var msg = "";
     if(path === ""){
          window.location.replace("index.html");
     }

     if(role === "admin"){
          return;
     }
     switch(path){
          case "apply.html":
          case "onlineRegistration.html":
          case "academics.html":
               if(role != "student"){
                    msg = "Must be Student to access this page";
               }
               break;
          case "media.html":
          case "research.html":
               if(role != "teacher"){
                    msg = "Must be teacher to access this page";
               }
               break;
          default:
               return;
     }

     if(msg != ""){
          window.location.replace("login.html");
          window.localStorage.setItem("msgErr", msg);
     }
}

(() => {
     displayLoginBtns();
     getServerMessage();
     authorizationFilter();
     displayErrorMessage();
} )();

window.onpopstate = () => {
     displayErrorMessage();
     authorizationFilter();
}
