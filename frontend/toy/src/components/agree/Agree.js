import React from 'react';
import {Paper, List, ListItem, Checkbox, Button} from "@material-ui/core";

class Agree extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items:[
                {agreeNo:`1`,agreeTitle:`토이 그룹웨어 이용약관 동의`,agreeContent:`상세내용`,optionYn:`Y`},
                {agreeNo:`2`,agreeTitle:`개인정보 수집 및 이용 동의`,agreeContent:`상세내용`,optionYn:`Y`},
                {agreeNo:`3`,agreeTitle:`위치정보 이용약관 동의`,agreeContent:`상세내용`,optionYn:`N`},
                {agreeNo:`4`,agreeTitle:`프로모션 정보 수신 동의`,agreeContent:`상세내용`,optionYn:`N`}
            ]
        };
    }


    makeAgree(item) {
        let optionTxt = item.optionYn === "Y" ? "(필수) " : "(선택) ";
        return (
            <ListItem
                key={item.agreeNo}
                button={true}
            >
                <Checkbox
                    id={item.agreeNo}
                    name={item.agreeNo}
                />
                <label htmlFor={item.agreeNo}>{optionTxt + item.agreeTitle}</label>
            </ListItem>
        );
    }
    render(){
        let agreeList = this.state.items.length > 0 && (
            <Paper style={{margin:16}}>
                <List>
                    {this.state.items.map((item) => this.makeAgree(item))}
                </List>
                <Button>다음</Button>
            </Paper>
        )
        return agreeList;
    }
}

export default Agree