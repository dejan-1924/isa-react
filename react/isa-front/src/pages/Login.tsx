import React from 'react'
import { useRef, useContext } from 'react'
import AuthContext from '../store/auth-context';
import {useNavigate } from "react-router-dom";

const Login = () => {
    let navigate = useNavigate();
const emailInputRef = useRef<any>();
const passwordInputRef = useRef<any>();

const authCtx = useContext(AuthContext);



const sumbitHandler = (event:any) => {
    event?.preventDefault();
    const enteredEmail= emailInputRef.current.value;
    const enteredPassword = passwordInputRef.current.value;
    console.log(enteredEmail);
    fetch("http://localhost:8084/api/login", {
        method: "POST",
        body: JSON.stringify({
            email: enteredEmail,
            password: enteredPassword
        }),
        headers: { 
            'Content-Type': 'application/json',
        
        },
    }).then( res => {
        if(res.ok){
            return res.json();
        }
    }).then((data) => {
        authCtx.login(data.role);

            if(data.role != "unauthorized"){
            navigate('/home', {replace: true});
        }
            else{
                alert("Log in failed")
            }
            
            
    })
}

  return (
    <div>
        <form onSubmit={sumbitHandler}>
        <label>Email</label>
        <input ref= {emailInputRef}></input>
        <label>Password</label>
        <input type="password" ref= {passwordInputRef}></input>
        <button type='submit'>Log in</button>
        </form>
    </div>
  )
}

export default Login