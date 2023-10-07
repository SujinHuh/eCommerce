import axios from 'axios';
import cookie from 'react-cookies';

const token = cookie.load('accessToken');

const instance = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 3000
});

instance.interceptors.request.use(
    function (config) {
        if(token !== undefined){
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    function (error) {
        return Promise.reject(error);
    }
);

instance.interceptors.response.use(
    function (response) {
        return response;
    },

    function (error) {
        return error;
    }
);

export default instance;