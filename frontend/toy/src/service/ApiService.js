import { API_BASE_URL } from "../app-config";
const ACCESS_TOKEN = "ACCESS_TOKEN";

export function call(api, method, request) {
    let headers = new Headers({
        "Content-Type" : "application/json",
    });

    const accessToken = localStorage.getItem(ACCESS_TOKEN);

    if(accessToken){
       headers.append('Authorization','Bearer ' + accessToken);
    }

    let options = {
        headers : headers,
        url : API_BASE_URL + api,
        method: method,
    };

    if(request) {
        options.body = JSON.stringify(request);
    }

    return fetch(options.url, options)
        .then((response) => response.json().then((json) => {
            console.log("then2");
            console.log(response);
            console.log(json);
            if (!response.ok) {
                 return Promise.reject(json);
            }
            return json;
        }))
        .catch((error) => {
            console.log(error);
            alert(error.status);
            window.location.href = "/login"
        });
}

export function signin(userDTO) {
    return call("/auth/signin", "POST", userDTO)
        .then((response) => {
            console.log("response : ", response);
            if(response.token) {
                alert("로그인 토큰: " + response.token);
                localStorage.setItem(ACCESS_TOKEN,response.token)
                window.location.href = "/";
            }
        });
}
