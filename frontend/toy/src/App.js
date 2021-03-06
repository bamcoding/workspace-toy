import React from 'react';
import './App.css';
import Todo from './components/todo/Todo';
import {Paper, List, Container, AppBar, Toolbar, Grid, Typography, Button} from "@material-ui/core";
import AddTodo from "./components/todo/AddTodo";
import { signout, call } from "./service/ApiService";
import Loading from "./components/common/Loading";


class App extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            items:[]
            ,loading:true
        }
    }

    componentDidMount = (item) => {
        call("/todo","GET",item).then((response) => {
            this.setState({items: response.data,loading: false});
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

        let navigationBar = (
            <AppBar position="static">
                <Toolbar>
                    <Grid justifyContent="space-between" container>
                        <Grid item>
                            <Typography variant="h6">오늘의 할일</Typography>
                        </Grid>
                        <Grid>
                            <Button color="inherit" onClick={signout}>
                                로그아웃
                            </Button>
                        </Grid>
                    </Grid>
                </Toolbar>
            </AppBar>
        );

        let todoListPage = (
            <div className="App">
                {navigationBar}
                <Container maxWidth="md">
                    <AddTodo add={this.add} />
                    <div className="TodoList">
                        {todoItems}
                    </div>
                </Container>
            </div>
        );

        let content = <Loading />;

        if(!this.state.loading) {
            content = todoListPage;
        }

        return <div className="App">{content}</div>
    }
}

export default App;
