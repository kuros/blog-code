import React, {Component} from "react";
import {Link} from "react-router-dom";

class HomePage extends Component {

    render() {
        return (
            <div>
                <div className='jumbotron'>
                    <p>Welcome to your first React App</p>
                    <Link to='about'  className="btn btn-primary btn-lg" >More</Link>
                </div>
            </div>
        );
    }
}

export default HomePage;