import axios from 'axios';

const URL = 'http://localhost:8080'

const getAll = () => {
  axios.get(`${URL}/beneficiaries`)
    .then(function (response) {
      console.log(response.data);
      return response.data;
    })
    .catch(function (error) {
      console.log(error);
    })
}

const insertUser = (data) => {
  axios.post(`${URL}/beneficiaries/`, data)
    .then((response) => {
      console.log(response)
    }).catch((error) => {
      console.log(error, error.message);
    })
}

export { axios, insertUser, getAll };