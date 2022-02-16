import React from 'react';
import './index.css';
import App from './App';
import Login from './components/login/Login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Error from './components/common/Error';
import SignUp from "./components/login/SignUp";

function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {"Copyright "}
            leegunj, {new Date().getFullYear()}
            {"."}
        </Typography>
    );
}

class AppRouter extends React.Component {
    render() {
        return (
            <div>
                <BrowserRouter>
                    <div>
                        <Routes>
                            <Route path="/login" element={<Login/>} />
                            <Route path="/signup" element={<SignUp/>} />
                            <Route path="/" element={<App/>}/>
                            <Route path="/error" element={<Error/>}/>
                        </Routes>
                    </div>
                    <Box mt={5}>
                        <Copyright/>
                    </Box>
                </BrowserRouter>
            </div>
        );
    }
}

export default AppRouter;