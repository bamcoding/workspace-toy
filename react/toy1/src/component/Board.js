import '../App.css';
import { useState } from 'react';

function board(props){
  console.log("board");
  console.log(props)

  return (
    <div>
      <div>{props.no}</div>
      <div>{props.title}</div>
      <div>{props.content}</div>
    </div>
  );
}

export default board;