import React from 'react'

class Loading extends React.Component {
    loginLink(){
        window.location.href = '/login';
    }

    render() {
        return (
            <div className="App">
                <h1> 서버에 접근하실 수 없습니다.  </h1>
                <p onClick={this.loginLink}>로그인하러 가기</p>
            </div>
        )
    }
}

export default Loading