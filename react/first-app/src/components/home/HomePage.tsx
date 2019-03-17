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

                <div>
                    <form>
                        <div className="form-group">
                            <label htmlFor="email">Email address:</label>
                            <input type="email" className="form-control" id="email"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="pwd">Password:</label>
                            <input type="password" className="form-control" id="pwd"/>
                        </div>
                        <button type="submit" className="btn btn-default btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        );
    }
}

export default HomePage;