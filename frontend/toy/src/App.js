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
        call("/todo","GET",item).then((response) => {
            this.setState({items: response.data});
        });
    }

    add = (item) => {
        call("/todo","POST",item).then((response) =>
            this.setState({items:response.data})
        );
    }

    update = (item) => {
        call("/todo","PUT",item).then((response) =>
            this.setState({items:response.data})
        );
    }

    delete = (item) => {
        call("/todo","DELETE",item).then((response) =>
            this.setState({items:response.data})
        );
    }

    render() {
        console.log("items : ",this.state.items);
        let todoItems = this.state.items !=null && this.state.items.length > 0 && (
            <Paper style={{ margin: 16 }}>
                <List>
                    {this.state.items.map((item, idx) => (
                        <Todo
                            item={item}
                            key={item.id}
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
