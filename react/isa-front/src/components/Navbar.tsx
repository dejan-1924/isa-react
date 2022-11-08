import React from 'react'
import {NavLink} from "react-router-dom"
import "./Navbar.css"
import { useRef, useContext } from 'react'
import AuthContext from '../store/auth-context';
import  { useEffect,useState } from 'react'

const Navbar = () => {

    const authCtx = useContext(AuthContext);


const logoutHandler = () => {
    authCtx.logout();
}


  return (
    <div className="navbar">
      <ul>
        <li>
          <NavLink to="/home" className="NavLink">
            Home
          </NavLink>
        </li>
        <li>
          <NavLink to="/centers" className="NavLink">
            Centers
          </NavLink>
        </li>
        {authCtx.isLoggedIn && <li>
          <NavLink to="/profile" className="NavLink">
            Profile
          </NavLink>
        </li>}
        {!authCtx.isLoggedIn && <li>
          <NavLink to="/login" className="NavLink">
            Login
          </NavLink>
        </li>}
        {!authCtx.isLoggedIn && <li>
          <NavLink to="/register" className="NavLink">
            Register
          </NavLink>
        </li>}
        {authCtx.isLoggedIn && <li>
    <button onClick={logoutHandler}>Logout</button>
        </li>}
      </ul>
    </div>
  )
}

export default Navbar