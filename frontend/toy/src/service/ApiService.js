import { API_BASE_URL } from "../app-config";

export function signin(userDTO) {
    return call("/auth/signin", "POST", userDTO)
        .then((response) => {
            console.log("response : ", response);
            if(response.token) {
                alert("로그인 토큰: " + response.token);
                window.location.href = "/";
            }
    });
}

export function call(api, method, request) {
    let options = {
        headers : new Headers({
            "Content-Type" : "application/json",
        }),
        url : API_BASE_URL + api,
        method: method,
    };

    if(request) {
        options.body = JSON.stringify(request);
    }

    return fetch(options.url, options)
        .then((response) =>
            response.json().then((json) => {
                console.log(response);
                if (!response.ok) {
                    return Promise.reject(json);
                }
                return json;
            })
        )
        .catch((error) => {
           alert(error);
           window.location.href = "/login"
           return Promise.reject(error);
        });
}