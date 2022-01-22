import React from "react"

class AddTodo extends React.Component {
    constructor(props) {
        super(props);
        this.state = { item: { title:"" } };
        this.add = props.add;
    }

    onInputChange = (e) => {
        const thisItem = this.state.item;
        thisItem.title = e.target.value;
        this.setState({ item:thisItem} )
        console.log(thisItem)
    }

    onButtonClick = () => {
        this.add(this.state.item);
        this.setState({item:{title:""}});
    }

    render() {
        return (
            <div className="addTodo">
                <input
                    type="text"
                    placeholder="Add Todo here"
                    onChange={this.onInputChange}
                    value={this.state.item.title}
                />
                <input type="button" value="+" onclick={this.onButtonClick}/>
            </div>
        );
    }
}

export default AddTodo;