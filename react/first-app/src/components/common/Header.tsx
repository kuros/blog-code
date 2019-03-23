import React, {FunctionComponent} from "react";
import {NavLink} from "react-router-dom";
import './Header.css'

const Header: FunctionComponent = () => {

    const activeStyle = {color: '#F15B2A'}
    return (
        <nav className='space'>
            <NavLink to='/' activeStyle={activeStyle}  exact >Home</NavLink> { " | "}
            <NavLink to='/books' activeStyle={activeStyle} >Books</NavLink> { " | "}
            <NavLink to='/about' activeStyle={activeStyle} >About</NavLink>
        </nav>
    )
};

export default Header;