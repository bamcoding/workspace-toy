import Board from './component/Board';
import shoesData from './shoesData';
import { a ,b } from './testdata';
import { useState } from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import './App.css';
import database from './firebase';
import { collection, getDocs, query, where, orderBy, QuerySnapshot } from "firebase/firestore";
//import logo from './img/logo_coupang.png';

function App() {
  const boardCollectionRef = collection(database, "board");
  const q = query(boardCollectionRef);

  getDocs(q).then((qs)=>{
    qs.forEach((doc)=>{
      console.log(doc.data());
    })
  })

  let boardTempList = [1,2,3,4];

  
  //let[boards] = useState(boardList);

  return (
    <div className="App">
      <Navbar bg="white" variant="dark" className="navbar">
        <Navbar.Brand href="#home">
          <div className="category-btn">
            <p>카테고리</p>
          </div>
        </Navbar.Brand>
        <div>
          <Nav className="me-auto">
            <div>
              <a href="/">
                <img src="/logo_coupang.png" width="170" height="40" alt="쿠팡로고"/>
              </a>
            </div>
            <Form>
              <Form.Group className="header-searchForm" controlId="headerSearchKeyword">
                <Form.Control type="text" placeholder="찾고 싶은 상품을 검색해보세요!" />
              </Form.Group>
            </Form>
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </div>
      </Navbar>
      <div className="banner-main"></div>

      <div className="container-list">
        {
          boardTempList.map((t)=><Board shoeData={t}/>)
        }
      </div>
    </div>
  );
}

export default App;