import { useState } from 'react';
import { Container, NavBar } from '../../pages/FormRegister/style.js';
import { insertUser } from '../../api'
import './form.css'

export function FormRegister() {
  const [ userData, setUserData ] = useState(
    {
      name: "",
      phone: "",
      bornDate: "",
      documentList: []
    }
  );

  const [ rg, setRg ] = useState()
  const [ cpf, setCpf ] = useState()
  const [ cnh, setCnh ] = useState()

  function handleRg({ target }) {
    const { name, value, } = target;
    setRg({ ...rg, [ name ]: value, })
  }

  function handleCpf({ target }) {
    const { name, value, } = target;
    setCpf({ ...cpf, [ name ]: value, })
  }

  function handleCnh({ target }) {
    const { name, value, } = target;
    setCnh({ ...cnh, [ name ]: value, })
  }

  function handleInputChange({ target }) {
    const { name, value, } = target;
    setUserData({ ...userData, [ name ]: value, })
  }

  function handleClick(event) {
    event.preventDefault();

    if (rg) {
      userData.documentList.push({
        docType: Object.keys(rg)[ 0 ],
        description: Object.values(rg)[ 0 ]
      })
    }

    if (cpf) {
      userData.documentList.push({
        docType: Object.keys(cpf)[ 0 ],
        description: Object.values(cpf)[ 0 ]
      })
    }

    if (cnh) {
      userData.documentList.push({
        docType: Object.keys(cnh)[ 0 ],
        description: Object.values(cnh)[ 0 ]
      })
    }

    setUserData({
      ...userData,
    })

    insertUser(userData);
    setUserData({
      name: "",
      phone: "",
      bornDate: "",
      documentList: []
    })
  }

  return (
    <>
      <NavBar>
        <h1>Ekan</h1>
        <h2>
          Lista de beneficiarios
        </h2>
      </NavBar >
      <Container>
        <form>
          <label for="name">Nome:</label>
          <input type="text" id="name" name="name"
            onChange={(event) => handleInputChange(event)} required
          />

          <label for="phone">Telefone:</label>
          <input type="tel" id="phone" name="phone"
            onChange={(event) => handleInputChange(event)} required
          />

          <label for="birthdate">Data de Nascimento:</label>
          <input type="date" id="birthdate" name="birthdate"
            onChange={(event) => handleInputChange(event)} required
          />

          <label for="RG">RG:
            <input type="text" id="RG" name="RG"
              onChange={(event) => handleRg(event)}
            />
          </label>
          <label for="CPF">CPF:
            <input type="text" id="CPF" name="CPF"
              onChange={(event) => handleCpf(event)}
            />
          </label>
          <label for="CNH">CNH:
            <input type="text" id="CNH" name="CNH"
              onChange={(event) => handleCnh(event)}
            />
          </label>
          <button
            type="button"
            value="Cadastrar"
            onClick={(event) => handleClick(event)} >Cadastrar</button>
        </form>
      </Container >
    </>
  );
}