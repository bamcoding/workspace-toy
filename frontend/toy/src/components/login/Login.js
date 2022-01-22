import React from 'react'

class Login extends React.Component {
    render() {
        let login = () => {
            console.log("로그인");
        }
        
        return (
            <div id="divLogin">
                <div>로그인</div>
                <div>
                    <label htmlFor="id">아이디: </label><input type="text" id="id"/>
                </div>
                <div>
                    <label htmlFor="id">비밀번호: </label><input type="text" id="id"/>
                </div>
                <div>
                    <label htmlFor="keepLogin">로그인 상태유지: </label><input type="checkbox" id="keepLogin"/>
                </div>
                <div>
                    <input type="button" onClick={login()} onKeyPress={login()} value={"로그인"}/>
                </div>
                <div>
                    <button>비밀번호 찾기</button>
                    <button>아이디 찾기</button>
                    <button>회원가입 찾기</button>
                </div>
            </div>
    )
  }
}

export default Login;