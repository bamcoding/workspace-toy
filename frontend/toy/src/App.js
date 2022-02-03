import React from 'react';
import './App.css';
import Todo from './components/Todo/Todo';
import {Paper, List, Container} from "@material-ui/core";
import AddTodo from "./components/Todo/AddTodo";
import { call } from "./service/ApiService";

class App extends React.Component {
    constructor(props){
        super(props);
        this.state = {items:[]}
    }

    componentDidMount = (item) => {
        call("/todo/v1/list","GET",item).then((response) => {
            this.setState({items: response.todoVOList});
        });
    }

    add = (item) => {
        call("/todo/v1/save","POST",item).then((response) =>
            this.setState({items:response.data})
        );
    }

    update = (item) => {
        call("/todo/v1/save","PUT",item).then((response) =>
            this.setState({items:response.data})
        );
    }

    delete = (item) => {
        const thisItems = this.state.items;
        console.log("Before Update Items : ", thisItems)
        console.log("Before Update Items : ", thisItems.length)
        const newItems = thisItems.filter(e => e.seq !== item.seq);
        this.setState({ items: newItems }, () => {
            console.log("Update Items : ",this.state.items)
            console.log("Update Items : ",this.state.items.length)
        });
    }

    render() {
        console.log("items : ",this.state.items);
        let todoItems = this.state.items !=null && this.state.items.length > 0 && (
            <Paper style={{ margin: 16 }}>
                <List>
                    {this.state.items.map((item, idx) => (
                        <Todo
                            item={item}
                            key={item.seq}
                            delete={this.delete}
                            update={this.update}
                        />
                    ))}
                </List>
            </Paper>
        );

        return (
            <div className="App">
                <Container maxWidth="md">
                    <AddTodo add={this.add} />
                    <div className="TodoList">
                        {todoItems}
                    </div>
                </Container>
            </div>
        )
    }
}

export default App;
