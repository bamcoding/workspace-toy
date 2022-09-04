import '../App.css';
import { useState } from 'react';

function board(props){
  console.log("board");
  console.log(props)

  return (
    <div className="board">
      <div>{props.shoeData}</div>
      <div>{props.shoeData}</div>
      <div>{props.shoeData}</div>
    </div>
  );
}

export default board;