import api from './api';
import {authHeader} from '../helpers/auth-header';

const register = (name, email, password, roleIds) => {
	const roles = roleIds.map(id => ({id}));
	const userData = {
		user: {
			name,
			email,
			password,
			isEnabled: true,
		},
		roles,
	};
	return api.post('/auth/register', userData);
};

const login = (email, password) => {
	return api.post('/auth/login', {email, password}).then((response) => {
		console.log(response.data.data);
		if (response.data.data.token) {
			localStorage.setItem('user', JSON.stringify(response.data));

		}
		return response.data;
	});
};

const getAllRoles = () => {
	console.log(api.get('/auth/roles', {headers: authHeader()}));
	return api.get('/auth/roles', {headers: authHeader()});
};

const logout = () => {
	localStorage.removeItem('user');
};

export default {register, login, logout, getAllRoles};
