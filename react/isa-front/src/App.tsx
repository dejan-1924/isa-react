import React from 'react';
import './App.css';
import {Route,Routes,Navigate} from "react-router-dom"
import Layout from "./pages/Layout"
import { Home } from './pages/Home';
import { Centers } from './pages/Centers';
import Login from './pages/Login';
import { Register } from './pages/Register';
import { Profile } from './pages/Profile';
import { useRef, useContext } from 'react'
import AuthContext from './store/auth-context';



function App() {

  const authCtx = useContext(AuthContext);
  
  return (
    <div className="App">
      <Routes>
      <Route path="/login" element={<Login></Login>}></Route>
      <Route path="/register" element={<Register></Register>}></Route>
        <Route path="" element={<Layout></Layout>}>
        <Route path="/home" element={<Home></Home>}></Route>
        <Route path="/centers" element={<Centers></Centers>}></Route>
        {authCtx.isLoggedIn &&  <Route path="/profile" element={<Profile></Profile>}></Route>}
        </Route>
    <Route path="*" element={<Navigate to="/" replace />}></Route>
      </Routes>
    </div>
  );
}

export default App;
