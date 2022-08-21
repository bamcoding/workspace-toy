import React,{useState} from 'react';
import './App.css';

function App() {

  let [boardList] = useState([
    {
      title:'1',
      date:'2022/08/19',
      content:'111111'
    },
    {
      title:'2',
      date:'2022/08/19',
      content:'22222'
    },
    {
      title:'3',
      date:'2022/08/19',
      content:'3333333'
    },
  ]);


  return (
    <div className="App">
      <div className="black-nav">
        <div>개발1 Blog</div>        
      </div>
      <div className='board_list'>
        {boardList.map((b)=> {
           return <Board boardInfo = {b} />
        })}

      </div>
    </div>
  );
}

function Board(prop){
  return (
    <div className='board'>
      <h2>{prop.boardInfo.title}</h2>
      <p>{prop.boardInfo.date}</p>
      <p>{prop.boardInfo.content}</p>
    </div>
  );
}

export default App;
