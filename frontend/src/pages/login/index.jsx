import { Redirect } from 'react-router-dom'
import React, { useState, useEffect } from 'react';
import { useAppContext } from '../../context/AppProvider'
import './style.css';

export function Login() {
  const [ redirect, setRedirect ] = useState(false);
  const [ isDataValid, setIsDataValid ] = useState();
  const { userData, setUserData } = useAppContext();
  const [ route, setRoute ] = useState('');

  function handleInputChange({ target }) {
    const { name, value } = target;
    setUserData({ ...userData, [ name ]: value });
  }

  useEffect(() => {
    const { email, password } = userData;
    const emailValidated = /^[\S.]+@[a-z]+\.\w{2,3}$/g.test(email);
    const passwordRegex = new RegExp(/[\w\D]{6}/g).test(password);

    if (emailValidated && passwordRegex) {
      setIsDataValid(false);
    } else {
      setIsDataValid(true);
    }
  }, [ userData ]);

  const handleError = () => {
    setRoute('/beneficiaries')
    setRedirect(true);
  };

  return (
    <>
      <form className="px-5 py-7 login-container">
        <h1 className="login-title">Ekan</h1>
        <section>
          <label htmlFor="input-email" className="label-email">
            E-mail
            <input
              type="text"
              name="email"
              className="input-email"
              onChange={handleInputChange}
              data-testid="common_login__input-email"
            />
          </label>
          <label htmlFor="label-password" className="label-password">
            Password
            <input
              type="text"
              name="password"
              className="input-password"
              onChange={handleInputChange}
              data-testid="common_login__input-password"
            />
          </label>
        </section>
        <div className="buttons-login-container">
          <button
            type="button"
            name="login"
            className="login-button"
            data-testid="common_login__button-login"
            disabled={isDataValid}
            onClick={() => handleError()}
          >
            Login
          </button>
        </div>
      </form >
      {redirect && <Redirect to={route} />
      }
    </>
  );
}