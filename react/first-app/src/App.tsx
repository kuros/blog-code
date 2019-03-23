import React, {Component} from 'react';
import './App.css';
import HomePage from "./components/home/HomePage";
import {Route, Switch} from "react-router-dom";
import AboutPage from "./components/about/AboutPage";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./components/common/Header";
import NotFoundPage from "./NotFoundPage";
import BookPage from "./components/book/BookPage";

class App extends Component {
    render() {
        return (
            <div className='container'>
                <Header/>
                <Switch>
                    <Route exact path='/' component={HomePage}/>
                    <Route path='/about' component={AboutPage}/>
                    <Route path='/books' component={BookPage}/>
                    <Route component={NotFoundPage}/>
                </Switch>
            </div>
        );
    }
}

export default App;
