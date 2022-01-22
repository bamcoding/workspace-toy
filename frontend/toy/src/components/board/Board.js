import React from 'react'

class Board extends React.Component {
  constructor(props) {
    super(props);
    this.state = {item:props.item};
  }

  render() {
    return (
        <div>제목: {this.state.item.title} / 내용: {this.state.item.content}</div>
    );
  }
}

export default Board