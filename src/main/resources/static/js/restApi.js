console.log('restApi!!!!');
// 보통 프론트 프레임워크에서는 이렇게 가져온다
// const a = require(axios);

// 하지만 우리는 아직 프레임워크가 아니기떄문에 해당스크립트 위에 axios를 선언후에 대충 쓴다
console.log(axios);
var test = 'restApi.js';
// console.log("token",token);

const restApi = axios.create({
    baseURL: 'http://localhost:8080/',
    timeout: 1000,
    headers: { }
});

restApi.interceptors.request.use(
    function (config) {
        // JWT 토큰 가져오기
        let token = getCookie("jwt_token");
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    function (error) {
        return Promise.reject(error);
    }
);

// 응답 전 interceptors 설정
restApi.interceptors.response.use(
    function (response) {
        return response;
    },
    function (error) {
        return Promise.reject(error);
    }
);

// 쿠키 설정 함수
function setCookie(name, value, days) {
    let expires = "";
    if (days) {
        let date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "") + expires + "; path=/";
}

// 쿠키 가져오기 함수
function getCookie(name) {
    let cookieName = name + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let cookieArray = decodedCookie.split(';');
    for (let i = 0; i < cookieArray.length; i++) {
        let cookie = cookieArray[i];
        while (cookie.charAt(0) === ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(cookieName) === 0) {
            return cookie.substring(cookieName.length, cookie.length);
        }
    }
    return "";
}
