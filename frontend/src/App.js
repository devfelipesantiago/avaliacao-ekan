import { Route, Switch } from 'react-router';
import { Login } from './pages/login';
import { FormRegister } from './pages/FormRegister';
import { TableBeneficiaries } from './pages/TableBeneficiaries';
import { Redirect } from 'react-router-dom/cjs/react-router-dom.min';

function App() {
  return (
    <Switch>
      <Route exact path='/'>
        <Redirect to='/login' />
      </Route>
      <Route path='/login' component={Login} />
      <Route path='/register' component={FormRegister} />
      <Route path='/beneficiaries' component={TableBeneficiaries} />
    </Switch>
  );
}

export default App;
