import React from 'react';
/*import Board from './board/Board';*/
import './App.css';
import Todo from './components/Todo/Todo';
import AddTodo from "./components/Todo/AddTodo";

class App extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            items:[
                {id:0, title:"Hello World 1", done: true},
                {id:2, title:"Hello World 2", done: false},
            ]
        };
    }

    add = (item) => {
        const thisItems = this.state.items;
        item.id = "ID-"+thisItems.length;
        item.done = false;
        thisItems.push(item);
        this.setState({items:thisItems})
        console.log("items : ",this.state.items)
    }

    render() {
        const todoItems = this.state.items.map((item,idx) => (
            <Todo item={item} key={item.id} />
        ));

        return (
            <div className="App">
                <AddTodo add={this.add} />
                <div className="TodoList">
                    {todoItems}
                </div>
            </div>
        )
    }
}
    /*  constructor(props) {
    super(props);
    this.state = {
      items : [
        {id:1,title:"하하1",content:"내용1"},
        {id:2,title:"하하2",content:"내용2"},
        {id:3,title:"하하3",content:"내용3"},
      ],
    };
  }

  render() {
    let appTitle = `자바스크립트에서 HTML을 함께 사용하는 문법은 JSX라고 한다.
    빌드 시에 Babel이라는 트랜스파일러 라이브러리가 자바스크립트로 변환하여 브라우저에게 준다.`;
    
    let boardList = this.state.items.map((board, idx) => {
      return <Board item={board} key={board.id}/>
    });

    return (
      <div className="App">
        <div>{appTitle}</div>
        <div id="divBoard">{boardList}</div>
      </div>
    );
  }
}*/

export default App;
