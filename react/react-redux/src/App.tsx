import React, {Component} from 'react';
import './App.css';
import HomePage from "./components/home/HomePage";
import {BrowserRouter, Route} from "react-router-dom";
import AboutPage from "./components/about/AboutPage";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./components/common/Header";

class App extends Component {
    render() {
        return (
            <div className='container'>
                <BrowserRouter>
                    <Header/>
                    <Route exact path='/' component={HomePage}/>
                    <Route path='/about' component={AboutPage}/>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
