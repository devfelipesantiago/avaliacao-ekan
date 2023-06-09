import { shape } from 'prop-types'
import { useContext, useState } from 'react';
import { AppContext } from './AppContext';

export function AppProvider({ children }) {
  const [ userData, setUserData ] = useState({
    email: '',
    password: '',
  });

  const context = {
    userData, setUserData
  }

  return (
    <AppContext.Provider value={context}>
      {children}
    </AppContext.Provider>
  )
}

AppProvider.propTypes = {
  children: shape().isRequired,
};

export const useAppContext = () => useContext(AppContext);