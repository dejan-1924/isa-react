import React from 'react'
import { useRef, useContext } from 'react'
import AuthContext from '../store/auth-context';
import  { useEffect,useState } from 'react'

export const Home = () => {

    const authCtx = useContext(AuthContext);

    useEffect(() => {
        console.log("Korisnik je logovan : " + authCtx.isLoggedIn);
      }, []);


  return (
    <div><span>Home</span>
    <div>{authCtx.role}</div>

    </div>
  )
}
