import { get } from "http";
import React, { useEffect, useState } from "react";
import { useRef, useContext } from "react";

export const Profile = () => {
  const [user, setUser] = useState<any>(null);
  const [edited, setEdited] = useState<any>(null);
  const [toggleEdit, setToggleEdit] = useState<any>(false);
  const cityInputRef = useRef<any>(null);

  useEffect(() => {
    fetch("http://localhost:8084/api/profile", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email: "donor1@gmail.com" }),
    })
      .then((response) => response.json())
      .then((actualData) => {
        console.log(actualData);
        setUser(actualData);
      });

    console.log(user);
  }, []);

  const editUserHandler = () => {
    setToggleEdit(true);
  };

  const closeEditHandler = () => {
    setToggleEdit(false);
  };
  const saveUserHandler = (event: any) => {
    const enteredCity = cityInputRef.current.value;
    event?.preventDefault();
    fetch("http://localhost:8084/api/profile/update", {
      method: "PUT",
      body: JSON.stringify({
        name: user.name,
        surname: user.name,
        city: enteredCity,
        email: user.email,
        country: user.country,
      }),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => {
        if (res.ok) {
          return res.json();
        }
      })
      .then((data) => {
        console.log(data);
      });
  };

  return (
    <>
      <button onClick={editUserHandler}>Edit</button>
      {!toggleEdit && (
        <div>
          <span>{user?.name}</span>
          <span>{user?.surname}</span>
          <span>{user?.address}</span>
          <span>{user?.city}</span>
          <span>{user?.country}</span>
          <span>{user?.ssn}</span>
        </div>
      )}
      {toggleEdit && (
        <div>
          <form onSubmit={saveUserHandler}>
            <input value={user.name}></input>
            <input value={user.email}></input>
            <input value={user.surname}></input>
            <input value={user.address}></input>
            <input ref={cityInputRef} defaultValue={user.city}></input>
            <button onClick={closeEditHandler}>Close</button>
            <button type="submit">Save</button>
          </form>
        </div>
      )}
    </>
  );
};
