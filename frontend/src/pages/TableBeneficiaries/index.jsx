import { Container, NavBar } from "./style";
import './table.css'
import { getAll } from "../../api"

export function TableBeneficiaries() {
  const datas = [
    {
      id: 1,
      name: 'João',
      phone: '(11) 99999-9999',
      birthdate: '01/01/2000',
      createdAt: '01/01/2022',
      updatedAt: '01/02/2022',
    },
    {
      id: 2,
      name: 'Maria',
      phone: '(11) 88888-8888',
      birthdate: '02/02/2000',
      createdAt: '02/02/2022',
      updatedAt: '03/03/2022',
    },
  ];

  return (
    <>
      <NavBar>
        <h1>Ekan</h1>
        <h2>
          Registrar novo beneficiario
        </h2>
      </NavBar >
      <Container>
        <h1>Tabela de Dados</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Telefone</th>
              <th>Data de Nascimento</th>
              <th>Data de Inclusão</th>
              <th>Data de Atualização</th>
            </tr>
          </thead>
          <tbody>
            {datas.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.phone}</td>
                <td>{item.birthdate}</td>
                <td>{item.createdAt}</td>
                <td>{item.updatedAt}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </Container>
    </>
  );
}