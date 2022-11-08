import React from "react";
import { useState } from "react";

const AuthContext = React.createContext({
  role: "unauthorized",
  isLoggedIn: false,
  login: (role) => {},
  logout: () => {},
});

export const AuthContextProvider = (props) => {
  const [role, setRole] = useState("unauthorized");

  const userIsLoggedIn = true ? role != "unauthorized" : false;

  const loginHandler = (role) => {
    setRole(role);
    console.log(role);
  };
  const logoutHandler = (role) => {
    setRole("unauthorized");
  };

  const contextValue = {
    role: role,
    isLoggedIn: userIsLoggedIn,
    login: loginHandler,
    logout: logoutHandler,
  };

  return (
    <AuthContext.Provider value={contextValue}>
      {props.children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
